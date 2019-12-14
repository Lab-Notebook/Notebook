package com.ecust.service;

import java.util.List;

import com.ecust.entity.Project;

public interface ProjectService {
	/**
	 * 选择现有的所有项目
	 * @return
	 */
	List<Project> selectAll();
}
