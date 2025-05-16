package com.sdms.helper;

import com.sdms.entity.DBFile;
import com.sdms.repo.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class EmailService {
	  @Autowired
	    private JavaMailSender javaMailSender;

	@Autowired
	private DBFileRepository fileRepository;

	  public void sendEmailWithAttachment(String to, String subject, String text, MultipartFile file) throws MessagingException {
          MimeMessage mimeMessage = javaMailSender.createMimeMessage();
          MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
          helper.setTo(to);
          helper.setSubject(subject);
          helper.setText(text);
          helper.addAttachment(file.getOriginalFilename(), file);
          javaMailSender.send(mimeMessage);
      }
}
