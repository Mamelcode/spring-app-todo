package org.edupoll.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.entity.Quest;
import org.edupoll.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Repository
//public class QuestRepositoryByMybatis implements QuestRepository {
//
//	@Autowired
//	SqlSession sqlSession;
//	
//	@Override
//	public List<Quest> findQuest() {
//		return sqlSession.selectList("quest.findQuest");
//	}
//
//	@Override
//	public void countUpdate(Quest quest) {
//		sqlSession.update("quest.update", quest);
//	}
//
//	@Override
//	public Quest findById(int id) {
//		return sqlSession.selectOne("quest.findById", id);
//	}
//}
