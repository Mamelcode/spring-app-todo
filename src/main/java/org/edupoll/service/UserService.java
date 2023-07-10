package org.edupoll.service;

import org.edupoll.model.entity.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public boolean addNewUser(User user) {
		User findUser = userRepository.findById(user.getId());
		
		if(findUser == null) {
			userRepository.createUser(user);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean findById(String id, String password) {
		User user = userRepository.findById(id);
		
		if(user == null) {
			return false;
		}
		
		if(user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
