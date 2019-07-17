package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main.do")
	public String mainGo()
	{
		return "main.tiles";//tiles name 반환
	}
	
	@RequestMapping("/admin/admin.do")
	public String adminGo()
	{
	    LoginManager manager = new LoginManager();
		System.out.println("총 접속자 수 :"+manager.getUserCount());
		manager.printloginUsers();
	    
		return "admin.tiles";//tiles name 반환
	}
	@RequestMapping("/restraunt/restraunt.do")
	public String restrauntGo()
	{
		return "restraunt.tiles";//tiles name 반환
	}
}
