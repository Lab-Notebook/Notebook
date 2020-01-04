package com.ecust.controller.student;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ecust.entity.Application;
import com.ecust.entity.Page;
import com.ecust.entity.Users;
import com.ecust.service.student.SApplicationService;
/**
 * 实验记录本申请控制器
 * @author Dell
 *
 */
@Controller
public class SApplicationController {
	@Resource
	private SApplicationService applicationServiceImpl;
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger=Logger.getLogger(SBookController.class);
	
	@ModelAttribute()
	public String isLogin(HttpSession session) {
		Users user=(Users)session.getAttribute("user");
		if (user==null) {
			return "redirect:login.jsp";
		}
		return null;
	}
	
	/**
	 * 显示该学生拥有的所有记录本申请
	 * @param pageNumber
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("student/showapplication")
	public Page showStudentApplications(int pageNumber,HttpSession session){
		int studentId=(int) session.getAttribute("id");
		Page page = applicationContext.getBean("page",Page.class);
		page.setPageNumber(pageNumber);
		List<Application> applications = applicationServiceImpl.showApplications(studentId,page);
		Page newPage = applicationContext.getBean("page",Page.class);
		newPage.setCount(applicationServiceImpl.getApplicationCount(studentId));
		newPage.setList(applications);
		newPage.setPageNumber(page.getPageNumber());	
		return newPage;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("submitapplication")
	public boolean submitApplication(String project,String reason,String remark,HttpSession session) {
		int studentId = (int) session.getAttribute("id");
		boolean success = applicationServiceImpl.submitApplications(studentId, project, reason, remark);
		return success;
	}
	
	@ResponseBody
	@RequestMapping("getapplicationcount")
	public int getApplicationCount(HttpSession session) {
		int studentId=(int) session.getAttribute("id");
		int count = applicationServiceImpl.getApplicationCount(studentId);
		logger.error("count:"+count);
		session.setAttribute("applicationCount", count);
		return count;
	}
	
	
}
