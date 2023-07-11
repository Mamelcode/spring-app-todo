package org.edupoll.model.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Quest {
	private Integer id; // 기본키
	
	private String description; // 내용
	
	private LocalDateTime startDate; // 시작날짜
	
	private LocalDateTime endDate; // 종료날짜
	
	
	int joinCnt; // 참여자수 카운트


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public int getJoinCnt() {
		return joinCnt;
	}


	public void setJoinCnt(int joinCnt) {
		this.joinCnt = joinCnt;
	}
}
