package com.digitalchameleon.jobportal.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class JobPortalExceptionController {

	@ExceptionHandler(value = DuplicateSkillException.class)
	public ResponseEntity<Object> handleException(DuplicateSkillException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = InvalidAdminException.class)
	public ResponseEntity<Object> handleException(InvalidAdminException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidFreelancerException.class)
	public ResponseEntity<Object> handleException(InvalidFreelancerException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidJobApplicationException.class)
	public ResponseEntity<Object> handleException(InvalidJobApplicationException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidJobException.class)
	public ResponseEntity<Object> handleException(InvalidJobException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidRecruiterException.class)
	public ResponseEntity<Object> handleException(InvalidRecruiterException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidSkillException.class)
	public ResponseEntity<Object> handleException(InvalidSkillException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = JobPortalValidationException.class)
	public ResponseEntity<Object> handleException(JobPortalValidationException exception) {
		return new ResponseEntity<>(exception.getMessages(), HttpStatus.BAD_REQUEST);
	}
}
