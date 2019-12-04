package com.invoices.tasklets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.invoices.utils.XmlUtils;

public class ValidateFileTasklet implements Tasklet, InitializingBean {

	private Resource directory;
	private String processDir;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(directory, "directory must be set");
	}

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		String fileName = (String) chunkContext.getStepContext()
				.getJobParameters().get("input.file.name");
		// xmlDomParser( contribution,chunkContext,fileName);

		xmlStaxParser(contribution, chunkContext, fileName);
		return RepeatStatus.FINISHED;
	}

	public void xmlStaxParser(StepContribution contribution,
			ChunkContext chunkContext, String filename)
			throws FileNotFoundException, XMLStreamException {

		XMLInputFactory factory = XMLInputFactory.newInstance();

		// create xml event reader
		XMLEventReader r = factory.createXMLEventReader(filename,
				new FileInputStream(filename));

		// create a iterator
		while (r.hasNext()) {
			XMLEvent e = r.nextEvent();
			if (e.isStartElement()) {
				System.out.println(e.toString());
			}
		}
	}

	public void xmlDomParser(StepContribution contribution,
			ChunkContext chunkContext, String fileName) {

		try {

			File file = new File(fileName);
			System.out.println("Validating file " + file.getName());
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(file);
			if (doc != null) {
				NodeList listOfSections = doc.getElementsByTagName("section");
				NodeList listOfDocs = doc.getElementsByTagName("document");
				int totalSections = listOfSections.getLength();
				int totalDocs = listOfDocs.getLength();
				System.out.println("Total no of sections : " + totalSections);
				System.out.println("Total no of documents : " + totalDocs);

				for (int k = 0; k < listOfDocs.getLength(); ++k) {
					Node node = listOfDocs.item(k);
					Element e = (Element) listOfDocs.item(k);
					String bgcID = e.getAttribute("bgcID");
					String id = e.getAttribute("id");

					String newFileName = id + "_" + bgcID;
					String xmlHeader = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\" ?>";
					String extractedXml = XmlUtils.nodeToString(node);
					System.out.println(processDir + newFileName);

					File documentFile = new File(processDir + newFileName
							+ ".xml");
					FileOutputStream fous = new FileOutputStream(documentFile);
					fous.write(xmlHeader.getBytes());
					fous.write(extractedXml.getBytes());
					fous.close();
					System.out.println(extractedXml);

				}
			}

			// chunkContext.getStepContext().getJobParameters().put(arg0, arg1)

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Resource getDirectory() {
		return directory;
	}

	public void setDirectory(Resource directory) {
		this.directory = directory;
	}

	public String getProcessDir() {
		return processDir;
	}

	public void setProcessDir(String processDir) {
		this.processDir = processDir;
	}

}