package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.DebitNoteSendEventModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.DebitNoteSendEventEntity;

public class DebitNoteSendEventAdapter implements DebitNoteSendEventModel, JpaModel<DebitNoteSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(DebitNoteSendEventAdapter.class);

	protected OrganizationModel organization;
	protected DebitNoteSendEventEntity debitNoteSendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public DebitNoteSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			DebitNoteSendEventEntity debitNoteSendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.debitNoteSendEvent = debitNoteSendEvent;
	}

	@Override
	public String getId() {
		return debitNoteSendEvent.getId();
	}

	@Override
	public boolean getResult() {
		return debitNoteSendEvent.isResult();
	}

	@Override
	public void setResult(boolean result) {
		debitNoteSendEvent.setResult(result);
	}

	@Override
	public String getDescription() {
		return debitNoteSendEvent.getDescription();
	}

	@Override
	public void setDescription(String description) {
		debitNoteSendEvent.setDescription(description);
	}

	@Override
	public OrganizationModel getOrganization() {
		if (debitNoteSendEvent.getOrganization() == null) {
			return null;
		}
		return new OrganizationAdapter(session, em, debitNoteSendEvent.getOrganization());
	}

	@Override
	public DebitNoteSendEventEntity getEntity() {
		return debitNoteSendEvent;
	}

	@Override
	public DebitNoteModel getDebitNote() {
		if (debitNoteSendEvent.getDebitNote() == null) {
			return null;
		}
		return new DebitNoteAdapter(session, organization, em, debitNoteSendEvent.getDebitNote());
	}

	@Override
	public void setDebitNote(DebitNoteModel debitNote) {
		debitNoteSendEvent.setDebitNote(DebitNoteAdapter.toEntity(debitNote, em));
	}

	public static DebitNoteSendEventEntity toEntity(DebitNoteSendEventModel model, EntityManager em) {
		if (model instanceof DebitNoteSendEventAdapter) {
			return ((DebitNoteSendEventAdapter) model).getEntity();
		}
		return em.getReference(DebitNoteSendEventEntity.class, model.getId());
	}
}