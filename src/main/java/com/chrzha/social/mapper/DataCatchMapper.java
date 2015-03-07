package com.chrzha.social.mapper;

import java.util.List;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchMapper {

	public Integer insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents();
	
}
