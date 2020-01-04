package com.ecust.service.teacher;


import com.ecust.entity.Users;

public interface TeacherService {
	/**
	 * 教师登录
	 * @return
	 */
	Users login(Users teacher);
}
