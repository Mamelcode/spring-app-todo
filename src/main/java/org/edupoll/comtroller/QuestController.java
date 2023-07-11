package org.edupoll.comtroller;

import org.edupoll.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/quest")
public class QuestController {

	@Autowired
	QuestService questService;
	
	@GetMapping("/join")
	public String questJoinHandle(@SessionAttribute String logonId, Integer id) {
		
		questService.joinQuest(logonId, id);
		
		return "redirect:/todos";
	}
}
