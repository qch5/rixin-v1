package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:26
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @RequestMapping("")
    public String index() {
        return "/about/index";
    }

    @RequestMapping("us")
    public String us() {
        return "/about/us";
    }
}
