package spring.controller.restraunt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
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
	public ModelAndView menuFront(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<RestrauntMenuDto> list = null;
		HttpSession session = request.getSession();
		boolean isLoginDto = (session.getAttribute("userLoginInfo")!=null) ? true : false;
		System.out.println(isLoginDto);
		if(isLoginDto) {
			LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
			String email = ldto.getUser_Email();
			int restraunt_rest_pk = service.selectRestPkByEmail(email);
			System.out.println(restraunt_rest_pk);
			//테스트 위해 테스트값 주기 - 실제때 수정
			//model.addObject("restraunt_rest_pk", 4);
			if(service.selectCountRestrauntMenu(restraunt_rest_pk)>0)
				list = service.selectRestrauntMenu(restraunt_rest_pk);
			model.addObject("list", list);
		}
		model.setViewName("/restraunt/menu/menuList");
		return model;
	}
	
	@RequestMapping("/restraunt/menuAddForm.do")
	public ModelAndView menuAddForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isLoginDto = (session.getAttribute("userLoginInfo")!=null) ? true : false;
		if(isLoginDto) {
			LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
			String email = ldto.getUser_Email();
			int restraunt_rest_pk = service.selectRestPkByEmail(email);
			//테스트 위해 테스트값 주기 - 실제때 수정
			//model.addObject("restraunt_rest_pk", 4);
			model.addObject("restraunt_rest_pk", restraunt_rest_pk);
		}
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
