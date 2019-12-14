package com.ecust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Project;

public interface ProjectMapper {
	/**
	 * 通过项目id查找项目
	 * @param projectId
	 * @return
	 */
	Project selectById(int projectId);
	
	
	@Select("select * from project")
	List<Project>selectAll();
	
	
}
