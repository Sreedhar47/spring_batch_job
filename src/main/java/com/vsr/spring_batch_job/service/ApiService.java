package com.vsr.spring_batch_job.service;

import org.springframework.stereotype.Service;

@Service
public interface ApiService{

	void saveDetails(int id, String name);

}
