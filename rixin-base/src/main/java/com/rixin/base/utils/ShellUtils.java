package com.rixin.base.utils;

import com.rixin.base.model.ShellResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: dairan
 * Date: 2017 - 03 - 24 10:27
 */
public abstract class ShellUtils {
	protected static final Logger logger = LoggerFactory.getLogger(ShellUtils.class);
	
	/**
	 * 校验Shell执行结果
	 */
	public static boolean isSuccessResult(ShellResult result) {
		if(result == null || result.getCode() != 0) {
			return false;
		}
		return true;
	}
}
