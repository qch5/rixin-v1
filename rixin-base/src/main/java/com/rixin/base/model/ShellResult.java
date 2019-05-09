package com.rixin.base.model;

/**
 * User: dairan
 * Date: 2017 - 03 - 24 09:47
 */
public class ShellResult {
	public static final int SHELL_SUCCESS_CODE = 0;
	public static final int SHELL_FAILING_CODE = 1;
	
	private int code;				// Shell执行状态 0：正常结束 1：出现异常
	private String message;			// Shell执行结果
	
	public ShellResult() {
		this.code = SHELL_FAILING_CODE;
		this.message = "执行失败";
	}
	
	public ShellResult(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
