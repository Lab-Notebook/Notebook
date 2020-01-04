package com.ecust.service.impl.student;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecust.controller.LoginController;
import com.ecust.entity.Users;
import com.ecust.mapper.student.StudentMapper;
import com.ecust.service.student.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentMapper studentMapper;
	private static Logger logger = Logger.getLogger(LoginController.class);

	public Users login(Users student) {
		logger.error(studentMapper.selectByUserPwd(student));
		return studentMapper.selectByUserPwd(student);
	}

	@Override
	public int changeInformation(Users student) {
		return studentMapper.updateById(student);
	}

}
