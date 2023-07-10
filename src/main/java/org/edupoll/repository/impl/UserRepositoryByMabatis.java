package org.edupoll.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.entity.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryByMabatis implements UserRepository{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	@Transactional
	public void createUser(User user) {
		sqlSession.insert("user.create", user);
	}

	@Override
	public User findById(String id) {
		return sqlSession.selectOne("user.findById", id);
	}

}
