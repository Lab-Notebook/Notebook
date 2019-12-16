package com.ecust.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Page {
		//每页显示个数
		@Value("10")
		private int pageSize;
		//当前第几页
		@Value("1")
		private int pageNumber;
		//总页数
		private int count;
		//当前页显示的数据
		private List<?> list;
		

		
		
}
