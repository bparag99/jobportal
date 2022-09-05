package com.digitalchameleon.jobportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.digitalchameleon.jobportal.dao.AdminDao;
import com.digitalchameleon.jobportal.modal.Admin;
import com.digitalchameleon.jobportal.service.impl.AdminServiceImpl;



@SpringBootApplication
@EnableJpaRepositories
public class JobPortalSystemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JobPortalSystemApplication.class, args);
	}
	

}
