package com.invoices.model;



public class DocumentDetails {

	String originatorBgnr;
	String originatorIntermediator;
	String addresseeId;
	String addresseeIntermediator;
	String addresseeType;
	
	public String getAddresseeType() {
		return addresseeType;
	}
	public void setAddresseeType(String addresseeType) {
		this.addresseeType = addresseeType;
	}
	public String getOriginatorBgnr() {
		return originatorBgnr;
	}
	public void setOriginatorBgnr(String originatorBgnr) {
		this.originatorBgnr = originatorBgnr;
	}
	public String getOriginatorIntermediator() {
		return originatorIntermediator;
	}
	public void setOriginatorIntermediator(String originatorIntermediator) {
		this.originatorIntermediator = originatorIntermediator;
	}
	public String getAddresseeId() {
		return addresseeId;
	}
	public void setAddresseeId(String addresseeId) {
		this.addresseeId = addresseeId;
	}
	public String getAddresseeIntermediator() {
		return addresseeIntermediator;
	}
	public void setAddresseeIntermediator(String addresseeIntermediator) {
		this.addresseeIntermediator = addresseeIntermediator;
	}
	
	
}
