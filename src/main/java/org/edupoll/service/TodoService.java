package org.edupoll.service;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	@Transactional
	public boolean addNewTodo(Todo todo, String logonId) {
		String id = UUID.randomUUID().toString().split("-")[0];
		Todo found = todoRepository.findById(id);
		if(found == null) {
			todo.setId(id);
			todo.setOwner(logonId);
			todoRepository.create(todo);
			return true;
		}else {
			return false;
		}
	}

	public List<Todo> getTodos(String logonId) {
		return todoRepository.findByOwner(logonId);
	}
	
	@Transactional
	public boolean removeTodo(String todoId, String commander) {
		Todo todo = todoRepository.findById(todoId);
		if(todo == null) {
			return false;
		}else {
			if(todo.getOwner().equals(commander)) { 
				todoRepository.deleteById(todoId);
				return true;
			}else {
				return false;
			}
		}
	}

	public Todo getTodo(String todoId) {
		return todoRepository.findById(todoId);
	}
	
	@Transactional
	public boolean updateTodo(Todo todo, String userId) {
		if(todo == null) {
			return false;
		}else {
			Todo t = todoRepository.findById(todo.getId());
			if(t.getOwner().equals(userId)) {
				todoRepository.update(todo);
				return true;
			}else {
				return false;
			}
		}
	}
	
	@Transactional
	public boolean updateDone(Todo todo, String userId) {
		if(todo == null) {
			return false;
		}else {
			Todo t = todoRepository.findById(todo.getId());
			if(t.getOwner().equals(userId)) {
				todoRepository.updateDone(todo);
				return true;
			}else {
				return false;
			}
		}
	}
}
