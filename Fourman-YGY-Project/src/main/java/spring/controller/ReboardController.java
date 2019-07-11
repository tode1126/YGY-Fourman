package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.service.ReboardService;


@Controller
public class ReboardController {
	
	@Autowired
	private ReboardService service;
	
	@RequestMapping("/reboard/reboardlist.do")
	public ModelAndView reboardList()
	{	
		ModelAndView model=new ModelAndView();
		
		int totalCount;
		totalCount=service.getTotalCount();
		model.addObject("totalCount",totalCount);
		
		model.setViewName("/main/reboard/reboardlist");
		return model;
	}
}
