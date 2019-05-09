package com.rixin.base.utils;

import com.rixin.base.exception.WOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * User: dairan
 * Date: 2017 - 03 - 09 11:39
 */
public final class JopApiDigest {
	private static final Logger logger = LoggerFactory.getLogger(JopApiDigest.class);
	
	private MessageDigest digest;
	
	private JopApiDigest() throws WOException {
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch(NoSuchAlgorithmException ex) {
			throw new WOException("Init MessageDigest Error:" + ex.getMessage());
		}
	}
	
	public static JopApiDigest getInstance() throws WOException {
		return new JopApiDigest();
	}
	
	/**
	 * MD5加密
	 */
	public String encryptByMD5(String data) {
		if (null == data || "".equals(data)) {
			return "";
		}
		char[] chars = data.toCharArray();
		byte[] bytes = new byte[chars.length];
		for (int i = 0; i < chars.length; i++) {
			bytes[i] = (byte) chars[i];
		}
		byte[] md5Bytes = digest.digest(bytes);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (16 > val) {
				result.append("0");
			}
			result.append(Integer.toHexString(val));
		}
		return result.toString();
	}
	
	/**
	 * 生成一个签名
	 */
	public String generate(String appKey, String token, String timestamp, String random) {
		String[] arrTmp = {appKey, token, timestamp, random};
		Arrays.sort(arrTmp);
		StringBuilder sb = new StringBuilder();
		for (String str : arrTmp) {
			sb.append(str);
		}
		return encryptByMD5(sb.toString());
	}
	
	/**
	 * 验证参数签名
	 */
	public boolean validate(String signature, String appKey, String token, String timestamp, String random) {
		boolean flag = false;
		String expectedSignature = generate(appKey, token, timestamp, random);
		if (expectedSignature.equals(signature)) {
			flag = true;
		}
		return flag;
	}
}
