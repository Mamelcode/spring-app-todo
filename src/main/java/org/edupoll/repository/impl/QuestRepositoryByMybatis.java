package org.edupoll.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.entity.Quest;
import org.edupoll.model.entity.QuestJoin;
import org.edupoll.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestRepositoryByMybatis implements QuestRepository {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Quest> findRND3Quest() {
		return sqlSession.selectList("quest.findRnd3Quest");
	}

	@Override
	public Quest findByIdAndUserId(Integer id, String userId) {		
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("userId", userId);
		return sqlSession.selectOne("quest.findByIdAndUserId", map);
	}

	@Override
	public Quest findById(Integer id) {
		return sqlSession.selectOne("quest.findById", id);
	}

	@Override
	public void joinQuest(QuestJoin questJoin) {
		sqlSession.insert("quest.joinQuest", questJoin);
	}

	@Override
	public void deleteJoinQuest(QuestJoin questJoin) {
		sqlSession.delete("quest.deleteJoinQuest", questJoin);
	}
}
