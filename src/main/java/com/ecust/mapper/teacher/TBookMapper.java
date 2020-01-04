package com.ecust.mapper.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ecust.entity.Application;
import com.ecust.entity.Book;
import com.ecust.entity.Users;

import lombok.Delegate;
/**
 * 实验记录本mapper
 * @author Dell
 *
 */
public interface TBookMapper {
	/**
	 * 教师审核实验记录本通过之后，将实验记录本的审核状态由未审核改为审核通过
	 * @param book
	 * @return
	 */
	@Update("update book a left join project b "
			+ "on a.project_id=b.project_id "
			+ "set get_time=now(),"
			+ "apply_status=1,page_num=#{pageNum},"
			+ "a.name=b.name "
			+ "where a.book_id=#{bookId} ")
	int updateByBookId(Book book);
	
	@Delete("delete from book where book_id=#{bookId}")
	int deleteByBookId(Book book);
	
}
