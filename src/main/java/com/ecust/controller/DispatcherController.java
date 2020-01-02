package com.ecust.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Page;
/**
 * 调度控制器，负责各种页面跳转
 * @author Dell
 *
 */
@Controller
public class DispatcherController {
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger = Logger.getLogger(LoginController.class);
	/**
	 * 跳转到“我的实验记录本”页面
	 * @return
	 */
	@RequestMapping("myexpnotebook")
	public String myExpNotebook() {
		return "student/my_exp_notebook";
		
	}
	/**
	 * 跳转到“申请实验记录本”页面
	 * @return
	 */
	@RequestMapping("applyexpnotebook")
	public String applyExpNotebook() {
		logger.error("applyexpnotebook");
		return "student/apply_exp_notebook";
		
	}
	
	/**
	 * 跳转到“填写申请记录本表单页面”
	 * @return
	 */
	@RequestMapping("application")
	public String application(){
		return "student/application";
	}
	
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
	
	/**
	 * 跳转到学生的某一实验记录本页面
	 * @return
	 */
	@RequestMapping("openbook")
	public ModelAndView openBook(int num,HttpSession session){
		List<Book> books = (List<Book>) session.getAttribute("books");
		ModelAndView mav=new ModelAndView("student/certain_notebook");
		mav.addObject("book",books.get(num-1));
		return mav;
	}
	
	
	/**
	 * 跳转到"个人信息"页面
	 * @return
	 */
	@RequestMapping("information")
	public String information(){
		return "student/information";
	}
	
	/**
	 * 跳转到"修改个人信息"页面
	 * @return
	 */
	@RequestMapping("change")
	public String changeInformation(){
		return "student/change_information";
	}
}
