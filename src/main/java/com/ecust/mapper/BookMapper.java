package com.ecust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;
/**
 * 实验记录本mapper
 * @author Dell
 *
 */
public interface BookMapper {
	@Select("select * from book where student_id=#{id}")
	List<Book>selectByStudentId(Users student);


}
