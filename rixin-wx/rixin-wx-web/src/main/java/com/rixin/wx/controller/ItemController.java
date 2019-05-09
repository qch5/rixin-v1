package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:58
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("")
    public String index() {
        return "/item/index";
    }
}
