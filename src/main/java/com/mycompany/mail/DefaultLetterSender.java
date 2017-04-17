package com.mycompany.mail;

class DefaultLetterSender extends MailFactory {

    @Override
    public boolean sendMail() {
        return true;
    }
    
}
