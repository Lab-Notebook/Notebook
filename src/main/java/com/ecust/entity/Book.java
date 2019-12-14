package com.ecust.entity;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
/**
 * 实验记录本实体类
 * @author Dell
 *
 */

@Component
@Data
public class Book {
	private int bookId;//id
	private String name;//名称
	private Date applyTime;//申请时间
	private Date getTime;//领取时间
	private int isCheck;//审核状态
	private int pageNum;//总页数
	private String remark;//备注
	private String applyReason;//申请原因
	private int projectId;//所属项目的id
	private int studentId;//所属学生的id
}
