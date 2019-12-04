package com.invoices.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Document {

	String id;
	String type;
	String orginPaper;
	String templateId;
	String distribution;
	String bgcId;
	Invoice invoice;
	DocumentDetails documentDetails;

	
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrginPaper() {
		return orginPaper;
	}

	public void setOrginPaper(String orginPaper) {
		this.orginPaper = orginPaper;
	}

	@XmlAttribute(name = "templateID")
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	@XmlAttribute(name = "distribution")
	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	@XmlAttribute(name = "bgcID")
	public String getBgcId() {
		return bgcId;
	}

	public void setBgcId(String bgcId) {
		this.bgcId = bgcId;
	}

	@XmlElement(name = "documentDetails")
	public DocumentDetails getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}
	
}
