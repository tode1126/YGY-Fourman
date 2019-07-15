package spring.controller.restaurant;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.data.LoginDto;
import spring.data.restaurant.RestaurantDto;
import spring.data.restaurant.RestaurantMenuDto;
import spring.service.restaurant.RestaurantService;
import upload.util.SpringFileWriter;


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
	
	/*** 메뉴 관련 컨트롤러*/
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
	public String menuAdd(
			@ModelAttribute RestaurantMenuDto rmdto, 
			HttpServletRequest request)
	{
		//일단 파일명이 어떻게 넣어오는지부터 확인-입력안했을시: 빈 문자열이 들어간다
		for (MultipartFile f : rmdto.getUpfile()) {
			System.out.println("파일명: " + f.getOriginalFilename());
		}
		
		// 식당 고유값 가져오기
		HttpSession session = request.getSession();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		int restaurant_rest_pk= -1;
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("menuAddForm.do: "+restaurant_rest_pk);
		}
		
		//String Path="/home/hosting_users/tjdrn4765/tomcat/webapps/ROOT/save/restaurant/menu/"+restaurant_rest_pk
		String path = request.getSession().getServletContext().getRealPath("/save/restaurant/menu/"+restaurant_rest_pk);
		//이미지 업로드 경로 확인하기
		//식당 메뉴 업로드 경로 : /save/restaurant/menu/[식당고유값]/(이미지)
		File Folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
	        } catch(Exception e) {
	        	e.getStackTrace();
			}        
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//이미지 업로드 경로
		System.out.println(path);
		SpringFileWriter fileWriter = new SpringFileWriter();
		
		String imagename = "";
		String realname = "";
		int size=0;
		for (MultipartFile f : rmdto.getUpfile()) {
			//빈문자열이 아닐 경우에만 저장
			if(f.getOriginalFilename().length()>0){
				imagename += f.getOriginalFilename()+",";
				String[] st = imagename.split(".");
				System.out.println(st.length+" "+imagename);
				
				int pos = imagename.lastIndexOf( "." );
				String fileExtension = imagename.substring( pos + 1 );
				fileExtension = fileExtension.substring(0, fileExtension.length()-1);
				realname = UUID.randomUUID().toString()+"."+fileExtension;
				size = (int) f.getSize();
				fileWriter.writeFile(f, path, realname);
			}
		}
		if(imagename.length()==0) {
			//System.out.println("파일 등록 안함");
			imagename = "noimage";
			rmdto.setMenu_imagefile(imagename);
			rmdto.setMenu_image_realname("");
			rmdto.setMenu_image_realpath("");
			rmdto.setMenu_image_size(0);
		} else {
			//마지막 , 제거하기
			imagename = imagename.substring(0, imagename.length()-1);
			rmdto.setMenu_imagefile(imagename);
			rmdto.setMenu_image_realname(realname);
			rmdto.setMenu_image_realpath(path);
			rmdto.setMenu_image_size(size);
		}
		
		//db에 저장
		service.insertRestaurantMenu(rmdto);
		return "redirect:/restaurant/menuFront.do";
	}
	
	/*** 테이블 관련 컨트롤러*/
	@RequestMapping(value="/restaurant/tableFront.do")
	public ModelAndView tableFront(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		boolean isRest_pk = (session.getAttribute("rest_pk")!=null) ? true : false;
		int restaurant_rest_pk = -1;
		int isRestaurantTable = -1;
		if(isRest_pk) {
			restaurant_rest_pk = (Integer) session.getAttribute("rest_pk");
			System.out.println("tableFront.do: "+restaurant_rest_pk);
			isRestaurantTable = service.selectIsRestaurantTable(restaurant_rest_pk);
			System.out.println(isRestaurantTable);
		}
		model.addObject("isRestaurantTable", isRestaurantTable);
		model.setViewName("/restaurant/table/tableFront");
		return model;
	}
}
