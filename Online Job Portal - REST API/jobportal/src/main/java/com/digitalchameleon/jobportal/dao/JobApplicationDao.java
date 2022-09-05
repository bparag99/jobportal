/**
 * 
 */
package com.digitalchameleon.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.modal.JobApplication;

/**
 * @author bpara
 *
 */
@Repository
public interface JobApplicationDao extends JpaRepository<JobApplication, Long> {
	
	@Query("select new com.digitalchameleon.jobportal.dto.JobApplicationsListDTO(j.id, j.job.id, j.job.jobTitle, j.coverLetter, j.freelancer.id, CONCAT(j.freelancer.firstName,' ', j.freelancer.lastName), j.freelancer.userName)  from JobApplication j where j.job.id=:jobId  order by j.id")
	List<JobApplicationsListDTO> findAllByJobId(@Param("jobId") Long jobId);
	
	@Query("select new com.digitalchameleon.jobportal.dto.JobApplicationsListDTO(j.id, j.job.id, j.job.jobTitle, j.coverLetter, f.id, CONCAT(f.firstName,' ', f.lastName), f.userName)  from JobApplication j, Freelancer f where j.freelancer = f order by j.id")
	List<JobApplicationsListDTO> findAllApps();
	
	@Query("select new com.digitalchameleon.jobportal.dto.JobApplicationsListDTO(j.id, j.job.id, j.job.jobTitle, j.coverLetter, f.id, CONCAT(f.firstName,' ', f.lastName), f.userName)  from JobApplication j, Freelancer f where f.id=:frId and j.job.id=:jobId")
	List<JobApplicationsListDTO> findByFreelancerId(@Param("jobId") Long jobId, @Param("frId") Long frId);
}
