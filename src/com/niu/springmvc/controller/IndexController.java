package com.niu.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.niu.springmvc.pojo.User;

@Controller
public class IndexController extends AbstractController {

	private Logger logger = Logger.getLogger(IndexController.class);

	@Override
	@RequestMapping(value = "/index")
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("hello,SpringMvc");
		logger.info("hello,SpringMvc");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/welcome")
	public String welcome(
			@RequestParam(value = "username", required = false) String username) {
		logger.info("welcome," + username);
		return "index";

	}

	// 使用ModelAndView进行参数的传递

	@RequestMapping("index1")
	public ModelAndView index(String username) {
		logger.info("welcome，" + username);
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", username);
		mav.setViewName("index");
		return mav;
	}

	// 使用Model进行参数的传递
	@RequestMapping("index2")
	public String index(String username, Model model) {
		logger.info("welcome，" + username);
		model.addAttribute("username", username);
		return "index";
	}

	// 使用Model进行参数的传递
	@RequestMapping("index3")
	public String index1(String username, Model model) {
		logger.info("welcome，" + username);
		model.addAttribute("username", username);
		model.addAttribute(username);
		return "index";
	}

	// 使用Model进行对象参数的传递
	@RequestMapping("index4")
	public String index2(String username, Model model) {
		logger.info("welcome，" + username);
		model.addAttribute("username", username);
		model.addAttribute(username);
		User user = new User();
		user.setUserName(username);
		model.addAttribute("currentUser", user);
		model.addAttribute(user);
		return "index";
	}
	@RequestMapping("index5")
	public String index3(String username, Map<String,String> model) {
		logger.info("welcome"+username);
		model.put("username", username);
		return "index";
	}
}
