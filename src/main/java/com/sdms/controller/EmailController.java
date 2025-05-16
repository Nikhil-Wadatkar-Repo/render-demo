package com.sdms.controller;

import com.sdms.entity.DBFile;
import com.sdms.entity.EmailDTO;
import com.sdms.helper.EmailService;
import com.sdms.repo.DBFileRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    	@PostMapping("/send-email")
	public String sendEmail(
							@RequestParam("file") MultipartFile file, @RequestParam String to, @RequestParam String subject,@RequestParam String cc, @RequestParam String description) {


		try {
			emailService.sendEmailWithAttachment(to, subject, description, file);
			return "Email sent successfully!";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Failed to send email.";
		}
	}
}
