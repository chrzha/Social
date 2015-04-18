package com.chrzha.social.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chrzha.social.entity.PatentsInfo;

public interface DataCatchMapper {

	public Integer insertPatents(List<PatentsInfo> list);
	public List<PatentsInfo> getPatents(@Param("userId")String userId,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	public Integer insertPatent(PatentsInfo patentsInfo);
	public List<PatentsInfo> getPatentsByVersion(@Param("version")String version,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
    public void deleteAllPatents(@Param("userId")String userId);
    public void deletePatentsByVersion(@Param("version")String version);
    public List<String> getVersions(@Param("userId")String userId);
    public Integer getTotalCount(@Param("userId")String userId);
    public Integer getTotalCountByVersion(@Param("version")String version);
	
}
