package com.mycompany.mail;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class DefaultEmailSender extends MailFactory{
	
	@Override
	 public boolean sendMail() {
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	
	    Session session = Session.getDefaultInstance(props,
	    new javax.mail.Authenticator() {
                 @Override
	         protected PasswordAuthentication getPasswordAuthentication() 
	         {
	               return new PasswordAuthentication(sender, password);
	         }
	    });
	    /** Ativa Debug para sessao */
	    session.setDebug(true);
	    try {
	
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress(sender)); //Remetente
	
	          Address[] toUser = InternetAddress //Destinatario(s)
	                     .parse(email);  
	          message.setRecipients(Message.RecipientType.TO, toUser);
	          message.setSubject(subject);//Assunto
	          message.setText(content);
	          /**Metodo para enviar a mensagem criada*/
	          Transport.send(message);
	          return true;
	         } catch (MessagingException e) {
	        	 return false;
	    }
	}

	
}
