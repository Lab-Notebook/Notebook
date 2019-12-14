package com.ecust.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecust.controller.LoginController;
import com.ecust.entity.Users;
import com.ecust.mapper.StudentMapper;
import com.ecust.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentMapper studentMapper;
	private static Logger logger = Logger.getLogger(LoginController.class);

	public Users login(Users student) {
		logger.error(studentMapper.selectByUserPwd(student));
		return studentMapper.selectByUserPwd(student);
	}

}
