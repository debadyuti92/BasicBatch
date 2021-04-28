package com.dyuti.Batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTaskOne implements Tasklet,StepExecutionListener{
	
	FileReader file = null;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		 
       BufferedReader br = new BufferedReader(file);
       String content = br.readLine(); 
       while(content!=null) {
    	   System.out.println(content);
    	   content = br.readLine(); 
       }
         
        return RepeatStatus.FINISHED;
	}

	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		System.out.println("Tasklet Completed");
		return null;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		System.out.println("MyTaskOne start..");
		try {
			file = new FileReader("C:\\Users\\debad\\Desktop\\Writer.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
