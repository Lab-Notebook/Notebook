package com.ecust.controller.teacher;


import java.util.List;


import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ecust.entity.Application;
import com.ecust.entity.Page;
import com.ecust.entity.Users;
import com.ecust.service.teacher.TApplicationService;
/**
 * 实验记录本申请控制器
 * @author Dell
 *
 */
@Controller
public class TApplicationController {
	@Resource
	private TApplicationService applicationServiceImpl;
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger=Logger.getLogger(TApplicationController.class);
	
	@ModelAttribute()
	public String isLogin(HttpSession session) {
		Users user=(Users)session.getAttribute("user");
		if (user==null) {
			return "redirect:login.jsp";
		}
		return null;
	}
	
	/**
	 * 指导教师查看实验记录本申请单并审核
	 * @param pageNumber
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("teacher/showapplication")
	public Page showTeacherApplications(int pageNumber,HttpSession session){
		int teacherId=(int) session.getAttribute("id");
		Page page = applicationContext.getBean("page",Page.class);
		page.setPageNumber(pageNumber);
		List<Application> applications = applicationServiceImpl.showUncheckedApplications(teacherId, page);
		Page newPage = applicationContext.getBean("page",Page.class);
		newPage.setCount(applicationServiceImpl.getUncheckedCount(teacherId));
		newPage.setCount(20);
		newPage.setList(applications);
		newPage.setPageNumber(page.getPageNumber());	
		session.setAttribute("applications", applications);
		return newPage;
	}
	
	
	

	
	
}
