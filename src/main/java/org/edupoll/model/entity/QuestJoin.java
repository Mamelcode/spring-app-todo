package org.edupoll.model.entity;

import jakarta.validation.constraints.NotNull;

public class QuestJoin {
	
	Integer Id; // 기본키
	
	@NotNull
	String userId; // 유저아이디

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
