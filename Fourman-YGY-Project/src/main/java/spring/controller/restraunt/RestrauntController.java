package spring.controller.restraunt;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.data.restraunt.RestrauntDto;
import spring.data.restraunt.RestrauntMenuDto;
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
	

	@RequestMapping("/restraunt/menuFront.do")
	public String menuFront(HttpSession session)
	{
		return "/restraunt/menu/menuList";
	}
	
	@RequestMapping("/restraunt/menuAddForm.do")
	public ModelAndView menuAddForm(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		//String email = (String) session.getAttribute("userLoginInfo");
		//int restraunt_rest_pk = service.selectRestPkByEmail(email);
		//테스트 위해 테스트값 주기 - 실제때 수정
		model.addObject("restraunt_rest_pk", 4);
		//model.addObject("restraunt_rest_pk", restraunt_rest_pk);
		model.setViewName("/restraunt/menu/menu-insert-form");
		return model;
	}
	
	@RequestMapping(value="/restraunt/menuAdd.do", method=RequestMethod.POST)
	public String menuAdd(@ModelAttribute RestrauntMenuDto rmdto)
	{
		service.insertRestrauntMenu(rmdto);
		return "/restraunt/menu/menu-insert-form";
	}
}
