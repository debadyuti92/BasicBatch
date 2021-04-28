package com.dyuti.Batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.boot.ExitCodeGenerator;

public class CustmLstnr implements JobExecutionListener, ExitCodeGenerator{

	@Override
	public int getExitCode() {
		return 0;
	}
	
	@Override
	public void afterJob(JobExecution jobExc) {
		if(jobExc.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Completed");
		}else {
			System.out.println("Fail");
		}
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
