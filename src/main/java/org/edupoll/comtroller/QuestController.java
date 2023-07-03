package org.edupoll.comtroller;

import java.util.List;
import java.util.UUID;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.service.QuestService;
import org.edupoll.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class QuestController {
	
	@Autowired
	QuestService questService;
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/quest/join")
	public String questJoin(int questId, @SessionAttribute String logonId
			, Model model) {
		
		Quest q = questService.findById(questId);
		List<Todo> todos = todoService.getTodos(logonId);
		if(todos == null || q == null) {
			model.addAttribute("error", "잘못된 요청 입니다.");
			return "redirect:/todos";
		}else {
			for(Todo t : todos) {
				if(t.getDescription().equals(q.getDescription())) {
					model.addAttribute("error", "이미 등록된 퀘스트 입니다.");
					return "redirect:/todos";
				}
			}
		}
		
		questService.joinQuest(questId);
		
		Todo todo = new Todo();
		todo.setDescription(q.getDescription());
		todo.setTargetDate(q.getEndDate());
		todoService.addNewTodo(todo, logonId);
		
		return "redirect:/todos";
	}
	
	
}
