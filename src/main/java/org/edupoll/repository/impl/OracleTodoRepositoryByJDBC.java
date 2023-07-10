package org.edupoll.repository.impl;

import java.util.List;

import org.edupoll.model.entity.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class OracleTodoRepositoryByJDBC implements TodoRepository {
	
//	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(Todo todo) {
		String sql = "INSERT INTO TODOS VALUES(?,?,?,?,?)";
//		jdbcTemplate.update(sql
//				,todo.getId(), todo.getOwner(), todo.getDescription(), todo.getTargetDate()
//				,todo.getDone());
	}
	
	@Override
	public void deleteById(String id) {
		String sql = "DELETE FROM TODOS WHERE ID = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Todo findById(String id) {
		String sql = "SELECT * FROM TODOS WHERE ID=?";
		List<Todo> list = jdbcTemplate.query(sql, todoRowMapper(), id);
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public List<Todo> findByOwner(String owner) {
		String sql = "SELECT * FROM TODOS WHERE OWNER=?";
		List<Todo> list = jdbcTemplate.query(sql, todoRowMapper(), owner);
		return list;
	}
	
	private RowMapper<Todo> todoRowMapper() {
		return (rs, rowNum) -> {
			Todo todo = new Todo();
			todo.setId(rs.getString("id"));
			todo.setDescription(rs.getString("description"));
			todo.setDone(rs.getString("done"));
			todo.setOwner(rs.getString("owner"));
//			todo.setTargetDate(rs.getDate("target_Date"));
			return todo;
		};
	}

	@Override
	public void update(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDone(Todo todo) {
		// TODO Auto-generated method stub
		
	}
}
