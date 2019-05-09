package com.rixin.plat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2017 - 07 - 23 13:53
 */
@Controller
@RequestMapping("")
public class IndexController {
	
	@RequestMapping("")
	public String index(ModelMap result) {
		return "index";
	}
}
