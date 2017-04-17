package com.mycompany.siapj1;

import com.mycompany.mail.MailFactory;
import com.mycompany.mail.MailMode;
import com.mycompany.interfaces.*;

public class ControladorSIAPJ {

    private final IValidadorProcesso validator = new ValidadorProcesso();
    private final IRepositorioProcessos repo = new RepositorioProcess();

    public boolean initProcesso(Processo proc) {
        return initProcesso(proc, MailMode.EMAIL);
    }

    public boolean initProcesso(Processo proc, MailMode mailmode) {
        boolean success = checkProcesso(proc);
        sendInfoByMail(proc, success, mailmode);
        if (success) {
            persistProcesso(proc);
        }
        return success;
    }

    private boolean checkProcesso(Processo proc) {
        return validator.validateProcess(proc);
    }

    private Processo persistProcesso(Processo proc) {
        //repo.addProcesso(proc);//Descomentar para guardar o processo no txt.
        return proc;
    }

    private void sendInfoByMail(Processo proc, boolean statusProcesso,
            MailMode mailmode) {
        MailFactory mail = MailFactory.getFactory(mailmode);

        if (statusProcesso) {
            mail.defineContent(proc.getContent());
            mail.defineSubject("Novo processo " + proc.getId());
            mail.defineSender("default_sender");
            mail.defineRecipient("juiz");
            mail.defineEmail("juiz@ita.com");
            mail.sendMail();
        } else {
            mail.defineContent("Erro");
            mail.defineSubject("Erro processo " + proc.getId());
            mail.defineSender("default_sender");
            mail.defineRecipient("default_sender");
            mail.defineEmail(proc.getEmail());
            mail.sendMail();
        }
    }
}
