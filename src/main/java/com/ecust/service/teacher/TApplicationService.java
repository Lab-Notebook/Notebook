package com.ecust.service.teacher;

import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Page;


public interface TApplicationService{
	
	
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
