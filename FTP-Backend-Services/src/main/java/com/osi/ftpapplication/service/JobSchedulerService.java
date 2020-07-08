package com.osi.ftpapplication.service;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.SftpException;
import com.osi.ftpapplication.exception.JobSchedulerNotFoundException;
import com.osi.ftpapplication.model.JobHistory;
import com.osi.ftpapplication.model.JobSchedular;
import com.osi.ftpapplication.repository.JobHistoryRepository;
import com.osi.ftpapplication.repository.JobSchedulerRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JobSchedulerService {
	@Autowired
	FTPLocationService ftpservice;

	@Autowired
	JobHistoryRepository jobhistoryrepository;

	@Autowired
	JobSchedulerRepository jobSchedulerRepository;

	public String createJobScheduler(JobSchedular jobsScheduler) {
		JobSchedular savedJobScheduler = jobSchedulerRepository.save(jobsScheduler);

		if (savedJobScheduler != null)
			return "your jobscheduler is created" + jobsScheduler.getSchedulerName();
		else
			return "your jobscheduler isn't created" + jobsScheduler.getSchedulerName();

	}

	public JobSchedular getJobScheduler(String schedulerName) {

		return jobSchedulerRepository.findBySchedulerName(schedulerName);

	}

	public JobSchedular getJobSchedular(Integer id) {
		// TODO Auto-generated method stub
		return jobSchedulerRepository.getOne(id);
	}

	public JobSchedular updateJobScheduler(Integer id, JobSchedular jobScheduler) throws JobSchedulerNotFoundException {
		if (!jobSchedulerRepository.existsById(id)) {
			throw new JobSchedulerNotFoundException("Job Scheduler does not exist" + id);
		}
		JobSchedular updatedJobScheduler = new JobSchedular();
		updatedJobScheduler.setId(id);
		updatedJobScheduler.setSchedulerName(jobScheduler.getSchedulerName());
		updatedJobScheduler.setSourceLocationID(jobScheduler.getSourceLocationID());
		updatedJobScheduler.setDestinationLocationID(jobScheduler.getDestinationLocationID());
		updatedJobScheduler.setFrequency(jobScheduler.getFrequency());
		updatedJobScheduler.setDatetime(jobScheduler.getDatetime());
		return jobSchedulerRepository.save(updatedJobScheduler);
	}

	public List<JobSchedular> getAllJobSchedulers() {
		List<JobSchedular> AllJobScheduler = null;
		AllJobScheduler = jobSchedulerRepository.findAll();
		return AllJobScheduler;
	}

	public JobSchedular deleteJobScheduler(Integer id) {
		jobSchedulerRepository.deleteById(id);
		return null;
	}
	// run schedular

	public void runJobSchedular(Integer schedulerId) {

		JobSchedular savedJobScheduler = jobSchedulerRepository.getOne(schedulerId);

		Integer sourceID = savedJobScheduler.getSourceLocationID();
		Integer destID = savedJobScheduler.getDestinationLocationID();

		try {

			copyFiles(schedulerId, sourceID, destID);
		} catch (Exception e) {

		}

	}

	private boolean copyFiles(Integer schedulerId, Integer sourceID, Integer destID) throws IOException, SftpException {
		LocalDateTime localdatetime1 = LocalDateTime.now();
		boolean ret_val = false;
		
		JobHistory jobhistory = new JobHistory();
		jobhistory.setSchedulerid(schedulerId);
		jobhistory.setDatetime(localdatetime1);
		if (ftpservice.copyFiles(sourceID, destID)) {
			jobhistory.setStatus("success");
			jobhistory.setDescription("it is not valid job and scheduled for particular location at given intervels");
			ret_val = true;
		} else {
			jobhistory.setStatus("failed");
			jobhistory.setDescription("it is not valid job to schedule for particular location at given intervels");
		}
		jobhistoryrepository.save(jobhistory);
		return ret_val;
	}

}
