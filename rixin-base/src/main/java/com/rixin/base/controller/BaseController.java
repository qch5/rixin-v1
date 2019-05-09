package com.rixin.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dairan
 * Date: 2016-09-23 16:45
 */
public abstract class BaseController {
	public static final String LOGIN = "login";
	public static final String REDIRECT = "redirect";
	
	private String baseUrl = null;
	protected String message = "";

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/* 二〇一七年五月三十一日 16:11:04 添加 */
	@Autowired
	private HttpServletRequest request;

	
}