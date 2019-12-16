package com.ecust.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ecust.entity.Users;
import com.ecust.service.StudentService;
/**
 * 登录控制器
 * @author Dell
 *
 */
@Controller
public class LoginController {
	@Resource
	private StudentService studentServiceImpl;
	/**Log4j 用于项目发布到tomcat中后在控制台输出调试信息**/
	private static Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpSession session) {
		logger.error("登录成功！"+session.getAttribute("user"));
		return "student/student_main";

	}
	/**
	 * 验证登录
	 * @param user
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checklogin")
	public boolean checkLogin(Users user,HttpServletRequest req,String permission)
	{
		logger.error("checkLoginPermission:"+permission);
		switch (permission) {
		case "student":
			Users student=studentServiceImpl.login(user);
			if (student == null) {
				logger.error("登录失败！");
				return false;
			}
			else {
				req.getSession().setAttribute("id", student.getId());
				req.getSession().setAttribute("permission","student");
				req.getSession().setAttribute("user", student);
				return true;
			}
//		case "teacher":
//			Users teacher=studentServiceImpl.login(user);
//			if (teacher == null) {
//				return false;
//			}
//			else {
//				return true;
//			}
//		case "admin":
//			Users admin=studentServiceImpl.login(user);
//			if (admin == null) {
//				return false;
//			}
//			else {
//				return true;
//			}
		default:
			return false;
		}
		
	}
	
	/**
	 * 获取session域中存放的验证码返回给前端
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getcode")
	public String getCodeSession(HttpSession session) {
		logger.error("getcode中："+session.getAttribute("code"));
		return (String) session.getAttribute("code");
	}
	
	
	

}
