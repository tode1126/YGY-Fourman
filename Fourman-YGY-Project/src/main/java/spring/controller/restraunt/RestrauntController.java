package spring.controller.restraunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.data.BoardDto;
import spring.data.restraunt.RestrauntDto;
import spring.service.restraunt.RestrauntService;


@Controller
public class RestrauntController {
	@Autowired
	private RestrauntService service;
	
	@RequestMapping("/restraunt/main.do")
	public String mainGo()
	{
		return "/restraunt/main/frontPage";
	}
	
	@RequestMapping("/restraunt/signupForm.do")
	public String frontPage()
	{
		return "/restraunt/signup/signupForm";
	}
	
	@RequestMapping(value="/restraunt/signup.do", method=RequestMethod.POST)
	public String write(@ModelAttribute RestrauntDto dto) {
		service.insertRestraunt(dto);
		//목록으로 이동
		return "redirect:/restraunt/main.do";
	}
}
