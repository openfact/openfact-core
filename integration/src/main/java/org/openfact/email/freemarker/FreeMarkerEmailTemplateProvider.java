/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.email.freemarker;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.keycloak.common.util.ObjectUtil;
import org.openfact.email.EmailException;
import org.openfact.email.EmailFileModel;
import org.openfact.email.EmailSenderProvider;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.EmailUserModel;
import org.openfact.email.freemarker.beans.EventBean;
import org.openfact.email.freemarker.beans.ProfileBean;
import org.openfact.events.Event;
import org.openfact.events.EventType;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.beans.MessageFormatterMethod;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FreeMarkerEmailTemplateProvider implements EmailTemplateProvider {

    private final Map<String, Object> attributes = new HashMap<>();

    private FreeMarkerUtil freeMarker = new FreeMarkerUtil();
    private OrganizationModel organization;
    private EmailUserModel user;

    private List<EmailFileModel> attachments;   

    @Override
    public EmailTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public EmailTemplateProvider setUser(EmailUserModel user) {
        this.user = user;
        return this;
    }

    @Override
    public EmailTemplateProvider setAttribute(String name, Object value) {
        attributes.put(name, value);
        return this;
    }

    @Override
    public EmailTemplateProvider setAttachments(List<EmailFileModel> attachments) {
        this.attachments = attachments;
        return this;
    }

    @Override
    public void sendEvent(Event event) throws EmailException {
        /*Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", new ProfileBean(user));
        attributes.put("event", new EventBean(event));

        send(toCamelCase(event.getType()) + "Subject", "event-" + event.getType().toString().toLowerCase() + ".ftl", attributes);*/
    }

    private String getOrganizationName() {
        if (organization.getDisplayNameHtml() != null) {
            return organization.getDisplayNameHtml();
        } else if (organization.getDisplayName() != null) {
            return organization.getDisplayName();
        } else {
            return ObjectUtil.capitalize(organization.getName());
        }
    }

    @Override
    public void send(String subjectKey, String template, Map<String, Object> attributes) throws EmailException {
        send(subjectKey, Collections.emptyList(), template, attributes);
    }

    private void send(String subjectKey, List<Object> subjectAttributes, String template, Map<String, Object> attributes) throws EmailException {
        /*try {
            ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
            Theme theme = themeProvider.getTheme(organization.getEmailTheme(), Theme.Type.EMAIL);
            Locale locale = organization.getDefaultLocale() != null ? new Locale(organization.getDefaultLocale()) : Locale.ENGLISH;
            attributes.put("locale", locale);
            Properties rb = theme.getMessages(locale);
            attributes.put("msg", new MessageFormatterMethod(locale, rb));
            String subject = new MessageFormat(rb.getProperty(subjectKey, subjectKey), locale).format(subjectAttributes.toArray());
            String textTemplate = String.format("text/%s", template);
            String textBody;
            try {
                textBody = freeMarker.processTemplate(attributes, textTemplate, theme);
            } catch (final FreeMarkerException e) {
                textBody = null;
            }
            String htmlTemplate = String.format("html/%s", template);
            String htmlBody;
            try {
                htmlBody = freeMarker.processTemplate(attributes, htmlTemplate, theme);
            } catch (final FreeMarkerException e) {
                htmlBody = null;
            }

            send(subject, textBody, htmlBody);
        } catch (Exception e) {
            throw new EmailException("Failed to template email", e);
        }*/
    }

    private void send(String subject, String textBody, String htmlBody) throws EmailException {
        /*EmailSenderProvider emailSender = session.getProvider(EmailSenderProvider.class);
        if (attachments == null || attachments.isEmpty()) {
            emailSender.send(organization, user, subject, textBody, htmlBody);
        } else {
            emailSender.send(organization, user, subject, textBody, htmlBody, attachments);
        }*/
    }

    private String toCamelCase(EventType event) {
        StringBuilder sb = new StringBuilder();
        for (String s : event.name().toString().toLowerCase().split("_")) {
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }

    private String toCamelCase(String event) {
        StringBuilder sb = new StringBuilder();
        for (String s : event.toLowerCase().split("_")) {
            sb.append(ObjectUtil.capitalize(s));
        }
        return sb.toString();
    }

    @Override
    public void sendDocument(DocumentModel invoice) throws EmailException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("user", user.getFullName());
        attributes.put("organizationName", getOrganizationName());

        StringBuilder subject = new StringBuilder();
        if (organization.getDisplayName() != null) {
            subject.append(organization.getDisplayName());
        } else {
            subject.append(organization.getName());
        }
        subject.append("/").append(toCamelCase(invoice.getDocumentType())).append(" ").append(invoice.getDocumentId());
        send(subject.toString(), "document.ftl", attributes);
    }

}