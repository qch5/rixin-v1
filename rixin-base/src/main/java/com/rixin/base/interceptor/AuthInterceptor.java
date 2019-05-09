package com.rixin.base.interceptor;

import com.rixin.base.auth.Auth;
import com.rixin.base.config.Constants;
import com.rixin.base.model.JsonResult;
import com.rixin.base.utils.JSONUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 简单权限校验 - 后期接入权限系统
 * User: dairan
 * Date: 2017 - 06 - 22 09:36
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String erp = "";
		if(Constants.PROCESS_ADMIN.contains(erp)) {																		// 验证是否为超级管理员
			return true;
		}
		if(handler instanceof HandlerMethod) {
			return true;
		}
		Auth annotation = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		if(annotation == null) {
			return true;
		}
		ResponseBody responseBody = ((HandlerMethod) handler).getMethodAnnotation(ResponseBody.class);
		if(responseBody != null) {
			return this.errHandle(response, "对不起，您没有权限");														// 唯有仅当Ajax请求才会提示没权限，其它权限公开
		}
		return true;
	}
	
	private boolean errHandle(HttpServletResponse response, String message) {
		PrintWriter writer = null;
		try {
			response.setContentType("application/json; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			writer = response.getWriter();
			writer.print(JSONUtils.toJSON(new JsonResult(1, message)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		return false;
	}
}
