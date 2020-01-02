package com.ecust.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Record {
	private int recordId;
	private String name;
	private String doneTime;
	private String checkTime;
	private String uploadTime;
	private String isCheck;
	private String isOpen;
	private String instruction;
	private int bookId;
}
