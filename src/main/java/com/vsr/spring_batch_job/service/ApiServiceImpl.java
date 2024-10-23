package com.vsr.spring_batch_job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsr.spring_batch_job.entity.Student;
import com.vsr.spring_batch_job.repository.SourceRepository;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private SourceRepository repo;

	@Override
	public void saveDetails(int id, String name) {
		Student stud = new Student();
		stud.setId(id);
		stud.setName(name);
		repo.save(stud);
		
	}



}
