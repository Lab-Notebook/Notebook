package com.ecust.service.teacher;

import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;

public interface TBookService {

	/**
	 *  教师审核申请之后，新建一个实验记录本
	 * @param book
	 * @return
	 */
	int createBook(Book book);
	
	/**
	 * 删除实验记录本
	 * @param book
	 * @return
	 */
	int deleteBook(Book book);
}
