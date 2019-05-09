package com.rixin.base.utils;

import java.net.URLEncoder;
import java.util.Map;

/**
 * User: dairan
 * Date: 2015-12-05 13:28
 */
public class HttpUtils {
    /**
     *
     * @param parameter
     * @param encode
     * @return
     */
    public static String encodeParameter(String parameter, String encode){
        try {
            return URLEncoder.encode(parameter, encode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeParameter(Map paramMap, String encode){
        Object value = null;
        try {
            StringBuilder sb = new StringBuilder();
            for(Object o : paramMap.entrySet()){
                Map.Entry entry = (Map.Entry) o;
                value = entry.getValue();
                if(value != null && value.getClass().isArray()){
                    for(Object each : ((Object[])value)){
                        sb.append(entry.getKey());
                        sb.append('=');
                        sb.append(URLEncoder.encode(each == null ? "" : each.toString(), encode));
                        sb.append('&');
                    }
                } else {
                    sb.append(entry.getKey());
                    sb.append('=');
                    sb.append(URLEncoder.encode(value == null ? "" : value.toString(), encode));
                    sb.append('&');
                }
            }
            if(sb.length() > 0){
                return sb.substring(0, sb.length() - 1);
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(value);
            return null;
        }
    }
}
