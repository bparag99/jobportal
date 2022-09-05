package com.digitalchameleon.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobApplicationsListDTO {

	private Long id;
	private Long jobId;
	private String jobTitle;
	private String coverLetter;
	private Long freelancerId;
	private String freelancerName;
	private String freelancerUName;
}
