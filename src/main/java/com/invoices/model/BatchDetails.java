package com.invoices.model;

import javax.xml.bind.annotation.XmlElement;

public class BatchDetails {

	
	int totalDocuments;
	int totalSections;
	String bgNumber;
	String intermediator;
	
	@XmlElement(name = "intermediator")
	public String getIntermediator() {
		return intermediator;
	}

	public void setIntermediator(String intermediator) {
		this.intermediator = intermediator;
	}

	@XmlElement(name = "bgnr")
	public String getBgNumber() {
		return bgNumber;
	}

	public void setBgNumber(String bgNumber) {
		this.bgNumber = bgNumber;
	}

	@XmlElement(name = "totalDocuments")
	public int getTotalDocs() {
		return totalDocuments;
	}

	public void setTotalDocs(int totalDocs) {
		this.totalDocuments = totalDocs;
	}

	@XmlElement(name = "totalSections")
	public int getTotalSections() {
		return totalSections;
	}

	public void setTotalSections(int totalSections) {
		this.totalSections = totalSections;
	}
}
