package com.digitalchameleon.jobportal.modal;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"job_app_id", "freelancer_id"}))
public class JobApplication implements Serializable {

	private static final long serialVersionUID = -3361518011946574802L;

	@Id
	@Column(name = "job_app_id", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_app_seq")
	@SequenceGenerator(name = "job_app_seq", sequenceName = "job_app_seq", allocationSize = 1)
	private Long id;

	@ManyToOne(targetEntity = Job.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne(targetEntity = Freelancer.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinColumn(name="freelancer_id")
	private Freelancer freelancer;

	private LocalDateTime appliedDate = LocalDateTime.now();

	private String coverLetter;
}
