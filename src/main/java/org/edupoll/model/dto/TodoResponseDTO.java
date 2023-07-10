package org.edupoll.model.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Todo;

public class TodoResponseDTO {

	private String id; // 식별자
	
	private String owner; // 설정자
	
	private String description; // 설명
	
	private String startDate; // 시작날짜
	
	private String endDate; // 종료날짜
	
	private String done; // 여부
	
	

	public TodoResponseDTO(Todo todo) {
		super();
		this.id = todo.getId();
		this.owner = todo.getOwner();
		this.description = todo.getDescription();
		this.startDate = todo.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.endDate = todo.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.done = todo.getDone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}
}
