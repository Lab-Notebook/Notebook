package com.ecust.service.student;

import java.util.List;

import com.ecust.entity.Book;
import com.ecust.entity.Record;

public interface SRecordService {
	/**
	 * 获取该实验记录本下的所有实验记录
	 * @param book
	 * @return
	 */
	List<Record>getRecords(Book book);
	
	int uploadRecord();
}
