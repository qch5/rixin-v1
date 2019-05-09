package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-05-01 14:52
 */
@Controller
@RequestMapping("/sysUserBalance")
public class SysUserBalanceController extends JsonController {

    @RequestMapping("")
    public String index() {
        return "/sysUserBalance/index";
    }

    @RequestMapping("charge")
    public String charge() {
        return "/sysUserBalance/charge";
    }
}
