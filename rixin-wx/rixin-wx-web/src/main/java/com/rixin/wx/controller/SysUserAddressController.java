package com.rixin.wx.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
import com.rixin.data.domain.SysUserAddress;
import com.rixin.data.service.SysUserAddressService;
import com.rixin.wechat.bean.response.user.UserResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-09 15:20
 */
@Controller
@RequestMapping("/sysUserAddress")
public class SysUserAddressController extends JsonController {

    @Resource
    private SysUserAddressService sysUserAddressService;

    @RequestMapping("")
    public String index(HttpServletRequest request, ModelMap data) {
        HttpSession session = request.getSession();
        UserResponse userInfo = (UserResponse) session.getAttribute("userInfo");
        List<SysUserAddress> list = sysUserAddressService.selectByOpenId(userInfo.getOpenid());
        data.addAttribute("list", list);
        return "/sysUserAddress/index";
    }

    @RequestMapping("/create")
    public String create() {
        return "/sysUserAddress/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/create", method= RequestMethod.POST)
    public JsonResult create(HttpServletRequest request, @RequestBody SysUserAddress info) {
        HttpSession session = request.getSession();
        UserResponse userInfo = (UserResponse) session.getAttribute("userInfo");
        info.setOpenid(userInfo.getOpenid());
        info.setSex(1);
        info.setDefault(false);
        info.setCreateTime(new Date());
        sysUserAddressService.insert(info);
        return new JsonResult(RET_OK);
    }

    @RequestMapping("/update")
    public String update(Integer id, ModelMap data) {
        SysUserAddress info = sysUserAddressService.selectByPrimaryKey(id);
        data.put("info", info);
        return "/sysUserAddress/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public JsonResult update(@RequestBody SysUserAddress info) {
        sysUserAddressService.updateByPrimaryKeySelective(info);
        return new JsonResult(RET_OK);
    }
}
