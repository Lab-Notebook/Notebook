package com.ecust.service.impl.teacher;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import com.ecust.controller.student.SBookController;
import com.ecust.entity.Application;
import com.ecust.entity.Page;
import com.ecust.entity.Users;
import com.ecust.mapper.teacher.TApplicationMapper;
import com.ecust.mapper.student.SProjectMapper;
import com.ecust.service.teacher.TApplicationService;

@Service
public class TApplicationServiceImpl implements TApplicationService{
	@Resource
	private TApplicationMapper applicationMapper;
	@Resource
	private SProjectMapper projectMapper;
	@Autowired
	private ApplicationContext applicationContext;
	private static Logger logger=Logger.getLogger(SBookController.class);
	

	public int getUncheckedCount(int teacherId) {
		return applicationMapper.selectUncheckedCount(teacherId);
	}
	
	@Override
	public List<Application> showUncheckedApplications(int teacherId, Page page) {
		int pageStart=(page.getPageNumber()-1)*10;
		List<Application> list = applicationMapper.selectByProjectId(teacherId,pageStart,page.getPageSize());
		for (Application application : list) {
			logger.error(application);
		}
		return list;
	}


}
