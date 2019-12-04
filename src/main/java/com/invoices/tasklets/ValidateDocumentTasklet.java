package com.invoices.tasklets;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.invoices.utils.XmlUtils;

public class ValidateDocumentTasklet implements Tasklet, InitializingBean {

	String xmlDocument;
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext chunkContext)
			throws Exception {
		// TODO Auto-generated method stub
		String fileName = (String) chunkContext.getStepContext().getJobParameters().get("input.file.name");
		File file = new File(fileName);
		System.out.println("Validating file " + file.getName());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		
		//validate document level
		
		if (doc != null) {
			
		}
		return null;
	}

}
