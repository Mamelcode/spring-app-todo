package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Quest;
import org.edupoll.model.entity.QuestJoin;

public interface QuestRepository {
	public List<Quest> findRND3Quest();
	public Quest findByIdAndUserId(Integer id, String userId);
	public Quest findById(Integer id);
	
	public void joinQuest(QuestJoin questJoin);
	public void deleteJoinQuest(QuestJoin questJoin);
}
