package com.chrzha.social.entity;

public class PatentsInfo {

	private Integer patentId;
	private String patentName;
	private String ownerName;
	private String countryName;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "PatentsInfo [patentId=" + patentId + ", patentName="
				+ patentName + ", ownerName=" + ownerName + ", countryName="
				+ countryName + "]";
	}
	public PatentsInfo( ) { 
	}
	
	public PatentsInfo(Integer patentId, String patentName, String ownerName,
			String countryName) {
		this.patentId = patentId;
		this.patentName = patentName;
		this.ownerName = ownerName;
		this.countryName = countryName;
	}
	

}
