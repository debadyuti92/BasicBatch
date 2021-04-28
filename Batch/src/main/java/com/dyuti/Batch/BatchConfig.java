package com.dyuti.Batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.dyuti.Batch.Model.Employee;
 
 
@Configuration
public class BatchConfig {
     
    @Autowired
    private JobBuilderFactory jobs;
 
    @Autowired
    private StepBuilderFactory steps;
    
    @Autowired
    private CustmLstnr custmLstnr;
    
    @Bean
    public CustmLstnr custLstnr() {
    	return new CustmLstnr();
    }
     
    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
        		.tasklet(new MyTaskOne())
        		.build();
    }
     
    @Bean
    public Step stepTwo(){
        return steps.get("stepTwo")
                .tasklet(new MyTaskTwo())
                .build();
    }  
     
    @Bean
    public Job demoJob(){
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .listener(custmLstnr)
                .build();
    }
    /*@SuppressWarnings("unchecked")
	@Bean
    public FlatFileItemReader<Employee> reader() {
    	FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
    	reader.setResource(new FileSystemResource("src/main/resources/sample1.csv"));
    	reader.setLinesToSkip(1);
    	reader.setLineMapper(new DefaultLineMapper() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
                    {
                        setTargetType(Employee.class);
                    }
                });
            }
        });
    	return reader;
    }
    
    @Bean
    public CustomeEventListener listner() {
    	return new CustomeEventListener();
    }
    
    @Bean
    public ConsoleWriter<Employee> writer(){
    	return new ConsoleWriter<Employee>();
    }
    
    @Bean
    public Step step1(){
        return steps.get("step1")
        		.<Employee, Employee>chunk(5)
        		.reader(reader())
        		.writer(writer())
        		.build();
    }
    
    @Bean
    public Job CSVReaderJob(){
        return jobs.get("CSVReaderJob")
                .incrementer(new RunIdIncrementer())
                .listener(listner())
                .start(step1())
                .build();
    }*/
    
}
