package com.vsr.spring_batch_job.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.vsr.spring_batch_job.entity.Student;
@Component
public class SourceProcessor implements ItemProcessor<Student, Student>{

	@Override
	public Student process(Student item) throws Exception {
		System.out.println("processor1 class");
		System.out.println(" before setting --- Status :"+ item.isStatus());
		item.setStatus(true);
		System.out.println("  after setting --- Status :"+ item.isStatus());
		return item;
		
	}

}
