package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-04 21:41
 */
@Controller
@RequestMapping("/FastOrder")
public class FastOrderController {

    @RequestMapping("")
    public String index() {
        return "/FastOrder/step1";
    }

    @RequestMapping("FlowPath")
    public String FlowPath() {
        return "/FastOrder/step2";
    }
}
