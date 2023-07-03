package org.edupoll.model;

import java.util.Date;

public class Quest {
	int id;
	String description;
	Date endDate;
	int joinCnt;
	boolean join;
	
	
	public boolean isJoin() {
		return join;
	}
	public void setJoin(boolean join) {
		this.join = join;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getJoinCnt() {
		return joinCnt;
	}
	public void setJoinCnt(int joinCnt) {
		this.joinCnt = joinCnt;
	}
}
