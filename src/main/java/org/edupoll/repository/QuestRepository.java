package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.Quest;

public interface QuestRepository {
	public List<Quest> findQuest();
	public void countUpdate(Quest quest);
	public Quest findById(int id);
}
