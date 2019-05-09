package com.rixin.plat.web.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.Integer;
import java.lang.String;
import java.lang.Double;
import java.util.Date;
//import com.rixin.data.domain.FeeDept;
//import com.rixin.data.dao.mapper.FeeDeptMapper;
//import com.rixin.data.service.FeeDeptService;

import javax.annotation.Resource;

/**
 * 部门费用表
 * User: dairan
 * Date: 2017-09-27 14:53:43
 */
//@Controller
//@RequestMapping("/feeDept")
public class FeeDeptController extends JsonController {
    private static final Logger logger = LoggerFactory.getLogger(FeeDeptController.class);

//    @Resource
//    private FeeDeptService feeDeptService;

    @RequestMapping("")
    public String index() {
        return "/feeDept/index";
    }

    /**
    * 查询 - 列表
    *//*
    @ResponseBody
    @RequestMapping(value = "/list", method= RequestMethod.POST)
    public JsonResult list(FeeDept instance) {
        try {
            json = feeDeptService.queryList(instance);
            ret = RET_OK;
            message = "查询列表信息成功";
        } catch (Exception e) {
            logger.error("查询列表信息失败，{}", e);
            json = null;
            ret = RET_ERROR;
            message = e.getMessage();
        }
        return new JsonResult(ret, message, json);
    }

    *//**
    * 查询 - 详情
    *//*
    @RequestMapping(value = "info", method= RequestMethod.GET)
    public String info(Integer id, ModelMap map) {
        map.put("info", feeDeptService.queryById(id));
        return "/feeDept/edit";
    }

    *//**
    * 添加 - 记录
    *//*
    @RequestMapping(value = "create", method= RequestMethod.GET)
    public String create() {
        return "/feeDept/edit";
    }

    *//**
    * 添加 - 记录
    *//*
    @ResponseBody
    @RequestMapping(value = "create", method= RequestMethod.POST)
    public JsonResult create(@RequestBody FeeDept instance) {
        try {
            json = feeDeptService.create(instance);
            ret = RET_OK;
            message = "添加记录成功";
        } catch (Exception e) {
            logger.error("添加记录失败，{}", e);
            json = null;
            ret = RET_ERROR;
            message = e.getMessage();
        }
        return new JsonResult(ret, message, json);
    }

    *//**
    * 修改 - 记录
    *//*
    @RequestMapping(value = "update", method= RequestMethod.GET)
    public String update(Integer id, ModelMap map) {
        map.put("info", feeDeptService.queryById(id));
        return "/feeDept/edit";
    }

    *//**
    * 修改 - 记录
    *//*
    @ResponseBody
    @RequestMapping(value = "update", method= RequestMethod.POST)
    public JsonResult update(@RequestBody FeeDept instance) {
        try {
            json = feeDeptService.updateById(instance);
            ret = RET_OK;
            message = "更新记录成功";
        } catch (Exception e) {
            logger.error("更新记录失败，{}", e);
            json = null;
            ret = RET_ERROR;
            message = e.getMessage();
        }
        return new JsonResult(ret, message, json);
    }

    *//**
    * 删除 - 记录
    *//*
    @ResponseBody
    @RequestMapping(value = "delete", method= RequestMethod.POST)
    public JsonResult delete(Integer id) {
        try {
            feeDeptService.deleteById(id);
            ret = RET_OK;
            message = "删除记录成功";
        } catch (Exception e) {
            logger.error("删除记录失败，{}", e);
            ret = RET_ERROR;
            message = e.getMessage();
        }
        return new JsonResult(ret, message);
    }*/
}