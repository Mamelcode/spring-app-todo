package org.edupoll.repository;

import org.edupoll.model.entity.User;

public interface UserRepository {
	
	public void createUser(User user);
	public User findById(String id);
}
