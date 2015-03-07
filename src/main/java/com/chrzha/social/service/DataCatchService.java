package com.chrzha.social.service;

import java.util.List;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchService {

	public boolean insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents();
}
