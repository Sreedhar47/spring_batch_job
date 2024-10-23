package com.vsr.spring_batch_job.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.vsr.spring_batch_job.entity.Student;
import com.vsr.spring_batch_job.entity.TargetStudent;
@Component
public class TargetProcessor implements ItemProcessor<Student, TargetStudent>{

	@Override
	public TargetStudent process(Student item) throws Exception {
		System.out.println("processor class");
		TargetStudent target = new TargetStudent();
		target.setId(item.getId());
		target.setName(item.getName());
		return target;
	}

}
