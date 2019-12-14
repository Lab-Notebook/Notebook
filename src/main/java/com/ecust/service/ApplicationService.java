package com.ecust.service;

import java.text.ParseException;
import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Users;

public interface ApplicationService{
	/**
	 * 选择该学生拥有的所有实验记录本申请
	 * @param student
	 * @return
	 */
	List<Application>showApplications(Users student) throws ParseException;
	
	/**
	 * 提交学生的实验记录本申请
	 * @param project
	 * @param reason
	 * @param remark
	 */
	boolean submitApplications(int studentId,String project,String reason,String remark);
}
