package com.ecust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Book;
import com.ecust.entity.Record;


public interface RecordMapper {
	@Select("select * from record where book_id=#{bookId}")
	List<Record>selectAllByBookId(Book book);
}
