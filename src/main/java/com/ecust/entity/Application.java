package com.ecust.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ecust.service.student.StudentService;

import lombok.Data;
/**
 * 实验记录本申请实体类
 * @author Dell
 *
 */
@Data
@Component
public class Application {
	private int id;
	private int projectId;    //所属项目序号
    private Project project; //所属项目
    private String applyReason;//申请原因
    private String applyTime;//申请时间
    private String applyStatus;//申请状态
    private String remark;//备注
    private int studentId;//所属学生id
    private Users student;
    public Application(){
    	applyStatus="未审核";
    }
    


}
