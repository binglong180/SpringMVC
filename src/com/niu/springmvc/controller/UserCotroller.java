package com.niu.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/user")
public class UserCotroller {
	private Logger logger = Logger.getLogger(UserCotroller.class);
	@RequestMapping("welcome")
	public String welcome(@RequestParam String username) {
		logger.info("welcome," + username);
		return "index";

	}
}
