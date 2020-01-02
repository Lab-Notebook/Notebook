package com.ecust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecust.entity.Users;
import com.ecust.mapper.TeacherMapper;
import com.ecust.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Resource
	private TeacherMapper teacherMapper;
	@Override
	public Users login(Users teacher) {
		return teacherMapper.selectByUserPwd(teacher);
	}

}
