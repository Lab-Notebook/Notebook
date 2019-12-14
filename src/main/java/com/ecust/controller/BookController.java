package com.ecust.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;
import com.ecust.service.BookService;
/**
 * 实验记录本控制器
 * @author Dell
 *
 */
@Controller
public class BookController {
	@Resource
	private BookService bookServiceImpl;
	private static Logger logger=Logger.getLogger(BookController.class);
	
	/**
	 * 显示此学生用户所有的实验记录本信息
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showbook")
	public List<Book>showBooks(Users student){
		return bookServiceImpl.showBooks(student);
		
	}
	
	
}
