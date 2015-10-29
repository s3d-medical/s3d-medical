package com.s3d.webapps.framework.mail.impl;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.framework.AppConfiguration;
import com.s3d.webapps.framework.mail.Mail;
import com.s3d.webapps.framework.mail.MailManager;
import com.s3d.webapps.framework.mail.MailTemplate;
import com.s3d.webapps.framework.mail.MailTemplateKey;
import com.s3d.webapps.util.FreeMarkerUtil;

@Service("mailServiceMgr")
public class MailManagerImpl extends AbstractBaseServiceMgr implements
		MailManager {

	public Mail newMail(boolean isHtmlBody) {
		return new MailImpl(isHtmlBody);
	}

	public void sendMail(Mail mail) throws EmailException {
		if (mail == null)
			return;
		MailImpl mailImpl = (MailImpl) mail;
		HtmlEmail htmlEmail = mailImpl.getMail();
		
		System.out.println("Send mail: " + htmlEmail.getSubject());
		htmlEmail.send();
		mailImpl.clear();
	}

	public void sendMail(Mail mail, MailTemplate template) throws EmailException {
		if (mail == null || template == null || template.getBody() == null)
			return;
		MailImpl mailImpl = (MailImpl) mail;
		
		String subject = FreeMarkerUtil.template2String(template.getSubject(),
				mailImpl.getContentMap(), false);
		String msg =  FreeMarkerUtil.template2String(template.getBody(),
				mailImpl.getContentMap(), false);
		mailImpl.setSubject(subject);
		mailImpl.setMsg(msg);
		
		System.out.println("Send mail: " + subject);
		mailImpl.getMail().send();
		mailImpl.clear();
	}

	public void sendMail(Mail mail, MailTemplateKey vmTemplate)
			throws EmailException {
		MailTemplate template = getTemplateByName(vmTemplate.toString());
		this.sendMail(mail, template);
	}

	// private class MailAuthenticator extends Authenticator {
	//
	// protected String m_user = null;
	//
	// protected String m_password = null;
	//
	// public MailAuthenticator(String user, String password) {
	// m_user = user;
	// m_password = password;
	// }
	//
	// protected PasswordAuthentication getPasswordAuthentication() {
	// if (m_user != null && m_password != null)
	// return new PasswordAuthentication(m_user, m_password);
	// else
	// return null;
	// }
	// }

	private MailTemplate getTemplateByName(String name) {
		AppConfiguration config = AppConfiguration.getInstance();
		return config.getMailTemplate(name);
	}

}
