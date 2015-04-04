package com.chrzha.social.entity;

public class PatentsInfo {

	private Integer patentId;
	private String patentNumber;
	private String patentName;
	private String ownerName;
	private String patentUrl;
	private String abstractContent;
	private String version;
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public  PatentsInfo() {
		
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
	public String getAbstractContent() {
		return abstractContent;
	}
	public void setAbstractContent(String abstractContent) {
		this.abstractContent = abstractContent;
	}

	
}
