package com.vsr.spring_batch_job.config;

import org.springframework.batch.item.ItemProcessor;

import com.vsr.spring_batch_job.entity.MyRecord;
import com.vsr.spring_batch_job.entity.TargetStudent;

public class MyItemProcessor implements ItemProcessor<MyRecord, TargetStudent> {
    @Override
    public TargetStudent process(MyRecord item) throws Exception {
    	System.out.println("process class");
    	TargetStudent target = new TargetStudent();
        System.out.println("Processing record: " + item);
        target.setId(item.getId());
        target.setName(item.getName());
        return target;  // Return the item as is, or modify it as needed
    }


}
