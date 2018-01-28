package com.niu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class IndexController extends AbstractController{

	private Logger logger=Logger.getLogger(IndexController.class);
	@Override
	@RequestMapping("/index")
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("hello,SpringMvc");
		logger.info("hello,SpringMvc");
		return new ModelAndView("index");
	}
	@RequestMapping("/welcome")
	public String welcome(@RequestParam String username){
		logger.info("welcome,"+username);
		return "index";
		
	}

}
