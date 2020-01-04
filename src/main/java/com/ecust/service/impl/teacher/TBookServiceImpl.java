package com.ecust.service.impl.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.ecust.entity.Book;
import com.ecust.mapper.teacher.TBookMapper;
import com.ecust.service.teacher.TBookService;
@Service
public class TBookServiceImpl implements TBookService{
	@Resource
	private TBookMapper bookMapper;
	private static Logger logger=Logger.getLogger(TBookServiceImpl.class);
	
	
	@Override
	public int createBook(Book book) {
		return bookMapper.updateByBookId(book);
	}

	@Override
	public int deleteBook(Book book) {
		return bookMapper.deleteByBookId(book);
	}

	
	
}
