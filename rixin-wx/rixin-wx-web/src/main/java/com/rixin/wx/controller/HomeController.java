package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2019-03-09 14:58
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String index(HttpServletRequest request, ModelMap map) {
        map.put("userInfo", request.getSession().getAttribute("userInfo"));
        return "/home/index";
    }

    @RequestMapping("detail")
    public String detail() {
        return "/home/detail";
    }
}
