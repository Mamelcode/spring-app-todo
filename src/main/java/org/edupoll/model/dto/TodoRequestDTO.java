package org.edupoll.model.dto;

import jakarta.validation.constraints.NotNull;

public class TodoRequestDTO {
	
	String id;
	@NotNull
	String description;
	@NotNull
	String startDate;
	@NotNull
	String endDate;
	
	
	@Override
	public String toString() {
		return "TodoRequestDTO [description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
