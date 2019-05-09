package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2019-05-04 20:04
 */
@Controller
@RequestMapping("/feedBack")
public class FeedBackController extends JsonController {

    @RequestMapping("")
    public String index(HttpServletRequest request, ModelMap map) {
        return "/feedBack/index";
    }
}
