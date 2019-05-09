package com.rixin.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dairan
 * Date: 2019-03-09 16:38
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @RequestMapping("")
    public String index() {
        return "/comment/index";
    }
}
