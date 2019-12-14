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

}
