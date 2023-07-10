package org.edupoll.model.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.edupoll.model.dto.TodoRequestDTO;

public class Todo {
	
	private String id; // 식별자
	
	private String owner; // 설정자
	
	private String description; // 설명
	
	private LocalDateTime startDate; // 시작날짜
	
	private LocalDateTime endDate; // 종료날짜
	
	private String done; // 여부
	
	public Todo() {
		super();
	}
	
	public Todo(String id, String owner, TodoRequestDTO dto) {
		super();
		this.id = id;
		this.owner = owner;
		this.description = dto.getDescription();
		this.startDate = LocalDateTime.parse(dto.getStartDate(), DateTimeFormatter.ISO_DATE_TIME);
		this.endDate = LocalDateTime.parse(dto.getEndDate(), DateTimeFormatter.ISO_DATE_TIME);
		this.done = "N";
	}
	
	public Todo(TodoRequestDTO dto) {
		super();
		this.id = dto.getId();
		this.description = dto.getDescription();
		this.startDate = LocalDateTime.parse(dto.getStartDate(), DateTimeFormatter.ISO_DATE_TIME);
		this.endDate = LocalDateTime.parse(dto.getEndDate(), DateTimeFormatter.ISO_DATE_TIME);
	}

	@Override
	public String toString() {
		return "Todo [owner=" + owner + ", description=" + description + ", startDate=" + startDate + ", endDate="
				+ endDate + ", done=" + done + "]";
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}
}
