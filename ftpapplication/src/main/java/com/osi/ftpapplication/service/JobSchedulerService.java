package com.osi.ftpapplication.service;

import org.springframework.stereotype.Service;

import com.osi.ftpapplication.exception.JobSchedulerNotFoundException;
import com.osi.ftpapplication.model.JobScheduler;
import com.osi.ftpapplication.repository.JobSchedulerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class JobSchedulerService {
	
	@Autowired
	JobSchedulerRepository jobSchedulerRepository;

	public String createJobScheduler(JobScheduler jobsScheduler) {
		JobScheduler savedJobScheduler = jobSchedulerRepository.save(jobsScheduler);

		if(savedJobScheduler!=null)
			return "your jobscheduler is created" +jobsScheduler.getSchedulerName();
		else
			return "your jobscheduler isn't created"+jobsScheduler.getSchedulerName();
		
	}
	
	  public JobScheduler getFTPScheduler(String name){
	       
	        return jobSchedulerRepository.getByName(name);
	       
	       
	    }
	
	public JobScheduler updateJobScheduler(Integer id, JobScheduler jobScheduler) throws JobSchedulerNotFoundException {
		if(!jobSchedulerRepository.existsById(id)) {
			throw new JobSchedulerNotFoundException("Job Scheduler does not exist"+id);
		}
		JobScheduler updatedJobScheduler = new JobScheduler();
		updatedJobScheduler.setId(id);
		updatedJobScheduler.setSchedulerName(jobScheduler.getSchedulerName());
		updatedJobScheduler.setSourceLocation(jobScheduler.getSourceLocation());
		updatedJobScheduler.setDestinationLocation(jobScheduler.getDestinationLocation());
		updatedJobScheduler.setFrequency(jobScheduler.getFrequency());
		updatedJobScheduler.setDatetime(jobScheduler.getDatetime());
		return jobSchedulerRepository.save(updatedJobScheduler);
	}
	
	public List<JobScheduler> getAllJobScheduler(){
		List<JobScheduler> AllJobScheduler = null;
		AllJobScheduler = jobSchedulerRepository.findAll();
		return AllJobScheduler;
	}
	
	public JobScheduler deleteJobScheduler(Integer id) {
		jobSchedulerRepository.deleteById(id);
		return null;
	}
}
