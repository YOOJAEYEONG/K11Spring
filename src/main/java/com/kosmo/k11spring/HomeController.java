package com.kosmo.k11spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 어노테이션으로 찾아서 요청명에따라 메소드를 호출하므로 아래 메소드명home은 자유롭게 바꿀수있다.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//스프링에서는 application, page, request, session 
		//영역외에 model영역이 하나더 있다.
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	
	
	
	
	//반드시 /로 시작하는 요청명을 매핑해야한다. 
	@RequestMapping("/home/helloSpring")
	public String helloSpring(Model model) {
		
		String firstMessage = "My First Spring MVC 컨트롤러";
		model.addAttribute("firstMessage", firstMessage);
		
		return "HelloSpring";
	}
}
























