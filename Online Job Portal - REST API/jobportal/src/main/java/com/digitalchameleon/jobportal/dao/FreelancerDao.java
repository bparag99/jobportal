package com.digitalchameleon.jobportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.dto.FreelancerListDTO;
import com.digitalchameleon.jobportal.modal.Freelancer;

@Repository
public interface FreelancerDao extends JpaRepository<Freelancer, Long> {


	@Query(value = "select freelancer_seq.currval from dual", nativeQuery = true)
	Long getCurrentSeriesId();

	public Freelancer findByUserName(String userName);

	public boolean existsByUserName(String userName);
	
	@Query(value = "select new com.digitalchameleon.jobportal.dto.FreelancerListDTO(f.id, f.userName, f.firstName, f.lastName, f.password) from Freelancer f  order by f.id")
	public List<FreelancerListDTO> findAllFreelancers(); 

}
