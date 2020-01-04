package com.ecust.service.impl.student;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecust.controller.student.SBookController;
import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;
import com.ecust.mapper.student.SBookMapper;
import com.ecust.service.student.SBookService;
@Service
public class SBookServiceImpl implements SBookService{
	@Resource
	private SBookMapper bookMapper;
	private static Logger logger=Logger.getLogger(SBookController.class);
	
	@Override
	public List<Book> showBooks(Users student) {
		
		List<Book> list = bookMapper.selectByStudentId(student);
		logger.error("list:"+list);
		return list;
	}
	
	

	
	
}
