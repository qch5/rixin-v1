package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:30
 */
@Controller
@RequestMapping("/help")
public class HelpController {

    @RequestMapping("")
    public String index() {
        return "/help/index";
    }

    @RequestMapping("agreement")
    public String agreement() {
        return "/help/agreement";
    }
}
