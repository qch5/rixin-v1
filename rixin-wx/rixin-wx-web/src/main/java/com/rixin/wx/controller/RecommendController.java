package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:39
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController {

    @RequestMapping("")
    public String index() {
        return "/recommend/index";
    }
}
