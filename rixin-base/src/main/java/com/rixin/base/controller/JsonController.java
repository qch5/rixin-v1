package com.rixin.base.controller;

/**
 * User: dairan
 * Date: 2016-09-23 16:36
 */
public abstract class JsonController extends BaseController {
	public static final int RET_OK = 0;
	public static final int RET_ERROR = 1;
	protected int ret = RET_ERROR;
	protected Object json;

}