package org.edupoll.model.dto;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Quest;

public class QuestResponseDTO {
	private Integer id;
	
	private String description;
	
	private String startDate;
	
	private String endDate;
	
	private int joinCnt;
	
	private boolean joined;
	
	public QuestResponseDTO() {
		super();
	}
	
	public QuestResponseDTO(Quest quest) {
		super();
		this.id = quest.getId();
		this.description = quest.getDescription();
		this.startDate = quest.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.endDate = quest.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
		this.joinCnt = quest.getJoinCnt();
	}

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

	public int getJoinCnt() {
		return joinCnt;
	}

	public void setJoinCnt(int joinCnt) {
		this.joinCnt = joinCnt;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}
}
