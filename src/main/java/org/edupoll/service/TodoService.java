package org.edupoll.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.edupoll.model.dto.TodoRequestDTO;
import org.edupoll.model.dto.TodoResponseDTO;
import org.edupoll.model.entity.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	@Transactional
	public boolean addNewTodo(TodoRequestDTO dto, String logonId) {
		String id = UUID.randomUUID().toString().split("-")[0];
		Todo found = todoRepository.findById(id);
		if(found == null) {
			todoRepository.create(new Todo(id, logonId, dto));
			return true;
		}else {
			return false;
		}
	}

	public List<TodoResponseDTO> getTodos(String logonId) {
		List<Todo> todos = todoRepository.findByOwner(logonId);
		
		List<TodoResponseDTO> finds = new ArrayList<>();
		for(Todo t : todos) {
			if(Duration.between(LocalDateTime.now(), t.getEndDate()).toMillis() < 0) {
				t.setDone("P");
				todoRepository.updateDone(t);
			}
			
			finds.add(new TodoResponseDTO(t));
		}
		
		return finds;
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

	// 특정 todo 가져오기
	public TodoResponseDTO getTodo(String todoId) {
		return new TodoResponseDTO(todoRepository.findById(todoId));
	}
	
	@Transactional
	public boolean updateTodo(TodoRequestDTO todo, String userId) {
		if(todo == null) {
			return false;
		}else {
			Todo t = todoRepository.findById(todo.getId());
			if(t.getOwner().equals(userId)) {
				todoRepository.update(new Todo(todo));
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
