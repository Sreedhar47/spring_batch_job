package com.vsr.spring_batch_job.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vsr.spring_batch_job.entity.Student;
import com.vsr.spring_batch_job.repository.SourceRepository;
@Component
public class SourceWriter implements ItemWriter<Student>{
	
    @Autowired
    private SourceRepository studRepository;

	@Override
	public void write(List<? extends Student> items) throws Exception {
		System.out.println("writer1 class");
		studRepository.saveAll(items);
	}


}
