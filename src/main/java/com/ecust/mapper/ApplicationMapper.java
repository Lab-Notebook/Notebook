package com.ecust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Application;
import com.ecust.entity.Users;

public interface ApplicationMapper {
	
	List<Application>selectByStudentId(int studentId,int pageStart,int pageSize);
	
	List<Application>selectByProjectId(int teacherId,int pageStart,int pageSize);
	
	@Insert("insert into book values(default,null,now(),null,default,"
			+ "null,#{remark},#{applyReason},#{projectId},#{studentId});")
	int insertIntoApplication(Application application);
	
	@Select("select count(*) from application where student_id=#{0}")
	int selectCount(int studentId);
	
	@Select("select count(*) from application a,t_p b "
			+ "where a.project_id=b.project_id and b.teacher_id=#{param1}")
	int selectUncheckedCount(int teacherId);
}
