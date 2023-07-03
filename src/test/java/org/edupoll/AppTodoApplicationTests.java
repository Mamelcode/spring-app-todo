package org.edupoll;

import java.util.List;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.edupoll.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTodoApplicationTests {

	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	AuthService authService;
	
	@Test
	void contextLoads() {
		
//		System.out.println(authService.isValidate("user", "1q2w3e4r"));
//		System.out.println(authService.isValidate("user", "1q2w"));
//		System.out.println(authService.isValidate("test", "1q2w3e4r"));
		
//		todoRepository.create(new Todo("z1", "naruto", null, null, null));
//		todoRepository.create(new Todo("z2", "master", null, null, null));
//		todoRepository.create(new Todo("z3", "master", null, null, null));
		
//		List<Todo> list = todoRepository.findByOwner("naruto");
//		
//		System.out.println(list);
//		
//		Todo found = todoRepository.findById("z11");
//		System.out.println(found);
	}

}
