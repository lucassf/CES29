package com.mycompany.mail;

import com.mycompany.mail.DefaultEmailSender;
import com.mycompany.mail.DefaultLetterSender;

public abstract class MailFactory {

    protected String subject;
    protected String content;
    protected String sender;
    protected String password;
    protected String recipient;
    protected String email;

    private static final MailFactory MAILSERVICE = new DefaultLetterSender();
    private static final MailFactory EMAILSERVICE = new DefaultEmailSender();

    public static MailFactory getFactory(MailMode mode) {
        MailFactory factory = null;
        switch (mode) {
            case LETTER:
                factory = MAILSERVICE;
                break;
            case EMAIL:
                factory = EMAILSERVICE;
        }
        return factory;
    }

    public abstract boolean sendMail();

    public String defineSubject(String subject) {
        this.subject = subject;
        return this.subject;
    }

    public String defineContent(String content) {
        this.content = content;
        return this.content;
    }

    public String defineSender(String sender) {
        this.sender = sender;
        return this.sender;
    }

    public String definePassword(String password) {
        this.password = password;
        return this.password;
    }
    
    public String defineRecipient(String recipient){
        this.recipient = recipient;
        return this.recipient;
    }
    
    public String defineEmail(String email){
        this.email = email;
        return this.email;
    }
}
