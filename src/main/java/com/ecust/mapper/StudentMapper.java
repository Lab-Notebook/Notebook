package com.ecust.mapper;


import org.apache.ibatis.annotations.Select;
import com.ecust.entity.Users;
/**
 * 学生mapper，用于对学生用户信息的增删改查
 * @author Dell
 *
 */
public interface StudentMapper {
	
	@Select("select * from student where username=#{username} and password=#{password}")
	Users selectByUserPwd(Users student);
}
