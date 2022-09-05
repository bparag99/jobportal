package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobApplicationDTO {

	@NotNull(message = "Job ID cannot be blank")
	private Long jobId;
	@NotEmpty(message = "Cover Letter cannot be empty")
	private String coverLetter;
	
	private Long freelancerId;
}
