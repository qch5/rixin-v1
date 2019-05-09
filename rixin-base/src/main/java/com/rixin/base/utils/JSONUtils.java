package com.rixin.base.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rixin.base.config.Constants;

import java.io.IOException;
import java.util.List;

/**
 * User: dairan
 * Date: 2016-03-24 15:43
 */
public class JSONUtils {
    private static final ObjectMapper om = new ObjectMapper();
    private static final String JSON_CHARSET = "UTF-8";

    static{
        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JSONUtils() {
    }


    public static String toJSON(Object obj) throws Exception {
        if ( obj == null ) {
            return null;
        }
        return new String(om.writeValueAsBytes(obj), JSON_CHARSET);
    }

    public static byte[] toJSONAsBytes(Object obj) throws Exception {
        if ( obj == null ) {
            return null;
        }
        return toJSON(obj).getBytes(Constants.CHARSET);
    }


    public static <T> T fromJson(byte[] data, Class<T> javaType) throws Exception {
        if ( data == null ) {
            return null;
        }
        return fromJson(new String(data, Constants.CHARSET), javaType);
    }


    public static <T> T fromJson(String jsonAsString, Class<T> valueType) {
        if(org.apache.commons.lang.StringUtils.isBlank(jsonAsString)) {
            return null;
        }
        try {
            return (T) om.readValue(jsonAsString, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonAsString, JavaType javaType) {
        if(org.apache.commons.lang.StringUtils.isBlank(jsonAsString)) {
            return null;
        }
        try {
            return (T) om.readValue(jsonAsString, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T> List<T> toList(String jsonAsString, Class<T> valueType) {
        if (org.apache.commons.lang.StringUtils.isBlank(jsonAsString)) {
            return null;
        }
        try {
            return (List<T>) om.readValue(jsonAsString, getCollectionType(List.class, valueType));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return om.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static void main(String[] args) throws Exception {
//        User user = new User();
//        user.setName(new String("中文".getBytes(), "GBK"));
//        System.out.println(fromJson(toJSONAsBytes(user), User.class).getName());

    }
}
