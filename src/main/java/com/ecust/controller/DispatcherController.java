package com.ecust.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 调度控制器，负责各种页面跳转
 * @author Dell
 *
 */
@Controller
public class DispatcherController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	/**
	 * 跳转到“我的实验记录本”页面
	 * @return
	 */
	@RequestMapping("myexpnotebook")
	public String myExpNotebook() {
		logger.error("myexpnotebook");
		return "my_exp_notebook";
		
	}
	/**
	 * 跳转到“申请实验记录本”页面
	 * @return
	 */
	@RequestMapping("applyexpnotebook")
	public String applyExpNotebook() {
		logger.error("applyexpnotebook");
		return "apply_exp_notebook";
		
	}
	
	/**
	 * 跳转到“填写申请记录本表单页面”
	 * @return
	 */
	@RequestMapping("application")
	public String application(){
		logger.error("application");
		return null;
	}
}
