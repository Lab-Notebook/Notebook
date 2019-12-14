package com.ecust.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecust.entity.Project;
import com.ecust.service.ProjectService;

/**
 * 项目控制器
 * @author Dell
 *
 */
@Controller
public class ProjectController {
	@Resource
	private ProjectService projectServiceImpl;
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@ResponseBody
	@RequestMapping("showproject")
	public List<Project> showProject(){
		return projectServiceImpl.selectAll();
	}
}
