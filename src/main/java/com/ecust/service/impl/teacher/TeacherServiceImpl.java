package com.ecust.service.impl.teacher;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ecust.entity.Users;
import com.ecust.mapper.teacher.TeacherMapper;
import com.ecust.service.teacher.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Resource
	private TeacherMapper teacherMapper;
	@Override
	public Users login(Users teacher) {
		return teacherMapper.selectByUserPwd(teacher);
	}

}
