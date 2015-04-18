package com.chrzha.social.service;

import java.util.List;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchService {

	public boolean insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents(String userId,Integer pageNum,Integer pageSize);
	public boolean insertPatent(PatentsInfo patentsInfo);
	public List<PatentsInfo> getPatentsByVersion(String version,Integer pageNum,Integer pageSize);
    public void deleteAllPatents(String userId);
    public void deletePatentsByVersion(String version);
    public List<String> getVersions(String userId);
    public Integer getTotalCount(String userId);
    public Integer getTotalCountByVersion(String version);
}
