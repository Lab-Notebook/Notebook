package com.ecust.service.student;

import java.util.List;

import com.ecust.entity.Project;

public interface SProjectService {
	/**
	 * 选择现有的所有项目
	 * @return
	 */
	List<Project> selectAll();
}
