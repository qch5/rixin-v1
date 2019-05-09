package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-04-13 18:49
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @RequestMapping("")
    public String index() {
        return "/address/index";
    }

    @RequestMapping("add")
    public String add() {
        return "/address/edit";
    }
}
