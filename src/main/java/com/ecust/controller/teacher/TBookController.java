package com.ecust.controller.teacher;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.ecust.entity.Book;
import com.ecust.service.teacher.TBookService;
/**
 * 实验记录本控制器
 * @author Dell
 *
 */
@Controller
public class TBookController {
	@Resource
	private TBookService bookServiceImpl;
	private static Logger logger=Logger.getLogger(TBookController.class);
	

	
	/**
	 * 新建实验记录本
	 * @param book
	 * @return
	 */
	@ResponseBody
	@RequestMapping("createbook")
	public int createBook(Book book) {
		return bookServiceImpl.createBook(book);
	}
	
	/**
	 * 删除实验记录本
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteapplication")
	public int deleteApplication(int num,Book book) {
		book.setBookId(num);
		int success = bookServiceImpl.deleteBook(book);
		return success;
	}
}
