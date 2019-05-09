package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 15:07
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping("/recharge")
    public String recharge() {
        return "/payment/recharge";
    }

    @RequestMapping("/pay")
    public String pay() {
        return "/payment/pay";
    }
}
