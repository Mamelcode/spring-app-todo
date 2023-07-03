package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.Todo;

public interface TodoRepository {
	public void create(Todo todo);
	public Todo findById(String id);
	public List<Todo> findByOwner(String owner);
	public void deleteById(String id);
	public void update(Todo todo);
	public void updateDone(Todo todo);
}
