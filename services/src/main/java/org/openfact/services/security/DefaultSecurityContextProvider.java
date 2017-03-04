package org.openfact.services.security;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.Resource;
import org.openfact.services.resource.security.SecurityContextProvider;
import org.openfact.services.resource.security.ClientUser;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Stateless
@Alternative
public class DefaultSecurityContextProvider implements SecurityContextProvider {

    @Inject
    private OrganizationProvider provider;

    @Override
    public List<OrganizationModel> getPermitedOrganizations(OpenfactSession session) {
        return provider.getOrganizations();
    }

    @Override
    public ClientUser getClientUser(OpenfactSession session) {
        return new ClientUser() {

            @Override
            public String getUsername() {
                HttpServletRequest httpServletRequest = session.getContext().getContextObject(HttpServletRequest.class);
                return httpServletRequest.getUserPrincipal().getName();
            }

            @Override
            public boolean hasOrganizationRole(String role) {
                return true;
            }

            @Override
            public boolean hasOneOfOrganizationRole(String... roles) {
                return true;
            }

            @Override
            public boolean hasAppRole(String role) {
                return true;
            }

            @Override
            public boolean hasOneOfAppRole(String... roles) {
                return true;
            }

            @Override
            public OrganizationAuth organizationAuth(Resource resource) {
                return new DefaultOrganizationAuth();
            }
        };
    }

    public class DefaultOrganizationAuth implements OrganizationAuth {

        public DefaultOrganizationAuth() {
        }

        @Override
        public void requireAny() {
        }

        @Override
        public boolean hasView() {
            return true;
        }

        @Override
        public boolean hasManage() {
            return true;
        }

        @Override
        public void requireView() {
        }

        @Override
        public void requireManage() {
        }

    }

}
