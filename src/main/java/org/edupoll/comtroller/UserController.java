package org.edupoll.comtroller;

import org.edupoll.model.entity.User;
import org.edupoll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/join")
	public String gotoJoinViewHandle() {
		return "join";
	}
	
	@PostMapping("/join")
	public String joinTaskHandle(User user, Model model) {
		System.out.println("id => "+ user.getId());
		System.out.println("password => "+ user.getPassword());
		
		boolean result = userService.addNewUser(user);
		if(result) {
			return "login";			
		}else {
			model.addAttribute("error", "이미 등록된 아이디 입니다!");
			return "join";
		}
	}
	
	@GetMapping("/login")
	public String gotoLoginViewHandle() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginTaskHandle(@RequestParam String id, @RequestParam String password, HttpSession session
			, Model model) {
		System.out.println("id ==> "+ id);
		System.out.println("pass ==> "+ password);
		
		boolean result = userService.findById(id, password);
		
		if(result) {
			session.setAttribute("logonId", id);
//			return "redirect:/todos";
			System.out.println("로그인성공");
			return "redirect:/todos";
		}else {
			model.addAttribute("error", "로그인에 실패하였습니다.");
			System.out.println("로그인실패");
			return "login";
		}
	}
}
