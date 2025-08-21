package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.Enicarthage.ENTITIES.Email;
import tn.Enicarthage.SERVICES.EmailSenderService;

@RestController
@RequestMapping("/api/mails")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody Email email) {
        emailSenderService.sendSimpleEmail(email.getToEmail(), email.getSubject(), email.getBody());
    }
}
