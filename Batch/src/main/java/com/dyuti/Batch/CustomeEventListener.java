package com.dyuti.Batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CustomeEventListener implements JobExecutionListener{

	@Override
	public void afterJob(JobExecution jobExecute) {
		if(jobExecute.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Your data is successfully retrieved");
		}
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
