package com.rixin.base.utils;

import com.rixin.base.config.Constants;
import org.springframework.util.DigestUtils;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * User: dairan
 * Date: 2016 - 12 - 01 15:06
 */
public class MD5Utils {
	
	public static String md5Hex(String str) {
		if(isBlank(str)) {
			return "";
		}
		return DigestUtils.md5DigestAsHex(str.getBytes(Constants.CHARSET));
	}
	
	public static String md5Hex(long num) {
		return MD5Utils.md5Hex(String.valueOf(num));
	}
}
