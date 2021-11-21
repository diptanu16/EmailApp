package com.app.EmailApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.MidiMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendmailWithAttachment(String toEmail, String body, String subject,String attachment) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("diptanudnath@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        File att = new File(attachment);
        FileSystemResource fileSystemResource = new FileSystemResource(att);
        mimeMessageHelper.addAttachment(att.getName(), fileSystemResource);
        javaMailSender.send(mimeMessage);

        System.out.println("Email sent succesfully");

    }
}
