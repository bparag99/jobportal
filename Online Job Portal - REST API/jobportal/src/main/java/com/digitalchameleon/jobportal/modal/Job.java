package com.digitalchameleon.jobportal.modal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Job implements Serializable {

	private static final long serialVersionUID = -7946011744287965252L;

	@Id
	@Column(name = "job_id", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seq")
	@SequenceGenerator(name = "job_seq", sequenceName = "job_seq", allocationSize = 1)
	private Long id;

	private String jobTitle;

	private String jobDescription;

	@OneToOne(targetEntity = Skill.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Skill skill;

	@ManyToOne(targetEntity = Recruiter.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "recruiter_id")
	private Recruiter postedBy;

	private LocalDate postedDate = LocalDate.now(ZoneId.of("GMT+05:30"));

	@OneToOne(targetEntity = Freelancer.class, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Freelancer awardedTo;

	@OneToMany(mappedBy = "job", targetEntity = JobApplication.class, cascade = { CascadeType.MERGE,
			CascadeType.REFRESH })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<JobApplication> jobApplications;

	private Boolean active;

}
