package org.edupoll.comtroller;

import java.util.List;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.service.QuestService;
import org.edupoll.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {
	
	Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	TodoService todoService;
	
	@Autowired
	QuestService questService;
	
	@GetMapping
	public String gotoTodoList(@SessionAttribute String logonId, ModelMap model) {
		List<Todo> todos = todoService.getTodos(logonId);
		List<Quest> quest = questService.getQuest();
		
		for(Todo t : todos) {
			for(Quest q : quest) {
				if(t.getDescription().equals(q.getDescription())) {
					q.setJoin(true);
				}
			}
		}
		
		model.put("todos", todos);
		model.put("quest", quest);
		
		return "todos/list";
	}
	
	@GetMapping("/create")
	public String gotoCrateTodoView() {
		return "todos/create";
	}
	
	@PostMapping("/create-task")
	public String createTask(@Valid Todo todo, BindingResult result, Model model, 
			@SessionAttribute String logonId) {
		logger.info("Todo`s {}, {}", todo.toString());
		if(result.hasErrors()) {
			model.addAttribute("msg", "유효하지 않습니다.");
			return "todos/create";			
		}else {
			boolean rst = todoService.addNewTodo(todo, logonId);
			if(rst) {
				return "redirect:/todos";
			}else {
				return "todos/create";
			}
		}
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(String todoId, @SessionAttribute String logonId) {
		logger.info("Todo`s {}, {}", todoId);
		
		boolean result = todoService.removeTodo(todoId, logonId);
		
		if(result) {
			return "redirect:/todos";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/update")
	public String updateView(String todoId, Model model) {
		logger.info("Todo`s {}, {}", todoId);
		
		Todo todo = todoService.getTodo(todoId);
		model.addAttribute("todo", todo);
		
		return "todos/update";
	}
	
	@PostMapping("/update-task")
	public String updateTask(@Valid Todo todo, BindingResult result, 
			@SessionAttribute String logonId, Model model) {
		logger.info("Todo`s {}, {}", todo.toString());
		if(result.hasErrors()) {
			model.addAttribute("todo", todo);
			model.addAttribute("error", "데이터가 유효하지 않습니다.");
			return "todos/update";
		}else {
			boolean r = todoService.updateTodo(todo, logonId);
			if(r) {
				return "redirect:/todos";
			}else {
				model.addAttribute("todo", todo);
				model.addAttribute("error", "요청에 실패했습니다.");
				return "todos/update";
			}
		}
	}
	
	@GetMapping("/success")
	public String udateDone(Todo todo, @SessionAttribute String logonId) {
		logger.info("Todo`s {}, {}", todo.toString(), logonId);
		boolean result = todoService.updateDone(todo, logonId);
		if(result) {
			return "redirect:/todos";
		}else {
			return "error";
		}
	}
}
