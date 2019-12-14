package com.ecust.service;

import com.ecust.entity.Users;

public interface StudentService {
	/**
	 * 学生登录
	 * @param student
	 * @return
	 */
	Users login(Users student);
}
