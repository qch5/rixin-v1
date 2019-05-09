package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 13:56
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "index";
    }
}
