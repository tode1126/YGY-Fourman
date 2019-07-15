package spring.controller.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
import spring.data.restaurant.RestaurantDto;
import spring.data.restaurant.RestaurantMenuDto;
import spring.service.restaurant.RestaurantService;


@Controller
public class RestaurantController {
	@Autowired
	private RestaurantService service;
	
	@RequestMapping("/restaurant/main.do")
	public String mainGo()
	{
		return "/restaurant/main/frontPage";
	}
	
	@RequestMapping("/restaurant/signupForm.do")
	public String frontPage()
	{
		return "/restaurant/signup/signupForm";
	}
	
	@RequestMapping(value="/restaurant/signup.do", method=RequestMethod.POST)
	public String write(@ModelAttribute RestaurantDto dto) {
		service.insertRestaurant(dto);
		//목록으로 이동
		return "redirect:/restaurant/main.do";
	}
	
	@RequestMapping("/restaurant/chooseAccount.do")
	public ModelAndView chooseAccount(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<RestaurantDto> list = null;
		HttpSession session = request.getSession();
		boolean isLoginDto = (session.getAttribute("userLoginInfo")!=null) ? true : false;
		System.out.println(isLoginDto);
		if(isLoginDto) {
			LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
			String email = ldto.getUser_Email();
			System.out.println(email);
			list = service.selectRestaurantListByEmail(email);
			model.addObject("list", list);
			model.setViewName("/restaurant/main/chooseRestaurant");
		} else
			model.setViewName("redirect:/main.do");
		return model;
	}
	
	@RequestMapping("/restaurant/restaurantMain.do")
	public String chooseRestaurant(
			@RequestParam(value="select", defaultValue="-1") int rest_pk, 
			HttpServletRequest request) {
		String go="";
		if(rest_pk == -1) {
			go = "redirect:/main.do";
		} else {
			HttpSession session = request.getSession();
			boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
			if(isRest_pk)
				session.removeAttribute("rest_pk");
			session.setAttribute("rest_pk", rest_pk);
			go = "/restaurant/main/restaurantMain";
		}
		return go;
	}
	
	@RequestMapping("/restaurant/menuFront.do")
	public ModelAndView menuFront(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<RestaurantMenuDto> list = null;
		HttpSession session = request.getSession();
		boolean isLoginDto = (session.getAttribute("userLoginInfo")!=null) ? true : false;
		System.out.println(isLoginDto);
		if(isLoginDto) {
			LoginDto ldto = (LoginDto) session.getAttribute("userLoginInfo");
			//String email = ldto.getUser_Email();
			//int restaurant_rest_pk = service.selectRestPkByEmail(email);
			int restaurant_rest_pk = -1;
			boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
			if(isRest_pk)
				restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println(restaurant_rest_pk);
			//테스트 위해 테스트값 주기 - 실제때 수정
			//model.addObject("restaurant_rest_pk", 4);
			if(service.selectCountRestaurantMenu(restaurant_rest_pk)>0)
				list = service.selectRestaurantMenu(restaurant_rest_pk);
			model.addObject("list", list);
		}
		model.setViewName("/restaurant/menu/menuList");
		return model;
	}
	
	@RequestMapping("/restaurant/menuAddForm.do")
	public ModelAndView menuAddForm(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		if(isRest_pk) {
			int restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("menuAddForm.do: "+restaurant_rest_pk);
			//테스트 위해 테스트값 주기 - 실제때 수정
			//model.addObject("restaurant_rest_pk", 4);
			model.addObject("restaurant_rest_pk", restaurant_rest_pk);
		}
		model.setViewName("/restaurant/menu/menu-insert-form");
		return model;
	}
	
	@RequestMapping(value="/restaurant/menuAdd.do", method=RequestMethod.POST)
	public String menuAdd(@ModelAttribute RestaurantMenuDto rmdto)
	{
		service.insertRestaurantMenu(rmdto);
		return "/restaurant/menu/menu-insert-form";
	}
}
