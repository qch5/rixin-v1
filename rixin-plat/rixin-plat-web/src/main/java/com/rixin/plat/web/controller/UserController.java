package com.rixin.plat.web.controller;

import com.google.common.collect.Lists;
import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
import com.rixin.base.utils.MD5Utils;
/*import com.rixin.data.domain.Role;
import com.rixin.data.domain.User;
import com.rixin.data.domain.UserRole;
import com.rixin.data.service.RoleService;
import com.rixin.data.service.UserRoleService;
import com.rixin.data.service.UserService;*/
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

/**
 * User: dairan
 * Date: 2017 - 08 - 01 09:40
 */
//@Controller
//@RequestMapping("/user")
public class UserController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
//	@Resource
//	private UserService userService;
//	@Resource
//	private RoleService roleService;
//	@Resource
//	private UserRoleService userRoleService;
	
	/*@RequestMapping("")
	public String index() {
		return "/user/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method= RequestMethod.POST)
	public JsonResult list(User instance) {
		try {
			json = userService.queryList(instance);
			ret = RET_OK;
			message = "查询用户成功";
		} catch (Exception e) {
			logger.error("查询用户失败，{}", e);
			json = null;
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "info", method= RequestMethod.GET)
	public String info(String username, ModelMap map) {
		map.put("info", userService.queryByUsername(username));
		return "/user/edit";
	}
	
	@RequestMapping(value = "create", method= RequestMethod.GET)
	public String create() {
		return "/user/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "create", method= RequestMethod.POST)
	public JsonResult create(@RequestBody Map<String, Object> params) {
		try {
			String username = (String) params.get("username");
			String realname = (String) params.get("realname");
			String mobile = (String) params.get("mobile");
			String password = (String) params.get("password");
			String rePassword = (String) params.get("rePassword");
			Integer sex = Integer.parseInt((String) params.get("sex"));
			if(!password.equals(rePassword)) {
				throw new Exception("两次密码输入不一致");
			}
			User instance = new User();
			instance.setUsername(username);
			instance.setRealname(realname);
			instance.setMobile(mobile);
			instance.setPassword(MD5Utils.md5Hex(password));
			instance.setSex(sex);
			json = userService.insert(instance);
			ret = RET_OK;
			message = "添加用户成功";
		} catch (Exception e) {
			logger.error("添加用户失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "update", method= RequestMethod.GET)
	public String update(String username, ModelMap map) {
		map.put("info", userService.queryByUsername(username));
		return "/user/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method= RequestMethod.POST)
	public JsonResult update(@RequestBody Map<String, Object> params) {
		try {
			String username = (String) params.get("username");
			String realname = (String) params.get("realname");
			String mobile = (String) params.get("mobile");
			String password = (String) params.get("password");
			String rePassword = (String) params.get("rePassword");
			Integer sex = Integer.parseInt((String) params.get("sex"));
			if(!password.equals(rePassword)) {
				throw new Exception("两次密码输入不一致");
			}
			User instance = userService.queryByUsername(username);
			instance.setUsername(username);
			instance.setRealname(realname);
			instance.setMobile(mobile);
			instance.setPassword(MD5Utils.md5Hex(password));
			instance.setSex(sex);
			json = userService.update(instance);
			ret = RET_OK;
			message = "修改用户成功";
		} catch (Exception e) {
			logger.error("修改用户失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	@RequestMapping(value = "role", method= RequestMethod.GET)
	public String role(String username, ModelMap map) {
		map.put("username", username);
		map.put("userRole", roleService.getRoleByUsername(username));
		map.put("roleList", roleService.queryList(new Role()));
		return "/user/edit_role";
	}
	
	@ResponseBody
	@RequestMapping(value = "role", method= RequestMethod.POST)
	public JsonResult role(@RequestBody Map<String, String> params) {
		try {
			String username = params.get("username");
			String roles = params.get("roles");
			List<UserRole> list = Lists.newArrayList();
			for(String roleId : roles.split("\\,")) {
				UserRole instance = new UserRole();
				instance.setUsername(username);
				instance.setRoleId(Integer.parseInt(roleId));
				list.add(instance);
			}
			userRoleService.create(username, list);
			ret = RET_OK;
			message = "修改用户成功";
		} catch (Exception e) {
			logger.error("修改用户失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method= RequestMethod.POST)
	public JsonResult delete(String username) {
		try {
			userService.delete(username);
			ret = RET_OK;
			message = "删除用户成功";
		} catch (Exception e) {
			logger.error("删除用户失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}*/
}
