package com.vsr.spring_batch_job.config;

import java.util.Collections;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vsr.spring_batch_job.entity.MyRecord;
import com.vsr.spring_batch_job.entity.Student;
import com.vsr.spring_batch_job.entity.TargetStudent;
import com.vsr.spring_batch_job.repository.SourceRepository;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	    
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private SourceRepository sourceRepository;
    
   
    @Autowired
    private TargetProcessor targetProcessor;
    
    @Autowired
    private TargetWriter targetWriter;
    
    @Autowired
    private SourceProcessor sourceProcessor;
    
    @Autowired
    private SourceWriter sourceWriter;
 
    //@Bean
    public Job transferDataJob() {
        return jobBuilderFactory.get("transferDataJob")
                .start(transferDataStep())
                .next(transferDataStep1())
                .build();
    }
    	
	//@Bean
    public Step transferDataStep() {
		System.out.println("Step");
        return stepBuilderFactory.get("transferDataStep")
                .<Student, TargetStudent>chunk(10)
                .reader(reader())
                .processor(targetProcessor)
                .writer(targetWriter)
                .build();
    }
	
	//@Bean
	public Step transferDataStep1() {
		System.out.println("Step1");
		return stepBuilderFactory.get("transferDataStep1")
                .<Student, Student>chunk(10)
                .reader(reader())
                .processor(sourceProcessor)
                .writer(sourceWriter)
                .build();
	}

	private RepositoryItemReader<? extends Student> reader() {
		System.out.println("reader class");
		RepositoryItemReader reader = new RepositoryItemReader<>();
		reader.setRepository(sourceRepository);
		reader.setMethodName("findAll");
		//reader.setArguments(null);
		reader.setSort(Collections.emptyMap());
		return reader;
	}
	
	
	
	// job for excel reader
	
	    @Bean
	    public Job readExcelJob() throws Exception {
	        return jobBuilderFactory.get("readExcelJob")
	                .start(readExcelStep())  // Define a step that uses the Excel reader
	                .build();
	    }

	    @Bean
	    public Step readExcelStep() throws Exception {
	        return stepBuilderFactory.get("readExcelStep")
	                .<MyRecord, TargetStudent>chunk(10)
	                .reader(excelItemReader())  // Use custom Excel reader
	                //.processor(processor())
	                .processor(processor())
	                .writer(writer())
	                .build();
	    }

	    @Bean
	    public ExcelItemReader excelItemReader() throws Exception {
	        // String filePath = "/path/to/your/excel/file.xlsx";  // Replace with your file path
	    	 String filePath = "C:\\Users\\SREEDHAR\\Downloads\\id_name_data_10000.xlsx";
	      
	    	 return new ExcelItemReader(filePath);
	    }

	     @Bean
	    public MyItemProcessor processor() {
	        return new MyItemProcessor();
	    }
	    
	    @Bean
	    public MyItemWriter writer() {
	        return new MyItemWriter();
	    }
	}
	


