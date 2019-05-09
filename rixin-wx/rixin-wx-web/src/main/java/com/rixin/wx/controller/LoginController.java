package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 14:47
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("")
    public String index() {
        return "login";
    }
}
