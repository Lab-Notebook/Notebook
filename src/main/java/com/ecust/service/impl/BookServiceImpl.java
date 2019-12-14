package com.ecust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecust.controller.BookController;
import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;
import com.ecust.mapper.BookMapper;
import com.ecust.service.BookService;
@Service
public class BookServiceImpl implements BookService{
	@Resource
	private BookMapper bookMapper;
	private static Logger logger=Logger.getLogger(BookController.class);
	public List<Book> showBooks(Users student) {
		
		List<Book> list = bookMapper.selectByStudentId(student);
		logger.error("list:"+list.get(0));
		return list;
	}

	
	
}
