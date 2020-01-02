package com.ecust.service;

import com.ecust.entity.Users;

public interface StudentService {
	/**
	 * 学生登录
	 * @param student
	 * @return
	 */
	Users login(Users student);
	
	/**
	 * 对学生信息进行更改
	 * @return
	 */
	int changeInformation(Users student);
}
