package com.ecust.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Lab {
	private int labId;
	private String name;
	private String phone;
}
