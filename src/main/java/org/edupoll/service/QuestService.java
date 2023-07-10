package org.edupoll.service;

import java.util.List;

import org.edupoll.model.entity.Quest;
import org.edupoll.repository.QuestRepository;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestService {
	
//	@Autowired
	QuestRepository questRepository;
	
//	@Autowired
	TodoRepository todoRepository;
	
	public List<Quest> getQuest() {
		return questRepository.findQuest();
	}
	
	@Transactional
	public boolean joinQuest(int id) {
		Quest quest = questRepository.findById(id);
		int cnt = quest.getJoinCnt();
		quest.setJoinCnt(++cnt);
		questRepository.countUpdate(quest);
		return true;
	}
	
	public Quest findById(int id) {
		return questRepository.findById(id);
	}
}
