package org.openfact.models.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.InvoiceIdEntity;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaInvoiceProvider extends AbstractHibernateStorage implements InvoiceProvider {

    protected static final Logger logger = Logger.getLogger(JpaInvoiceProvider.class);

    private static final String TYPE = "type";
    private static final String CURRENCY_CODE = "currencyCode";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaInvoiceProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, InvoiceType type, InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate) {
        return addInvoice(organization, customer, OpenfactModelUtils.generateId(), type, invoiceId, currencyCode, issueDate);
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, CustomerModel customer, String id, InvoiceType type, InvoiceIdModel invoiceId, String currencyCode, LocalDate issueDate) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }

        InvoiceEntity entity = new InvoiceEntity();
        entity.setId(id);
        entity.setType(type);
        entity.setCurrencyCode(currencyCode);
        entity.setIssueDate(issueDate);

        CustomerEntity customerEntity = em.find(CustomerEntity.class, customer.getId());
        InvoiceIdEntity invoiceIdEntity = em.find(InvoiceIdEntity.class, invoiceId.getId());
        OrganizationEntity organizationEntity = em.find(OrganizationEntity.class, organization.getId());

        entity.setCustomer(customerEntity);
        entity.setInvoiceId(invoiceIdEntity);
        entity.setOrganization(organizationEntity);

        em.persist(entity);
        em.flush();
        return new InvoiceAdapter(session, organization, em, entity);
    }

    @Override
    public InvoiceModel getInvoiceById(String id, OrganizationModel organization) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceById", InvoiceEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<InvoiceEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new InvoiceAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        InvoiceEntity invoiceEntity = em.find(InvoiceEntity.class, invoice.getId());
        if (invoiceEntity == null)
            return false;
        removeInvoice(invoiceEntity);
        return true;
    }

    private void removeInvoice(InvoiceEntity invoice) {
        String id = invoice.getId();
        em.createNamedQuery("deleteInvoiceAdditionalInformationByInvoice").setParameter("invoice", invoice).executeUpdate();
        em.createNamedQuery("deleteInvoiceLegalMonetaryTotalByInvoice").setParameter("invoice", invoice).executeUpdate();
        em.flush();
        // not sure why i have to do a clear() here. I was getting some messed
        // up errors that Hibernate couldn't
        // un-delete the UserEntity.
        em.clear();
        invoice = em.find(InvoiceEntity.class, id);
        if (invoice != null) {
            em.remove(invoice);
        }

        em.flush();
    }

    @Override
    public InvoiceModel getInvoiceBySetAndNumber(int set, int number, OrganizationModel organization) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceBySetAndNumber", InvoiceEntity.class);
        query.setParameter("set", set);
        query.setParameter("number", number);
        query.setParameter("organizationId", organization.getId());
        List<InvoiceEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new InvoiceAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("getAllInvoicesByOrganization", InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = new ArrayList<>();
        results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
        return invoices;
    }

    @Override
    public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization, Integer firstResult, Integer maxResults) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("searchForInvoice", InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("filterText", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = new ArrayList<>();
        results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
        return invoices;
    }

    @Override
    public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization) {
        return searchForInvoiceByAttributes(attributes, organization, -1, -1);
    }

    @Override
    public List<InvoiceModel> searchForInvoiceByAttributes(Map<String, String> attributes, OrganizationModel organization, Integer firstResult, Integer maxResults) {
        StringBuilder builder = new StringBuilder("select i from InvoiceEntity i where u.organizationId = :organizationId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            if (entry.getKey().equals(InvoiceModel.TYPE)) {
                attribute = "lower(i.type)";
                parameterName = JpaInvoiceProvider.TYPE;
            } else if (entry.getKey().equalsIgnoreCase(InvoiceModel.CURRENCY_CODE)) {
                attribute = "lower(i.currencyCode)";
                parameterName = JpaInvoiceProvider.CURRENCY_CODE;
            } 
            if (attribute == null)
                continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by i.id");
        String q = builder.toString();
        TypedQuery<InvoiceEntity> query = em.createQuery(q, InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(InvoiceModel.TYPE)) {
                parameterName = JpaInvoiceProvider.TYPE;
            } else if (entry.getKey().equalsIgnoreCase(InvoiceModel.CURRENCY_CODE)) {
                parameterName = JpaInvoiceProvider.CURRENCY_CODE;
            }
            if (parameterName == null)
                continue;
            query.setParameter(parameterName, "%" + entry.getValue().toLowerCase() + "%");
        }
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = new ArrayList<>();
        results.forEach(f -> invoices.add(new InvoiceAdapter(session, organization, em, f)));
        return invoices;
    }

    @Override
    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria) {
        SearchResultsModel<InvoiceEntity> entityResult = find(criteria, InvoiceEntity.class);
        List<InvoiceEntity> entities = entityResult.getModels();

        SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
        List<InvoiceModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<InvoiceModel> search(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel<InvoiceEntity> entityResult = findFullText(criteria, InvoiceEntity.class, filterText, TYPE, CURRENCY_CODE);
        List<InvoiceEntity> entities = entityResult.getModels();

        SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
        List<InvoiceModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public CustomerModel addCustomer(String registrationName) {
        return addCustomer(OpenfactModelUtils.generateId(), registrationName);
    }
    
    @Override
    public CustomerModel addCustomer(String id, String registrationName) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        
        CustomerEntity entity = new CustomerEntity();
        entity.setId(id);
        entity.setRegistrationName(registrationName);
        
        em.persist(entity);
        em.flush();
        return new CustomerAdapter(session, em, entity);
    }

    @Override
    public InvoiceIdModel addInvoiceId(int set, int number) {
        return addInvoiceId(OpenfactModelUtils.generateId(), set, number);
    }
    
    @Override
    public InvoiceIdModel addInvoiceId(String id, int set, int number) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        
        InvoiceIdEntity entity = new InvoiceIdEntity();
        entity.setId(id);
        entity.setSet(set);
        entity.setNumber(number);
        
        em.persist(entity);
        em.flush();
        return new InvoiceIdAdapter(session, em, entity);
    }

}
