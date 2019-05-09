package com.rixin.plat.web.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
//import com.rixin.data.domain.User;
//import com.rixin.data.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2017 - 02 - 18 17:08
 */
//@Controller
//@RequestMapping("/login")
public class LoginController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/*@Resource
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.GET)
	public String showAjaxLogin() {
		return "/public/ajaxLogin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	public JsonResult ajaxLogin(HttpServletRequest req, String username, String password) {
		User userInfo = userService.login(username, password);
		if(userInfo == null) {
			return new JsonResult(RET_ERROR, "用户名或密码不正确");
		}
		if(userInfo.getStatus().intValue() == 1) {
			return new JsonResult(RET_ERROR, "该账户已被禁用");
		}
		req.getSession().setAttribute("login", true);
		req.getSession().setAttribute("username", username);
		return new JsonResult(RET_OK, "登录成功");
	}*/
}

