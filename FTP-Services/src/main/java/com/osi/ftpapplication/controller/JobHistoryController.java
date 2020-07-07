package com.osi.ftpapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.ftpapplication.exception.IDNotFoundException;
import com.osi.ftpapplication.model.JobHistory;

import com.osi.ftpapplication.service.JobHistoryService;

@RestController
@RequestMapping("/jobHistory")
public class JobHistoryController {

	@Autowired
	JobHistoryService jobHistoryService;

	/**
	 * Get JobDetails by ID
	 * 
	 * @param id
	 * @return JobDetails with reference to ID
	 * @throws IDNotFoundException
	 */
	@GetMapping("/getJobDetails/{id}")
	public JobHistory getJobDetails(@PathVariable Integer id) throws IDNotFoundException {
		return jobHistoryService.getJobDetails(id);

	}

	/**
	 * Delete JobDetails by ID
	 * 
	 * @param id
	 * @return successfully deleted JobDetails with reference to ID
	 */
	@DeleteMapping("/deleteJobDetails/{id}")
	public JobHistory deleteJobDetails(@PathVariable Integer id) {
		return jobHistoryService.deleteJobDetails(id);
	}
}
