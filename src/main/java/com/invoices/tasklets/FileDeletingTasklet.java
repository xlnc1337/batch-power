package com.invoices.tasklets;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class FileDeletingTasklet implements Tasklet, InitializingBean {

	private Resource directory;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(directory, "directory must be set");
	}

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		try {

			String fileName = (String) chunkContext.getStepContext().getJobParameters().get("input.file.name");

			File file = new File(fileName);
		
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else { 
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
		
		}

		/*
		 * File dir = directory.getFile(); Assert.state(dir.isDirectory());
		 * 
		 * File[] files = dir.listFiles(); for (int i = 0; i < files.length;
		 * i++) { boolean deleted = files[i].delete(); if (!deleted) { throw new
		 * UnexpectedJobExecutionException( "Could not delete file " +
		 * files[i].getPath()); } else { System.out.println(files[i].getPath() +
		 * " is deleted!"); } }
		 */
		return RepeatStatus.FINISHED;
	}

	public Resource getDirectory() {
		return directory;
	}

	public void setDirectory(Resource directory) {
		this.directory = directory;
	}
}