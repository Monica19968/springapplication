package com.osi.ftpapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.ftpapplication.exception.JobSchedulerNotFoundException;
import com.osi.ftpapplication.model.JobScheduler;
import com.osi.ftpapplication.service.JobSchedulerService;



@RestController
@RequestMapping("/jobScheduler")
public class JobSchedulerController {
	
	@Autowired
	JobSchedulerService jobSchedulerService;
	/**
	 * Create JobScheduler
	 * @param jobsScheduler
	 * @return created JobScheduler successfully
	 */
	@PostMapping("/createJobScheduler")
	public String createJobScheduler(@RequestBody JobScheduler jobsScheduler) {
		return jobSchedulerService.createJobScheduler(jobsScheduler); 
	}
	/**
	 * Update JobScheduler by ID
	 * @param id
	 * @param jobScheduler
	 * @return Updated JobScheduler 
	 * @throws JobSchedulerNotFoundException
	 */
	@PatchMapping("/updateJobScheduler/{id}")
	public JobScheduler updateJobScheduler(@PathVariable Integer id, @RequestBody JobScheduler jobScheduler) throws JobSchedulerNotFoundException {
		return jobSchedulerService.updateJobScheduler(id, jobScheduler);
	}
	/**
	 * Get JobScheduler by name
	 * @param name
	 * @return Successfully returned JobScheduler with name
	 */
	 @GetMapping("/getJobScheduler/{name}")
	    public JobScheduler getFTPScheduler(@PathVariable String name){
	        return jobSchedulerService.getFTPScheduler(name);
	    }
	 /**
	  * Get all created JobSchedulers
	  * @return All JobSchedulers
	  */
	@GetMapping("/getAllJobScheduler")
	public List<JobScheduler> getAllJobScheduler(){
		return jobSchedulerService.getAllJobScheduler();
	}
	/**
	 * Delete JobScheduler by ID
	 * @param id
	 * @return The JobScheduler has been successfully deleted 
	 */
	@DeleteMapping("/deleteJobScheduler/{id}")
	public JobScheduler deleteJobScheduler(@PathVariable Integer id) {
		return jobSchedulerService.deleteJobScheduler(id);
	}
	
	
}
