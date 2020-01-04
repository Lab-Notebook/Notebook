package com.ecust.mapper.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ecust.entity.Application;
import com.ecust.entity.Users;

public interface TApplicationMapper {
	/**
	 * 选择此指导教师负责的项目下的实验记录本申请	
	 * @param teacherId
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	List<Application>selectByProjectId(int teacherId,int pageStart,int pageSize);
	
	

	/**
	 * 选择此指导教师负责的项目下的实验记录本申请总数
	 * @param teacherId
	 * @return
	 */
	@Select("select count(*) from application a,t_p b "
			+ "where a.project_id=b.project_id and b.teacher_id=#{param1}")
	int selectUncheckedCount(int teacherId);
}
