package com.ecust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecust.entity.Project;
import com.ecust.mapper.ProjectMapper;
import com.ecust.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectMapper projectMapper;
	@Override
	public List<Project> selectAll() {
		return projectMapper.selectAll();
	}
	
}
