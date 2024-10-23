package com.vsr.spring_batch_job.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.spring_batch_job.service.ApiService;


@RestController
public class ApiController {
	
	@Autowired
	private ApiService service;
	
	@Autowired
    private JobLauncher jobLauncher;

   // @Autowired
   // private Job transferDataJob;
    
     @Autowired
    private Job readExcelJob;
	
	
	@PostMapping("/save/{id}/{name}/{status}")
	public String saveDetails(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("status") String status) {
		service.saveDetails(id, name);
		return "Succesfull......!";
	}
	
	@GetMapping("/start")
	public String start() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
       // jobLauncher.run(transferDataJob, jobParameters);
		
		return "Strated......!";
	}
	
	@GetMapping("/job")
	public String job() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
       jobLauncher.run(readExcelJob, jobParameters);
		
		return "Strated......!";
	}
	
	

}
