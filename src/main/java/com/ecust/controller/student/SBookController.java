package com.ecust.controller.student;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;
import com.ecust.service.student.SBookService;
/**
 * 实验记录本控制器
 * @author Dell
 *
 */
@Controller
public class SBookController {
	@Resource
	private SBookService bookServiceImpl;
	private static Logger logger=Logger.getLogger(SBookController.class);
	
	/**
	 * 显示此学生用户所有的实验记录本信息
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showbook")
	public List<Book>showBooks(Users student,HttpSession session){
		int id = (int)session.getAttribute("id");
		student.setId(id);
		List<Book> books = bookServiceImpl.showBooks(student);
		session.setAttribute("books", books);
		return books;
		
	}
	
	
}
