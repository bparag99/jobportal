package com.digitalchameleon.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.dto.RecruiterListDTO;
import com.digitalchameleon.jobportal.modal.Recruiter;

@Repository
public interface RecruiterDao extends JpaRepository<Recruiter, Long> {

	
	@Query(value = "select recruiter_seq.currval from dual", nativeQuery = true)
	Long getCurrentSeriesId();

	public Recruiter findByUserName(String userName);

	public boolean existsByUserName(String userName);
	
	@Query("select new com.digitalchameleon.jobportal.dto.RecruiterListDTO(r.id, r.userName, r.firstName, r.lastName, r.password) from Recruiter r")
	public List<RecruiterListDTO> findAllRecruiters();

}
