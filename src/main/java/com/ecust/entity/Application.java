package com.ecust.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Application {
	
	private int applicationId; //申请序号
	private int projectId;    //所属项目序号
    private Project project; //所属项目
    private String reason;//申请原因
    private String applyTime;//申请时间
    private String applyStatus;//申请状态
    private String remark;//备注
    private int studentId;//所属学生id
    
    


}
