package com.ecust.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecust.entity.Application;
import com.ecust.entity.Project;
import com.ecust.entity.Users;
import com.ecust.service.ApplicationService;
/**
 * 实验记录本申请控制器
 * @author Dell
 *
 */
@Controller
public class ApplicationController {
	@Resource
	private ApplicationService applicationServiceImpl;
	private static Logger logger=Logger.getLogger(BookController.class);
	
	@ResponseBody
	@RequestMapping("showapplication")
	public List<Application>showApplications(HttpSession session) throws ParseException{
		
		return applicationServiceImpl.showApplications((Users)session.getAttribute("user"));
		
	}
	
	@ResponseBody
	@RequestMapping("submitapplication")
	public boolean submitApplication(String project,String reason,String remark,HttpSession session) {
		Users student = (Users) session.getAttribute("user");
		boolean success = applicationServiceImpl.submitApplications(student.getId(), project, reason, remark);
		return success;
	}
}
