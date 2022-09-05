package com.digitalchameleon.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.modal.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Long> {
	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id, CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active) from Job j order by j.id")
	public List<Object> findAllDTO();

	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id,CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active) from Job j where j.active = true order by j.id")
	public List<Object> findAllActiveDTO();

	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id,CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active) from Job j where j.skill.name=:skill order by j.id")
	public List<Object> findBySkill(@Param("skill") String skill);

}
