package com.ecust.service;

import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Page;


public interface ApplicationService{
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
	
	/**
	 * 选择该老师所管理的项目中的未审核的实验记录本(实验记录本申请)
	 * @param teacherId
	 * @param page
	 * @return
	 */
	List<Application>showUncheckedApplications(int teacherId,Page page);
	
	/**
	 * 选择该老师所管理的项目未审核实验记录本的个数
	 * @param teacherId
	 * @return
	 */
	public int getUncheckedCount(int teacherId);
	

}
