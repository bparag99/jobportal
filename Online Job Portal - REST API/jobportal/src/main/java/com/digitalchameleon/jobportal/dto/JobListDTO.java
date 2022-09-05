package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobListDTO {

	private Long jobId;
	private Long freelancerId;
	private String freelancerName;
	private Long skillId;
	private String skillName;
	private Long recruiterId;
	private String recruiterName;
	private String jobTitle;
	private String jobDescription;
	private boolean jobStatus;
}
