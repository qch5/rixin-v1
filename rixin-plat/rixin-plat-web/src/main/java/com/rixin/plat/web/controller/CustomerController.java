package com.rixin.plat.web.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
//import com.rixin.data.domain.Customer;
//import com.rixin.data.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 16:11
 */
//@Controller
//@RequestMapping("/customer")
public class CustomerController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	/*@Resource
	private CustomerService customerService;
	
	@RequestMapping("")
	public String index() {
		return "/customer/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method= RequestMethod.POST)
	public JsonResult list(Customer instance) {
		try {
			json = customerService.queryList(instance);
			ret = RET_OK;
			message = "查询客户信息成功";
		} catch (Exception e) {
			logger.error("查询客户信息失败，{}", e);
			json = null;
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "info", method= RequestMethod.GET)
	public String info(Integer id, ModelMap map) {
		map.put("info", customerService.queryById(id));
		return "/customer/edit";
	}
	
	@RequestMapping(value = "create", method= RequestMethod.GET)
	public String create() {
		return "/customer/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "create", method= RequestMethod.POST)
	public JsonResult create(@RequestBody Customer instance) {
		try {
			json = customerService.insert(instance);
			ret = RET_OK;
			message = "添加客户信息成功";
		} catch (Exception e) {
			logger.error("添加客户信息失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "update", method= RequestMethod.GET)
	public String update(Integer id, ModelMap map) {
		map.put("info", customerService.queryById(id));
		return "/customer/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method= RequestMethod.POST)
	public JsonResult update(@RequestBody Customer instance) {
		try {
			json = customerService.updateById(instance);
			ret = RET_OK;
			message = "更新客户信息成功";
		} catch (Exception e) {
			logger.error("更新客户信息失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method= RequestMethod.POST)
	public JsonResult delete(Integer id) {
		try {
			customerService.delete(id);
			ret = RET_OK;
			message = "删除客户信息成功";
		} catch (Exception e) {
			logger.error("删除客户信息失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}*/
}
