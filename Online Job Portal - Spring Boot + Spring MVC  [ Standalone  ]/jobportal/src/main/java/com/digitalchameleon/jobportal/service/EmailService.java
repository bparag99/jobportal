package com.digitalchameleon.jobportal.service;

 
// Interface
public interface EmailService {
 
    // Method
    // To send a simple email

	String sendSimpleMail(String message, String email, String subject);

}