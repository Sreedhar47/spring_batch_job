package com.vsr.spring_batch_job.config;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vsr.spring_batch_job.entity.Student;
import com.vsr.spring_batch_job.repository.SourceRepository;
@Component
public class CReader implements ItemReader<Student> {

	@Autowired
    private SourceRepository sourceRepository;
	
	private Iterator<Student> studentIterator;
	
	@Override
	public Student read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("reader class");
		// Initialize the iterator if it has not been initialized
	    if (studentIterator == null) {
	        List<Student> studs = sourceRepository.findAll();
	        studentIterator = studs.iterator();
	        System.out.println("studentIterator initialized");
	    }

	    // Return the next student or null if no more students
	    if (studentIterator.hasNext()) {
	    	System.out.println("id = "+ studentIterator.next().getId() );
	        return studentIterator.next();
	    } else {
	        return null; // Signal the end of input
	    }
	    
	}
}
	


