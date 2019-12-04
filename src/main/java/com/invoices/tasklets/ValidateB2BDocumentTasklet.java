package com.invoices.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;

public class ValidateB2BDocumentTasklet  implements Tasklet, InitializingBean{

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
