package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:54
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("")
    public String index() {
        return "/product/index";
    }
}
