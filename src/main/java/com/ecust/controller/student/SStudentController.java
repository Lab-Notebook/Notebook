package com.ecust.controller.student;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecust.controller.LoginController;
import com.ecust.entity.Users;
import com.ecust.service.student.StudentService;

@Controller
public class SStudentController {
	@Resource
	private StudentService studentServiceImpl;
	private static Logger logger = Logger.getLogger(LoginController.class);

	@ResponseBody
	@RequestMapping("changeinformation")
	public int changeInformation(Users student,HttpSession session) {
		logger.error("changeinformation");
		Users stu=(Users) session.getAttribute("user");
		stu.setEmail(student.getEmail());
		stu.setPhoneNo(student.getPhoneNo());
		session.setAttribute("user", stu);
		return studentServiceImpl.changeInformation(student);
	};

}
