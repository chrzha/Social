package com.chrzha.social.entity;

public class PatentsInfo {

	private Integer patentId;
	private String patentNumber;
	private String patentName;
	private String ownerName;
	private String assigneeName;
	private String patentUrl;
	private String fieldName;
	private String abstractContent;
	
	public  PatentsInfo() {
		
	}
	public PatentsInfo(String patentUrl, String patentNumber,
			Integer patentId, String patentName, String ownerName,
			String assigneeName, String fieldName, String abstractContent) {
		this.patentUrl = patentUrl;
		this.patentNumber = patentNumber;
		this.patentId = patentId;
		this.patentName = patentName;
		this.ownerName = ownerName;
		this.assigneeName = assigneeName;
		this.fieldName = fieldName;
		this.abstractContent = abstractContent;
	}
	@Override
	public String toString() {
		return "PatentsInfo [patentUrl=" + patentUrl + ", patentNumber="
				+ patentNumber + ", patentId=" + patentId + ", patentName="
				+ patentName + ", ownerName=" + ownerName + ", assigneeName="
				+ assigneeName + ", fieldName=" + fieldName
				+ ", abstractContent=" + abstractContent + ", getPatentUrl()="
				+ getPatentUrl() + ", getPatentNumber()=" + getPatentNumber()
				+ ", getPatentId()=" + getPatentId() + ", getPatentName()="
				+ getPatentName() + ", getOwnerName()=" + getOwnerName()
				+ ", getAssigneeName()=" + getAssigneeName()
				+ ", getFieldName()=" + getFieldName()
				+ ", getAbstractContent()=" + getAbstractContent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public String getPatentUrl() {
		return patentUrl;
	}
	public void setPatentUrl(String patentUrl) {
		this.patentUrl = patentUrl;
	}
	public String getPatentNumber() {
		return patentNumber;
	}
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	public Integer getPatentId() {
		return patentId;
	}
	public void setPatentId(Integer patentId) {
		this.patentId = patentId;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAssigneeName() {
		return assigneeName;
	}
	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getAbstractContent() {
		return abstractContent;
	}
	public void setAbstractContent(String abstractContent) {
		this.abstractContent = abstractContent;
	}

	
}
