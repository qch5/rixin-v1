package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-05-04 10:15
 */
@Controller
@RequestMapping("/sysOrderComplain")
public class SysOrderComplainController extends JsonController {

    @RequestMapping("")
    public String index() {
        return "/sysOrderComplain/index";
    }
}
