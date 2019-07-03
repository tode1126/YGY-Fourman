package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/user/loginform.do")
	public ModelAndView loginform() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("/user/loginform");
		return model;
	}
	
	
}
