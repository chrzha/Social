package com.chrzha.social.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserVersionMapper {

	public Integer insertLink(@Param("userId") String userId,
			@Param("version") String version);
}
