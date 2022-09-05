/**
 * 
 */
package com.digitalchameleon.jobportal.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalchameleon.jobportal.dao.AdminDao;
import com.digitalchameleon.jobportal.dto.AdminDTO;
import com.digitalchameleon.jobportal.expection.InvalidAdminException;
import com.digitalchameleon.jobportal.modal.Admin;
import com.digitalchameleon.jobportal.service.AdminService;

/**
 * @author Parag Bajaj
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public List<String> getLogs() {
		// TODO Auto-generated method stub
		File logFile = new File("src/main/resources/static/data/logs.txt");
		try {
			Scanner fileScannner = new Scanner(logFile);
			List<String> logs = new ArrayList<String>();
			while(fileScannner.hasNextLine()) {
				logs.add(fileScannner.nextLine());
			}
			fileScannner.close();
			Collections.reverse(logs);
			return logs;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Admin findById(Long id) {
		if (adminDao.existsById(id)) {
			return adminDao.findById(id).get();
		} else {
			throw new InvalidAdminException();
		}
	}

	@Override
	public Admin save(AdminDTO adminDto) {
		Admin admin = new Admin();
		String userName = adminDto.getUserName();
		String firstName = adminDto.getFirstName();
		String lastName = adminDto.getLastName();
		String password = adminDto.getPassword();
		if (!(firstName == null || lastName == null || password == null || userName == null)) {
			admin.setUserName(userName);
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			admin.setPassword(password);
			return adminDao.save(admin);
		} else
			throw new InvalidAdminException();

	}

	@Override
	public Admin update(Long id, AdminDTO adminDto) {
		if (adminDao.existsById(id)) {
			Admin admin = adminDao.findById(id).get();
			admin.setUserName(adminDto.getUserName());
			admin.setPassword(adminDto.getPassword());
			admin.setFirstName(adminDto.getFirstName());
			admin.setLastName(adminDto.getLastName());
			return adminDao.save(admin);
		} else {
			throw new InvalidAdminException();
		}
	}

	@Override
	public Admin findByUserName(String userName) {
		if (adminDao.existsByUserName(userName)) {
			return adminDao.findByUserName(userName);
		} else {
			throw new InvalidAdminException();
		}
	}
	@Override
	public void writeLogs(String message) {
		// TODO Auto-generated method stub
	
		try {
			String fileName = "src/main/resources/static/data/logs.txt";
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
			BufferedWriter out = new BufferedWriter( 
	                   new FileWriter(fileName, true)); 
	            out.write(df.format(date) +" : " + message +"\n"); 
	            out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
