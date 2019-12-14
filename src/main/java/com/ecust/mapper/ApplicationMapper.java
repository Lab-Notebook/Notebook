package com.ecust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Application;
import com.ecust.entity.Users;

public interface ApplicationMapper {
	
	List<Application>selectByStudentId(Users student);
	
	@Select("select project_id from project where name=#{0}")
	int selectIdByName(String name);
	
	@Insert("insert into application values(default,#{projectId},#{reason},now(),default,#{remark},#{studentId});")
	@Options(keyProperty = "applicationId")
	int insertIntoApplication(Application application);
}
