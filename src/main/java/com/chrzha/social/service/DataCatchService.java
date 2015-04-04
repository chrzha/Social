package com.chrzha.social.service;

import java.util.List;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchService {

	public boolean insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents();
	public boolean insertPatent(PatentsInfo patentsInfo);
	public List<PatentsInfo> getPatentsByVersion(String version);
    public void deleteAllPatents();
    public void deletePatentsByVersion(String version);
    public List<String> getVersions();
}
