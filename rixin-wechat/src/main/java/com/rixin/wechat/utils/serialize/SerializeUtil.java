package com.rixin.wechat.utils.serialize;

import com.rixin.wechat.utils.serialize.jackson.JacksonSerialize;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class SerializeUtil {
    // 使用jackson实现的序列化工具.如有自定义的实现修改此处即可
    private final static SerializeDelegate delegate = new JacksonSerialize();

    /**
     * JSON字符串转Bean.
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return delegate.jsonToBean(json, clazz);
    }

    /**
     * Bean转JSON字符串.
     */
    public static String beanToJson(Object object) {
        return delegate.beanToJson(object);
    }

    /**
     * 将xml转换为对象.
     */
    public static <T> T xmlToBean(String xml, Class<T> clazz) {
        return delegate.xmlToBean(xml, clazz);
    }

    /**
     * 将对象转换为xml.
     */
    public static String beanToXml(Object object) {
        return delegate.beanToXml(object);
    }

}
