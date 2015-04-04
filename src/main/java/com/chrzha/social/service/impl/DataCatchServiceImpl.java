package com.chrzha.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrzha.social.entity.PatentsInfo;
import com.chrzha.social.mapper.DataCatchMapper;
import com.chrzha.social.service.DataCatchService;

@Service
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

	@Override
	public boolean insertPatent(PatentsInfo patentsInfo) {
		// TODO Auto-generated method stub
		
		return dataCatchMapper.insertPatent(patentsInfo)>0?true:false;
	}

	@Override
	public List<PatentsInfo> getPatentsByVersion(String version) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getPatentsByVersion(version);
	}

	@Override
	public void deleteAllPatents() {
		// TODO Auto-generated method stub
		dataCatchMapper.deleteAllPatents();
	}

	@Override
	public List<String> getVersions() {
		// TODO Auto-generated method stub
		return dataCatchMapper.getVersions();
	}

	@Override
	public void deletePatentsByVersion(String version) {
		// TODO Auto-generated method stub
		dataCatchMapper.deletePatentsByVersion(version);
	}

}
