package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {

	@NotEmpty(message = "userName cant be empty")
	private String userName;
	@NotEmpty(message = "firstName cant be empty")
	private String firstName;
	@NotEmpty(message = "lastName cant be empty")
	private String lastName;
	@NotEmpty(message = "Password cant be empty")
	private String password;
}
