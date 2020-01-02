package com.ecust.entity;

import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * 用户实体类
 * @author Dell
 *
 */
@Component
@Data
public class Users {
	private int id;//id
	private String username;//用于登录的用户名
	private String password;//密码
	private String name;//名字
	private String phoneNo;//电话
	private String sex;//性别
	private String email;//邮箱
	private Institute institute;
	
}
