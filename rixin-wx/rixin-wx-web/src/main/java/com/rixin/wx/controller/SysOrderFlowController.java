package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-05-04 09:50
 */
@Controller
@RequestMapping("/sysOrderFlow")
public class SysOrderFlowController extends JsonController {

    @RequestMapping("")
    public String index() {
        return "/sysOrderFlow/index";
    }

    @RequestMapping("/flow")
    public String flow() {
        return "/sysOrderFlow/flow";
    }
}
