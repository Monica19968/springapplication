package com.osi.ftpapplication.repository;

import org.springframework.stereotype.Repository;

import com.osi.ftpapplication.model.JobScheduler;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface JobSchedulerRepository extends JpaRepository<JobScheduler, Integer>{
	
	JobScheduler getByName(String name);

	}