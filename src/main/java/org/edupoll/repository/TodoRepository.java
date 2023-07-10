package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Todo;

public interface TodoRepository {
	
	// todo 생성
	public void create(Todo todo);
	
	// 특정 todo 가져오기
	public Todo findById(String id);
	
	// 전체 todo 가져오기
	public List<Todo> findByOwner(String owner);
	
	// 특정 todo 삭제
	public void deleteById(String id);
	
	// 특정 todo 업데이트
	public void update(Todo todo);
	
	// done 업데이트
	public void updateDone(Todo todo);
}
