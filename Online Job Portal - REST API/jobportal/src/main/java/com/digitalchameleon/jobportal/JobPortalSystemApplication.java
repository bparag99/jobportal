package com.digitalchameleon.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.digitalchameleon.jobportal.modal.Admin;



@SpringBootApplication
@EnableJpaRepositories
public class JobPortalSystemApplication implements Runnable {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalSystemApplication.class, args);
	}

	@Override
	public void run() {
		// Create an ADMIN Login Since we are using In-Memory Database
		Admin admin = new Admin();
		admin.setFirstName("Parag");
		admin.setLastName("Bajaj");
		admin.setPassword("admin");
		admin.setUserName("admin");
		
//		admin.set
//		admin.setName
		
		
		
	}

}
