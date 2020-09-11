package com.poc.unicredit.ibm.email.mvp;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/email")
public class EmailController {

   @GetMapping("/tome")
   public String sendEmailToMe() throws AddressException, MessagingException, IOException {
      sendmailToMe();
      return "Email sent successfully";   
   }

   @PostMapping
   public String sendEmail(@RequestBody Email email) throws AddressException, MessagingException, IOException {
      sendNewEmail(email);

      return "Email sent successfully!\n";
      //return repository.save(email);
   }

   private void sendmailToMe() throws AddressException, MessagingException, IOException {
      String host = "smtp.mailtrap.io"; //"smtp.gmail.com";
      String username = "cf81801524b182"; //"mihai.mm.770@gmail.com";
      String password = "2755d7c4f4f5d6"; //"!starK!2019!";
      String port = "587"; // "465";

      Properties props = new Properties();
      /*
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587"); 
      */

      // new
      props.put("mail.smtp.user", username);
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", port);
      props.put("mail.debug", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.EnableSSL.enable", "true");
      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.setProperty("mail.smtp.socketFactory.fallbac k", "false");
      //props.setProperty("mail.smtp.port", port); //"465");
      props.setProperty("mail.smtp.socketFactory.port", port); //"465");
      // new

      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(username, false));
   
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mi.mardare@gmail.com"));
      msg.setSubject("Uni MVP email");
      msg.setContent("This a test email", "text/html");
      msg.setSentDate(new Date());
   
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent("Test text email body.", "text/html");
   
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      // MimeBodyPart attachPart = new MimeBodyPart();
   
      // attachPart.attachFile("/Users/mihaimardare/Downloads/logo_ro.svg");
      // multipart.addBodyPart(attachPart);
      msg.setContent(multipart);

      /* Transport.send(msg);    */
      // new
      Transport t = session.getTransport("smtp"); //"smtps");
      try {
         t.connect(host, username, password);
         t.sendMessage(msg, msg.getAllRecipients());
      } finally {
         t.close();
      }
      // new
   }

   private void sendNewEmail(Email email) throws AddressException, MessagingException, IOException {
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");
      
      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("mihai.mm.770@gmail.com", "!starK!2019!");
         }
      });
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(email.getFrom(), false));
   
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToAddress()));
      msg.setSubject(email.getTitle());
      msg.setContent("Test email content", "text/html");
      msg.setSentDate(new Date());
   
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(email.getMessageBody(), "text/html");
   
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      // MimeBodyPart attachPart = new MimeBodyPart();
   
      // attachPart.attachFile("/Users/mihaimardare/Downloads/logo_ro.svg");
      // multipart.addBodyPart(attachPart);
      msg.setContent(multipart);
      Transport.send(msg);   
   }

}