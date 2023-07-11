package org.edupoll.model.entity;

public class QuestJoin {
	
	Integer Id; // 기본키
	
	String userId; // 유저아이디
	
	public QuestJoin() {
		super();
	}
	
	public QuestJoin(Integer id, String userId) {
		super();
		Id = id;
		this.userId = userId;
	}
	
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
