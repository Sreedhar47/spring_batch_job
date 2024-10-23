package com.vsr.spring_batch_job.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsr.spring_batch_job.entity.TargetStudent;
import com.vsr.spring_batch_job.repository.TargetStudRepository;

public class MyItemWriter implements ItemWriter<TargetStudent> {
	@Autowired
    private TargetStudRepository targetRepository;
    @Override
    public void write(List<? extends TargetStudent> items) throws Exception {
    	System.out.println("writter class");
    	targetRepository.saveAll(items);
       // for (MyRecord item : items) {
           // System.out.println("Writing record: " + item);
       // }
    }
}
