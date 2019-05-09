package com.rixin.wechat.utils;

import com.rixin.wechat.Const;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class UrlUtils {
    public static String encode(String str) {
        try {
            str = URLEncoder.encode(str, Const.Charset.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
