package com.s3d.webapps.framework.mail;

import org.apache.commons.mail.EmailException;

public interface MailManager{

	public void sendMail(Mail mail) throws EmailException;

	public void sendMail(Mail mail, MailTemplate template) throws EmailException;

	public void sendMail(Mail mail, MailTemplateKey vmTemplate)
			throws EmailException;

	public Mail newMail(boolean isHtmlBody);

}
