package org.edupoll.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.edupoll.model.entity.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

public class InMemoryTodoRepository implements TodoRepository{

	List<Todo> list;
	
	@PostConstruct
	public void init() {
		list = new ArrayList<>();
//		list.add(new Todo("3rqw212r", "user", "자바공부", new Date(123, 6, 1), null));
//		list.add(new Todo("3rqw2fvd", "master", "웹공부", new Date(123, 7, 1), null));
//		list.add(new Todo("frq2t342", "master", "sql공부", new Date(123, 8, 1), null));
	}
	
	@Override
	public void create(Todo todo) {
		list.add(todo);
	}

	@Override
	public Todo findById(String id) {
		return list.stream().filter((one) -> {
			return one.getId().equals(id);
		}).findFirst().orElse(null);
	}
	
	@Override
	public List<Todo> findByOwner(String owner) {
		return list.stream().filter((one) -> {
			return one.getOwner().equals(owner);
		}).toList();
	}

	@Override
	public void deleteById(String id) {
		list.stream().filter((one) -> {
			return !one.getId().equals(id);
		}).toList();
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
