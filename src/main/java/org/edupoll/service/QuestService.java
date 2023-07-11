package org.edupoll.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.edupoll.model.dto.QuestResponseDTO;
import org.edupoll.model.entity.Quest;
import org.edupoll.model.entity.QuestJoin;
import org.edupoll.model.entity.Todo;
import org.edupoll.repository.QuestRepository;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestService {
	
	@Autowired
	QuestRepository questRepository;
	
	@Autowired
	TodoRepository todoRepository;
	
	// 퀘스트 목록 3개를 가져온다
	public List<QuestResponseDTO> getQuest(String userId) {
		List<QuestResponseDTO> quests = questRepository.findRND3Quest().stream().map(QuestResponseDTO::new).toList();
		for(QuestResponseDTO q : quests) {
			if(questRepository.findByIdAndUserId(q.getId(), userId) != null) {
				q.setJoined(true);
			}
		}
				
		return quests;
	}
	
	// 퀘스트에 참여한다
	@Transactional
	public void joinQuest(String userId, Integer id) {
		
		// 퀘스트에 참여한다.(참여목록에 추가)
		questRepository.joinQuest(new QuestJoin(id, userId));
		
		// 참여한 퀘스트를 가져온다.
		Quest quest = questRepository.findById(id);
				
		// 참여한 퀘스트 내용을 내 일정에 추가한다
		todoRepository.create(new Todo(quest, userId));
	}
	
	
	public Quest findById(int id) {
		return questRepository.findById(id);
	}
}
