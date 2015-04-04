package com.chrzha.social.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchMapper {

	public Integer insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents();
	public Integer insertPatent(PatentsInfo patentsInfo);
	public List<PatentsInfo> getPatentsByVersion(@Param("version")String version);
    public void deleteAllPatents();
    public void deletePatentsByVersion(@Param("version")String version);
    public List<String> getVersions();
	
}
