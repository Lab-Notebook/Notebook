package com.ecust.mapper.teacher;

import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Users;
/**
 * 教师Mapper，用于对教师表的增删改查
 * @author Dell
 *
 */
public interface TeacherMapper {
	
	@Select("select * from teacher where username=#{username} "
			+ "and password=#{password}")
	Users selectByUserPwd(Users teacher);
}
