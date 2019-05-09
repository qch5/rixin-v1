package com.rixin.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * User: dairan
 * Date: 2017 - 01 - 04 16:24
 */
public class ResultUtils {
	private static final Logger logger = LoggerFactory.getLogger(ResultUtils.class);
	
	public static boolean isSuccessResult(Map<String, Object> result) {
		return result != null && result.get("resStatus").equals("200");
	}
}
