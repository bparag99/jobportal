package com.digitalchameleon.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FreelancerListDTO {
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;

}
