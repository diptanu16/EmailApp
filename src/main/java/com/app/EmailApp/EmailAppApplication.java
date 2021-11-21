package com.app.EmailApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailAppApplication implements CommandLineRunner {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(EmailAppApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public  void triggerEmail() throws Exception {
//		emailSenderService.sendmailWithAttachment("diptanudnath@rediffmail.com","This is Body","This mail is with attachment",
//				"src/main/resources/PORCHA.pdf");
//	}

	@Override
	public void run(String... args) throws Exception {
		emailSenderService.sendmailWithAttachment("diptanudnath@rediffmail.com","This is Body","This mail is with attachment",
				"src/main/resources/PORCHA.pdf");
	}
}
