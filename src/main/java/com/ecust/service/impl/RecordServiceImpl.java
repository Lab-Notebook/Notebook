package com.ecust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecust.controller.LoginController;
import com.ecust.entity.Book;
import com.ecust.entity.Record;
import com.ecust.mapper.RecordMapper;
import com.ecust.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
	@Resource
	private RecordMapper recordMapper;
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Override
	public List<Record> getRecords(Book book) {
		List<Record> list = recordMapper.selectAllByBookId(book);
		for (Record record : list) {
			if (record.getIsCheck()=="0") {
				record.setIsCheck("未审核");
			}
			else {
				record.setIsCheck("已审核");
			}
			if (record.getIsOpen()=="0") {
				record.setIsOpen("不公开");
			}
			else {
				record.setIsOpen("公开");
			}
		}
		return list;
	}

	@Override
	public int uploadRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

}
