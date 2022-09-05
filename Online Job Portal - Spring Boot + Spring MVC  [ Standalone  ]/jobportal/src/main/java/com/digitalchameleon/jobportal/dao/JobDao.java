package com.digitalchameleon.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.modal.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Long> {

	// Used
	@Query("SELECT j from Job j WHERE j.postedBy.id=:id order by j.id")
	List<Job> findAllByRecruiter(@Param("id") Long id);

	@Query("SELECT j from Job j where j.active = true order by j.id")
	public List<Job> findAllActiveDTO();

	@Query(nativeQuery = true, value = "SELECT j.* FROM JOB_APPLICATION ja \r\n"
			+ "INNER JOIN JOB j ON j.JOB_ID = ja.JOB_ID \r\n"
			+ "INNER JOIN FREELANCER f ON f.FREELANCER_ID = ja.FREELANCER_ID \r\n" + "WHERE ja.FREELANCER_ID  = :frID")
	List<Job> findJobAppliedByFreelancerId(@Param("frID") Long frID);

//	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id, CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active, j.postedDate) from Job j order by j.id")
//	public List<Object> findAllDTO();

//	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id,CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active, j.postedDate) from Job j where j.skill.name=:skill order by j.id")
//	public List<Object> findBySkill(@Param("skill") String skill);
//
//	@Query("SELECT new com.digitalchameleon.jobportal.dto.JobListDTO(j.id, j.awardedTo.id, CONCAT(j.awardedTo.firstName,' ',j.awardedTo.lastName) as freelancerName, j.skill.id, j.skill.name, j.postedBy.id,CONCAT(j.postedBy.firstName,' ',j.postedBy.lastName) as recruiterName, j.jobTitle, j.jobDescription, j.active, j.postedDate) from Job j where j.awardedTo.id=:jId order by j.id")
//	public List<JobListDTO> findByFreelancerId(@Param("jId") Long frId);
//
//	@Query("SELECT j from Job j WHERE j.postedBy.id=:id order by j.id")
//	public List<Job> findByRecruiter(@Param("id") Long id);

	/**
	 * @return
	 */

}
