package com.vsr.spring_batch_job.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vsr.spring_batch_job.entity.TargetStudent;
import com.vsr.spring_batch_job.repository.TargetStudRepository;
@Component
public class TargetWriter implements ItemWriter<TargetStudent>{
	
    @Autowired
    private TargetStudRepository targetRepository;

	@Override
	public void write(List<? extends TargetStudent> items) throws Exception {
		System.out.println("writer class");
		targetRepository.saveAll(items);
	}

}
