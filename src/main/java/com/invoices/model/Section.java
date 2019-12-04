package com.invoices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Section {

	String id;

	String bgnrType;

	String bgnr;

	SectionDetails sectionDetails;
	List<Document> document;

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	@XmlElement(name = "document")
	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "bgnrType")
	public String getBgnrType() {
		return bgnrType;
	}

	public void setBgnrType(String bgnrType) {
		this.bgnrType = bgnrType;
	}

	@XmlAttribute(name = "bgnr")
	public String getBgnr() {
		return bgnr;
	}

	public void setBgnr(String bgnr) {
		this.bgnr = bgnr;
	}

	@XmlElement(name = "sectionDetails")
	public SectionDetails getSectionDetails() {
		return sectionDetails;
	}

	public void setSectionDetails(SectionDetails sectionDetails) {
		this.sectionDetails = sectionDetails;
	}

}
