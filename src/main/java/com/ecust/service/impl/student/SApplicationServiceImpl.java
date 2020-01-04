package com.ecust.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ecust.controller.student.SBookController;
import com.ecust.entity.Application;
import com.ecust.entity.Page;
import com.ecust.entity.Users;
import com.ecust.mapper.student.SApplicationMapper;
import com.ecust.mapper.student.SProjectMapper;
import com.ecust.service.student.SApplicationService;

@Service
public class SApplicationServiceImpl implements SApplicationService{
	@Resource
	private SApplicationMapper applicationMapper;
	@Resource
	private SProjectMapper projectMapper;
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger=Logger.getLogger(SBookController.class);
	
	
	public List<Application> showApplications(int studentId,Page page) {
		int pageStart=(page.getPageNumber()-1)*10;
		List<Application> list = applicationMapper.selectByStudentId(studentId,pageStart,page.getPageSize());
		for (Application application : list) {
			logger.error(application);
		}
		return list;
	}


	@Override
	public boolean submitApplications(int studentId,String project, String reason, String remark) {
		int projectId=projectMapper.selectIdByName(project);
		Application application = applicationContext.getBean("application",Application.class);
		application.setStudentId(studentId);
		application.setProjectId(projectId);
		application.setApplyReason(reason);
		if(remark!="")
			application.setRemark(remark);
		int success = applicationMapper.insertIntoApplication(application);
		if(success==1) {
			logger.error("成功提交申请单到数据库");
			return true;
		}
		else {
			logger.error("提交申请单失败");
			return false;
		}
	}


	@Override
	public int getApplicationCount(int studentId) {
		return applicationMapper.selectCount(studentId);
	}




}
