package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CreditNoteSendEventModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CreditNoteSendEventEntity;

public class CreditNoteSendEventAdapter implements CreditNoteSendEventModel, JpaModel<CreditNoteSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(CreditNoteSendEventAdapter.class);

	protected OrganizationModel organization;
	protected CreditNoteSendEventEntity creditNoteSendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public CreditNoteSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			CreditNoteSendEventEntity creditNoteSendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.creditNoteSendEvent = creditNoteSendEvent;
	}

	@Override
	public String getId() {
		return creditNoteSendEvent.getId();
	}

	@Override
	public boolean getResult() {
		return creditNoteSendEvent.isResult();
	}

	@Override
	public void setResult(boolean result) {
		creditNoteSendEvent.setResult(result);
	}

	@Override
	public String getDescription() {
		return creditNoteSendEvent.getDescription();
	}

	@Override
	public void setDescription(String description) {
		creditNoteSendEvent.setDescription(description);
	}

	@Override
	public OrganizationModel getOrganization() {
		if (creditNoteSendEvent.getOrganization() == null) {
			return null;
		}
		return new OrganizationAdapter(session, em, creditNoteSendEvent.getOrganization());
	}

	@Override
	public CreditNoteSendEventEntity getEntity() {
		return creditNoteSendEvent;
	}

	@Override
	public CreditNoteModel getCreditNote() {
		if (creditNoteSendEvent.getCreditNote() == null) {
			return null;
		}
		return new CreditNoteAdapter(session, organization, em, creditNoteSendEvent.getCreditNote());
	}

	@Override
	public void setCreditNote(CreditNoteModel creditNote) {
		creditNoteSendEvent.setCreditNote(CreditNoteAdapter.toEntity(creditNote, em));
	}

	public static CreditNoteSendEventEntity toEntity(CreditNoteSendEventModel model, EntityManager em) {
		if (model instanceof CreditNoteSendEventAdapter) {
			return ((CreditNoteSendEventAdapter) model).getEntity();
		}
		return em.getReference(CreditNoteSendEventEntity.class, model.getId());
	}
}