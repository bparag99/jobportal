package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotEmpty;

public class RecruiterDTO {

	@NotEmpty(message = "userName cannot be empty")
	private String userName;
	@NotEmpty(message = "first name cannot be empty")
	private String firstName;
	@NotEmpty(message = "last name cannot be empty")
	private String lastName;
	@NotEmpty(message = "password cannot be blank")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RecruiterDTO [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}

	public RecruiterDTO() {
		super();
	}

	public RecruiterDTO(@NotEmpty(message = "userName cannot be empty") String userName,
			@NotEmpty(message = "first name cannot be empty") String firstName,
			@NotEmpty(message = "last name cannot be empty") String lastName,
			@NotEmpty(message = "password cannot be blank") String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

}
