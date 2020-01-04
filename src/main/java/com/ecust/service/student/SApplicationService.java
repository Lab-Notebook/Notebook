package com.ecust.service.student;

import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Page;


public interface SApplicationService{
	/**
	 * 选择该学生拥有的所有实验记录本申请
	 * @param studentId
	 * @return
	 */
	List<Application>showApplications(int studentId,Page page);
	
	/**
	 * 提交学生的实验记录本申请
	 * @param project
	 * @param reason
	 * @param remark
	 */
	boolean submitApplications(int studentId,String project,String reason,String remark);
	
	/**
	 * 获得学生拥有的实验记录本总数量
	 * @param student
	 * @return
	 */
	int getApplicationCount(int studentId);
	
	

}
