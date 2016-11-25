package org.openfact.ubl;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DefaultUblSenderResponseProviderFactory implements UblSenderResponseProviderFactory {

	@Override
	public UblSenderResponseProvider create(OpenfactSession session) {
		return new DefaultUblSenderResponseProvider(session);
	}

	@Override
	public void init(Scope config) {

	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {

	}

	@Override
	public void close() {

	}

	@Override
	public String getId() {
		return "default";
	}

}
