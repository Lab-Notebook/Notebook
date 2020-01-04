package com.ecust.mapper.student;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Project;

public interface SProjectMapper {
	/**
	 * 通过项目id查找项目
	 * @param projectId
	 * @return
	 */
	Project selectById(int projectId);
	
	/**
	 * 选择Project表中的所有项目
	 * @return
	 */
	@Select("select * from project")
	List<Project>selectAll();
	
	/**
	 * 通过Project名找到对应id
	 * @param name
	 * @return
	 */
	@Select("select project_id from project where name=#{0};")
	int selectIdByName(String name);
	
}
