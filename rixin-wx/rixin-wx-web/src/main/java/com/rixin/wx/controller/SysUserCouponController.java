package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-05-01 15:01
 */
@Controller
@RequestMapping("/sysUserCoupon")
public class SysUserCouponController extends JsonController {

    @RequestMapping("")
    public String index() {
        return "/sysUserCoupon/index";
    }
}
