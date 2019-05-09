package com.rixin.plat.web.controller;

import com.rixin.base.controller.JsonController;
import com.rixin.base.model.JsonResult;
//import com.rixin.data.domain.MenuFunc;
//import com.rixin.data.service.MenuFuncService;
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
 * Date: 2017 - 06 - 22 19:07
 */
//@Controller
//@RequestMapping("/menu")
public class MenuFuncController extends JsonController {
	private static final Logger logger = LoggerFactory.getLogger(MenuFuncController.class);
	
	/*@Resource
	private MenuFuncService menuFuncService;
	
	@RequestMapping("")
	public String index(String clickId, ModelMap result) {
		result.addAttribute("clickId", clickId);
		return "/menu/index";
	}
	
	*//**
	 * 查询菜单 - 列表
	 *//*
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public JsonResult list() {
		try {
			json = menuFuncService.queryMenu();
			ret = RET_OK;
			message = "查询成功";
		} catch (Exception e) {
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	*//**
	 * 查询菜单 - 详情
	 *//*
	@ResponseBody
	@RequestMapping(value = "info", method = RequestMethod.POST)
	public JsonResult info(Integer id) {
		try {
			json = menuFuncService.queryMenuById(id);
			ret = RET_OK;
			message = "查询成功";
		} catch (Exception e) {
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	*//**
	 * 查询菜单功能 - 列表
	 *//*
	@ResponseBody
	@RequestMapping(value = "funcList", method = RequestMethod.POST)
	public JsonResult funcList(Integer id) {
		try {
			json = menuFuncService.queryFuncByMenu(id);
			ret = RET_OK;
			message = "查询成功";
		} catch (Exception e) {
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	*//**
	 * 菜单功能 - 添加
	 *//*
	@RequestMapping(value = "create", method= RequestMethod.GET)
	public String create() {
		return "/menu/edit";
	}
	
	*//**
	 * 菜单功能 - 添加
	 *//*
	@ResponseBody
	@RequestMapping(value = "create", method= RequestMethod.POST)
	public JsonResult create(@RequestBody MenuFunc instance) {
		try {
			Integer maxSort = menuFuncService.queryMaxSort(0);
			instance.setSort(maxSort);
			instance.setLevel(1);
			instance.setpId(0);
			instance.setIsMenu(1);
			instance.setIsParent(0);
			menuFuncService.insert(instance);
			ret = RET_OK;
			message = "菜单功能添加成功";
		} catch (Exception e) {
			logger.error("菜单功能添加失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	*//**
	 * 菜单功能 - 修改
	 *//*
	@RequestMapping(value = "/update", method= RequestMethod.GET)
	public String update(Integer id, ModelMap result) {
		MenuFunc instance = menuFuncService.queryMenuById(id);
		result.addAttribute("info", instance);
		return "/menu/edit";
	}
	
	*//**
	 * 菜单功能 - 修改
	 *//*
	@ResponseBody
	@RequestMapping(value = "/update", method= RequestMethod.POST)
	public JsonResult update(@RequestBody MenuFunc instance) {
		try {
			menuFuncService.update(instance);
			ret = RET_OK;
			message = "菜单功能修改成功";
		} catch (Exception e) {
			logger.error("菜单功能修改失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	*//**
	 * 子菜单 - 添加
	 *//*
	@RequestMapping(value = "createChildren", method= RequestMethod.GET)
	public String createChildren(Integer id, ModelMap result) {
		result.addAttribute("pId", id);
		return "/menu/edit";
	}
	
	*//**
	 * 子菜单 - 添加
	 *//*
	@ResponseBody
	@RequestMapping(value = "createChildren", method= RequestMethod.POST)
	public JsonResult createChildren(@RequestBody MenuFunc instance) {
		try {
			MenuFunc parent = menuFuncService.queryMenuById(instance.getpId());
			Integer maxSort = menuFuncService.queryMaxSort(instance.getpId());
			instance.setSort(maxSort);
			instance.setLevel(parent.getLevel() + 1);
			instance.setpId(instance.getpId());
			instance.setIsMenu(1);
			instance.setIsParent(0);
			menuFuncService.insert(instance);
			ret = RET_OK;
			message = "子菜单菜单添加成功";
		} catch (Exception e) {
			logger.error("子菜单添加失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	*//**
	 * 功能 - 添加
	 *//*
	@RequestMapping(value = "createFunc", method= RequestMethod.GET)
	public String createFunc(Integer id, ModelMap result) {
		result.addAttribute("pId", id);
		return "/menu/editFunc";
	}
	
	*//**
	 * 功能 - 添加
	 *//*
	@ResponseBody
	@RequestMapping(value = "createFunc", method= RequestMethod.POST)
	public JsonResult createFunc(@RequestBody MenuFunc instance) {
		try {
			MenuFunc parent = menuFuncService.queryMenuById(instance.getpId());
			Integer maxSort = menuFuncService.queryMaxSort(instance.getpId());
			instance.setSort(maxSort);
			instance.setLevel(parent.getLevel() + 1);
			instance.setpId(instance.getpId());
			instance.setIsMenu(0);
			instance.setIsParent(0);
			menuFuncService.insert(instance);
			ret = RET_OK;
			message = "功能添加成功";
		} catch (Exception e) {
			logger.error("功能添加失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	*//**
	 * 功能 - 修改
	 *//*
	@RequestMapping(value = "updateFunc", method= RequestMethod.GET)
	public String updateFunc(Integer id, ModelMap result) {
		MenuFunc instance = menuFuncService.queryMenuById(id);
		result.addAttribute("info", instance);
		return "/menu/editFunc";
	}
	
	*//**
	 * 功能 - 修改
	 *//*
	@ResponseBody
	@RequestMapping(value = "updateFunc", method= RequestMethod.POST)
	public JsonResult updateFunc(@RequestBody MenuFunc instance) {
		try {
			MenuFunc info = menuFuncService.queryMenuById(instance.getId());
			info.setName(instance.getName());
			info.setUrl(instance.getUrl());
			info.setDesc(instance.getDesc());
			menuFuncService.update(info);
			ret = RET_OK;
			message = "功能修改成功";
		} catch (Exception e) {
			logger.error("功能修改失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	*//**
	 * 菜单功能 - 移动
	 *//*
	@ResponseBody
	@RequestMapping(value = "/move", method= RequestMethod.POST)
	public JsonResult moveMenu(Integer srcId, Integer destId, String type) {
		try {
			MenuFunc srcMenu = menuFuncService.queryMenuById(srcId);
			MenuFunc destMenu = menuFuncService.queryMenuById(destId);
			Integer sort = destMenu.getSort();
			Integer level = destMenu.getLevel();
			if(type.equals("inner")) {
				Integer maxSort = menuFuncService.queryMaxSort(destId);
				srcMenu.setpId(destId);
				srcMenu.setLevel(level + 1);
				srcMenu.setSort(maxSort);
			} else if(type.equals("prev")) {
				menuFuncService.updateSort(level, sort);
				srcMenu.setpId(destMenu.getpId());
				srcMenu.setLevel(level);
				srcMenu.setSort(sort);
			} else {
				menuFuncService.updateSort(level, sort + 1);
				srcMenu.setpId(destMenu.getpId());
				srcMenu.setLevel(level);
				srcMenu.setSort(sort + 1);
			}
			if(srcMenu.getpId() == 0) {
				srcMenu.setPath(String.format("%02d.", srcMenu.getId()));
			} else {
				MenuFunc parent = menuFuncService.queryMenuById(srcMenu.getpId());
				srcMenu.setPath(parent.getPath() + String.format("%02d.", srcMenu.getId()));
			}
			menuFuncService.update(srcMenu);
			ret = RET_OK;
			message = "菜单功能移动成功";
		} catch (Exception e) {
			logger.error("菜单功能移动失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message, json);
	}
	
	*//**
	 * 菜单功能 - 删除
	 *//*
	@ResponseBody
	@RequestMapping(value = "delete", method= RequestMethod.POST)
	public JsonResult delete(Integer id) {
		try {
			menuFuncService.deleteSelfAndChildren(id);
			ret = RET_OK;
			message = "菜单功能删除成功";
		} catch (Exception e) {
			logger.error("菜单功能删除失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}
	
	*//**
	 * 菜单功能 - 删除
	 *//*
	@ResponseBody
	@RequestMapping(value = "deleteFunc", method= RequestMethod.POST)
	public JsonResult deleteFunc(Integer id) {
		try {
			menuFuncService.delete(id);
			ret = RET_OK;
			message = "功能删除成功";
		} catch (Exception e) {
			logger.error("功能删除失败，{}", e);
			ret = RET_ERROR;
			message = e.getMessage();
		}
		return new JsonResult(ret, message);
	}*/
}
