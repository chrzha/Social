package com.chrzha.social.service.impl;

import java.util.List;

import com.chrzha.social.entity.PatentsInfo;
import com.chrzha.social.mapper.DataCatchMapper;
import com.chrzha.social.service.DataCatchService;

public class DataCatchServiceImpl implements DataCatchService{

	@Autowired
	private DataCatchMapper dataCatchMapper;
	
	@Override
	public boolean insertPatents(List<PatentsInfo> list) {
		// TODO Auto-generated method stub
		return dataCatchMapper.insertPatents(list)>0?true:false;
	}

	@Override
	public List<PatentsInfo> getPatents() {
		// TODO Auto-generated method stub
		return dataCatchMapper.getPatents();
	}

}
