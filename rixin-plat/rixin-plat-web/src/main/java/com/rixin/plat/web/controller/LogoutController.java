package com.rixin.plat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2017 - 02 - 18 17:10
 */
//@Controller
//@RequestMapping("/logout")
public class LogoutController {
	private static final Logger Logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("login");
		req.getSession().removeAttribute("isAdmin");
		req.getSession().removeAttribute("username");
		return "login";
	}
}