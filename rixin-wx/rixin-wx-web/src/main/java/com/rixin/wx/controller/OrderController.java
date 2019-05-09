package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:13
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("")
    public String index() {
        return "/order/index";
    }

    @RequestMapping("create")
    public String create() {
        return "/order/edit1";
    }
}
