package com.invoices.services;

import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {

	private JobLauncher jobLauncher;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	private Job job;

	public void run() {

		try {
			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();
			JobParameters params = new JobParametersBuilder()
					.addLong("date", System.currentTimeMillis())
					.addString("jobID", randomUUIDString)
					.addString("fileName", "C:\\temp\\input\\input.csv")
					.toJobParameters();

			JobExecution execution = jobLauncher.run(job, params);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}