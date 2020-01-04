package com.ecust.controller.student;
import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ecust.entity.Book;
import com.ecust.entity.Record;
import com.ecust.service.student.SRecordService;

@Controller
public class SRecordController {
	@Resource
	private SRecordService recordServiceImpl;
	private static Logger logger=Logger.getLogger(SRecordController.class);
	
	@RequestMapping("getrecords")
	@ResponseBody
	public List<Record>getRecords(Book book){
		return recordServiceImpl.getRecords(book);
	}
	
	@RequestMapping("submitrecord")
	public String submitRecord(MultipartFile file) throws IOException{
		logger.error("submitRecord");
		logger.error("filename:"+file.getOriginalFilename()+" fileSize"+file.getSize());
		return "";
	}
	
}
