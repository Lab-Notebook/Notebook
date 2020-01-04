package com.ecust.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
/**
 * 调度控制器，负责各种页面跳转
 * @author Dell
 *
 */
@Controller
public class TDispatcherController {
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger = Logger.getLogger(TDispatcherController.class);
	
	/**
	 * 跳转到“查看实验记录本申请页面”
	 * @return
	 */
	@RequestMapping("checkapplication")
	public String checkApplication(){
		return "teacher/check_application";
	}
	
	/**
	 * 跳转到“审核实验记录页面”
	 * @return
	 */
	@RequestMapping("checkrecord")
	public String checkRecord(){
		return "teacher/check_record";
	}
	
	/**
	 * 跳转到“教师创建新的实验记录本页面”
	 * @return
	 */
	@RequestMapping("createnewnotebook")
	public ModelAndView createNewNotebook(int num,HttpSession session){
		List<Application> applications = (List<Application>) session.getAttribute("applications");
		ModelAndView mav=new ModelAndView("teacher/create_new_notebook");
		mav.addObject("book",applications.get(num-1));
		return mav;
	}
	

	

}
