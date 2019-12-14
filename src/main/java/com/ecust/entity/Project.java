package com.ecust.entity;

import org.springframework.stereotype.Component;

@Component
public class Project {
	private int projectId;
	private String name;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + "]";
	}
	
	
}
