package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:10
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {

    @RequestMapping("")
    public String index() {
        return "/coupon/index";
    }
}
