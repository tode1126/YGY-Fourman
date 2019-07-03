package spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
import spring.data.UserDto;
import spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/main/user/loginForm.do")
	public ModelAndView loginForm() {
		ModelAndView model = new ModelAndView();

		model.setViewName("/main/user/loginForm");
		return model;
	}

	@RequestMapping("/main/user/idCheck.do")
	public String loginAction(@RequestParam String email) {
		int idCk = service.userSelectCount(email);

		return "";
	}

	@RequestMapping("/main/user/loginAction.do")
	public String loginAction(@RequestParam String email, @RequestParam String pass, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto loginCk = service.userGradeCheck(email, pass);
		String path = request.getContextPath();
		String go = "redirect: " + path + "/main/main.do";
		System.out.println(pass);
		if (loginCk != null) {
			if (loginCk.getState() == 1) {
				LoginDto dto = new LoginDto();
				dto.setUser_Email(email);
				dto.setUser_Pass(pass);
				dto.setUser_grade(loginCk.getGrade());

				session.setAttribute("userLoginInfo", dto);
			} else {
				go = "/main/user/usermailcheck";
			}
		}
		return go;
	}

}
