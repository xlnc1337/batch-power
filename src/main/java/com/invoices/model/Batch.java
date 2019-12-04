package com.invoices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "batch")
public class Batch {

	String id;
	String status;
	BatchDetails batchDetails;
	
	@XmlElement(name="section")
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	List<Section> sections;
	
	
	@XmlElement(name="batchDetails")
	public BatchDetails getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(BatchDetails batchDetails) {
		this.batchDetails = batchDetails;
	}

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
