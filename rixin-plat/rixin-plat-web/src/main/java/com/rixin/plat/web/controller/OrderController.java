package com.rixin.plat.web.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
//import com.rixin.data.domain.Order;
//import com.rixin.data.service.CustomerService;
//import com.rixin.data.service.DetailService;
//import com.rixin.data.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:25
 */
//@Controller
//@RequestMapping("/order")
public class OrderController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	/*@Resource
	private OrderService orderService;
	@Resource
	private DetailService detailService;
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("")
	public String index() {
		return "/order/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method= RequestMethod.POST)
	public JsonResult list(Order instance) {
		try {
			json = orderService.queryList(instance);
			ret = RET_OK;
			message = "查询成功";
		} catch (Exception e) {
			logger.error("查询失败，{}", e);
			json = null;
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "info", method= RequestMethod.GET)
	public String info(Integer id, ModelMap map) {
		map.put("info", orderService.queryById(id));
		return "/order/edit";
	}
	
	@RequestMapping(value = "create", method= RequestMethod.GET)
	public String create() {
		return "/order/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "create", method= RequestMethod.POST)
	public JsonResult create(@RequestBody Map<String, Object> params) {
		try {
			orderService.create(params);
			ret = RET_OK;
			message = "添加成功";
		} catch (Exception e) {
			logger.error("添加失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	@RequestMapping(value = "update", method= RequestMethod.GET)
	public String update(Integer id, ModelMap map) {
		map.put("info", orderService.queryById(id));
		map.put("list", detailService.queryListByOrderId(id));
		return "/order/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method= RequestMethod.POST)
	public JsonResult update(@RequestBody Map<String, Object> params) {
		try {
			orderService.update(params);
			ret = RET_OK;
			message = "操作成功";
		} catch (Exception e) {
			logger.error("操作失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method= RequestMethod.POST)
	public JsonResult delete(Integer id) {
		try {
			orderService.delete(id);
			ret = RET_OK;
			message = "删订单信息成功";
		} catch (Exception e) {
			logger.error("删除订单信息失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}*/
}
