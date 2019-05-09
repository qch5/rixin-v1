package com.rixin.plat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-04 22:08
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @RequestMapping("")
    public String index() {
        return "/order/step1";
    }
}
