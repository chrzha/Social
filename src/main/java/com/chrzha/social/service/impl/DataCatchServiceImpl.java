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
	public List<PatentsInfo> getPatents(String userId,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getPatents(userId,pageNum*pageSize,pageSize);
	}

	@Override
	public boolean insertPatent(PatentsInfo patentsInfo) {
		// TODO Auto-generated method stub
		
		return dataCatchMapper.insertPatent(patentsInfo)>0?true:false;
	}

	@Override
	public List<PatentsInfo> getPatentsByVersion(String version,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getPatentsByVersion(version,pageNum*pageSize,pageSize);
	}

	@Override
	public void deleteAllPatents(String userId) {
		// TODO Auto-generated method stub
		dataCatchMapper.deleteAllPatents(userId);
	}

	@Override
	public List<String> getVersions(String userId) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getVersions(userId);
	}

	@Override
	public void deletePatentsByVersion(String version) {
		// TODO Auto-generated method stub
		dataCatchMapper.deletePatentsByVersion(version);
	}

	@Override
	public Integer getTotalCount(String userId) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getTotalCount(userId);
	}

	@Override
	public Integer getTotalCountByVersion(String version) {
		// TODO Auto-generated method stub
		return dataCatchMapper.getTotalCountByVersion(version);
	}

}
