package spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import spring.data.LoginDto;
import spring.data.UserDto;
import spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserService service;

	@RequestMapping("/main/user/loginform.do")
	public ModelAndView loginform() {
		ModelAndView model = new ModelAndView();

		model.setViewName("/main/user/loginform");
		return model;
	}
	
	@RequestMapping("/user/logout.do")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userLoginInfo");
		
		return "main.tiles";
	}

	@RequestMapping("/main/user/loginAction.do")
	public String loginAction(@RequestParam String email, @RequestParam(name = "password") String pass,
			HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();

		String go = "main.tiles";

		if(service.userLoginCheck(email, pass)>0) {
			UserDto udto = service.userGradeCheck(email, pass);
			if(udto.getState() == 1) {
				LoginDto dto = new LoginDto();
				dto.setUser_Email(email);
				dto.setUser_Pass(pass);
				dto.setUser_grade(udto.getGrade());
				session.setAttribute("userLoginInfo", dto);
				if(udto.getGrade()==1)
					go="main.tiles";
				if(udto.getGrade()==2)
					go="redirect:/restaurant/main.do";
				if(udto.getGrade()==3)
					go="admin.tiles";
			}else if(udto.getState() == 0){
				model.addAttribute("email", email);
				go = "/main/user/userMailCheck";
			}
		}else {
			go = "redirect:/main/user/loginform.do?loginFalse=true";
		}

		return go;
	}

	@RequestMapping("/main/user/userGrade.do")
	public String userGrade() {
		return "/main/user/userGrade";
	}

	@RequestMapping("/main/user/userform.do")
	public String userform(@RequestParam int grade, Model model) {
		model.addAttribute("grade", grade);
		return "/main/user/userform";
	}

	@RequestMapping("/main/user/emailCheck.do")
	@ResponseBody
	public Map<Object, Object> emailCheck(@RequestBody String email) {

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = service.userSelectCount(email);
		map.put("cnt", count);

		return map;
	}

	@RequestMapping("/main/user/nickNameCheck.do")
	@ResponseBody
	public Map<Object, Object> nickNameCheck(@RequestBody String nickName) {

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = service.userNickCount(nickName);
		map.put("cnt", count);

		return map;
	}

	@RequestMapping("/main/user/userAction.do")
	public ModelAndView userAction(@ModelAttribute UserDto dto) {
		ModelAndView model = new ModelAndView();
		
		String go = "main.tiles";

		String fullHp = dto.getHp1() + "-" + dto.getHp2() + "-" + dto.getHp3();
		dto.setHp(fullHp);

		dto.setState(0);

		service.userInsert(dto);

		model.setViewName(go);
		return model;
	}

	@RequestMapping("/main/user/userMailCheckAction.do")
	public String usermailcheck(@RequestParam String email, Model model) {

		model.addAttribute("email", email);
	
		MimeMessage message=mailSender.createMimeMessage();
		 
		 try{ 
			 MimeMessageHelper messageHelper = new MimeMessageHelper(message, true,"UTF-8"); 
			 messageHelper.setSubject("이메일 인증");//메일 제목 
			 messageHelper.setText("<html><body><h1>아래 링크를 누르시면 인증이 완료됩니다</h1><br><a href='http://tjdrn4765.cafe24.com/main/user/userStateUpdate.do?email="+email+"'>인증</a></body></html>",true);//메일내용
			 //messageHelper.setText("<html><body><h1>아래 링크를 누르시면 인증이 완료됩니다</h1><br><a href='http://localhost:9000/YGY-Project/main/user/userStateUpdate.do?email="+email+"'>인증</a></body></html>",true);//메일 내용
			 message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(email)); mailSender.send(message);
		  }catch (Exception e) {
		  System.out.println("메일 보내기 오류:"+e.getMessage()); 
		  }
		return "/main/user/userMailCheck";
	}
	
	@RequestMapping("/main/user/userStateUpdate.do")
	public String userStateUpdate(HttpServletRequest request,@RequestParam String email) {
		String path = request.getContextPath();
		String go = "redirect: " + path + "/main.do";
		if(service.userSelectCount(email)>0) {
			service.userStateUpdate(email);	
			go = "redirect: " + path + "/main.do?gaip=true";
		}
		return go;
	}
	
	@RequestMapping("/main/user/userSearchAction.do")
	public String userSearchAction(@RequestParam String email)
	{
		MimeMessage message=mailSender.createMimeMessage();
		try{
			message.setSubject("비밀번호 찾기 결과 입니다");//메일 제목
			message.setText("1111");//메일 내용
			message.setRecipients(MimeMessage.RecipientType.TO,
					InternetAddress.parse(email));
			mailSender.send(message);
		}catch(MessagingException e){
			System.out.println("메일 보내기 오류:"+e.getMessage());
		}
		return "/main/user/userSearch";
	}
	
	@RequestMapping("/main/user/userSearch.do")
	public String userSearch() {
		return "/main/user/userSearch";
	}
	

}
