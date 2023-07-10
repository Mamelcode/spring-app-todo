package org.edupoll.comtroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping("/")
	public String navigate(@SessionAttribute(required = false) String logonId) {
		
		logger.info("logonid = "+ logonId);
		
		if(logonId == null) {
			return "redirect:/user/login";
		}else {
			return "redirect:/todos";
		}
	}
}
