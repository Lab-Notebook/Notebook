package com.ecust.service;

import java.util.List;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;

public interface BookService {
	/**
	 * 选择该学生拥有的所有实验记录本
	 * @return
	 */
	List<Book>showBooks(Users student);

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
