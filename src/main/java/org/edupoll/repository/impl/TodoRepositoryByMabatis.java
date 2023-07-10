package org.edupoll.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.entity.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryByMabatis implements TodoRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(Todo todo) {
		sqlSession.insert("todo.create", todo);
	}

	@Override
	public Todo findById(String id) {
		return sqlSession.selectOne("todo.findById", id);
	}

	@Override
	public List<Todo> findByOwner(String owner) {
		return sqlSession.selectList("todo.findByOwner", owner);
	}

	@Override
	public void deleteById(String id) {
		sqlSession.delete("todo.deleteById", id);	
	}

	@Override
	public void update(Todo todo) {
		sqlSession.update("todo.update", todo);
	}
	
	@Override
	public void updateDone(Todo todo) {
		sqlSession.update("todo.doneUpdate", todo);
	}
}
