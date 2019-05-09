package com.rixin.plat.web.controller;

import com.google.common.collect.Lists;
import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
/*import com.rixin.data.domain.Role;
import com.rixin.data.domain.RoleFunc;
import com.rixin.data.domain.UserRole;
import com.rixin.data.service.RoleFuncService;
import com.rixin.data.service.RoleService;*/
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: dairan
 * Date: 2017 - 08 - 01 09:56
 */
//@Controller
//@RequestMapping("/role")
public class RoleController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
//	@Resource
//	private RoleService roleService;
//	@Resource
//	private RoleFuncService roleFuncService;
	
	/*@RequestMapping("")
	public String index() {
		return "/role/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method= RequestMethod.POST)
	public JsonResult list(Role instance) {
		try {
			json = roleService.queryList(instance);
			ret = RET_OK;
			message = "查询角色成功";
		} catch (Exception e) {
			logger.error("查询角色失败，{}", e);
			json = null;
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "info", method= RequestMethod.GET)
	public String info(Integer id, ModelMap map) {
		map.put("info", roleService.queryById(id));
		return "/role/edit";
	}
	
	@RequestMapping(value = "create", method= RequestMethod.GET)
	public String create() {
		return "/role/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "create", method= RequestMethod.POST)
	public JsonResult create(@RequestBody Role instance) {
		try {
			json = roleService.insert(instance);
			ret = RET_OK;
			message = "添加角色成功";
		} catch (Exception e) {
			logger.error("添加角色失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "update", method= RequestMethod.GET)
	public String update(Integer id, ModelMap map) {
		map.put("info", roleService.queryById(id));
		return "/role/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method= RequestMethod.POST)
	public JsonResult update(@RequestBody Role instance) {
		try {
			json = roleService.update(instance);
			ret = RET_OK;
			message = "修改角色成功";
		} catch (Exception e) {
			logger.error("修改角色失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "func", method= RequestMethod.GET)
	public String func(Integer id, ModelMap result) {
		List<RoleFunc> list = roleFuncService.queryFuncByRoleId(id);
		
		List<Integer> funcList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(list)) {
			funcList = list.stream().map(RoleFunc::getFuncId).collect(Collectors.toList());
		}
		result.put("roleId", id);
		result.put("list", funcList);
		return "/role/edit_func";
	}
	
	@ResponseBody
	@RequestMapping(value = "func", method= RequestMethod.POST)
	public JsonResult func(Integer roleId, String funcIds) {
		try {
			roleFuncService.create(roleId, funcIds);
			ret = RET_OK;
			message = "修改角色权限成功";
		} catch (Exception e) {
			logger.error("修改角色权限失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method= RequestMethod.POST)
	public JsonResult delete(Integer id) {
		try {
			roleService.delete(id);
			ret = RET_OK;
			message = "删除角色成功";
		} catch (Exception e) {
			logger.error("删除角色失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}*/
}
