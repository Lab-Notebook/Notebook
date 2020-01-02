package com.ecust.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Institute {
	private int instituteId;
	private String name;
	private String phone;
}
