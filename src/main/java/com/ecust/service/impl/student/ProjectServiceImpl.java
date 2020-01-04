package com.ecust.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecust.entity.Project;
import com.ecust.mapper.student.SProjectMapper;
import com.ecust.service.student.SProjectService;

@Service
public class ProjectServiceImpl implements SProjectService{
	@Resource
	private SProjectMapper projectMapper;
	@Override
	public List<Project> selectAll() {
		return projectMapper.selectAll();
	}
	
}
