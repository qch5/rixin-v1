package com.rixin.base.utils;

import org.springframework.context.ApplicationContext;

/**
 * User: dairan
 * Date: 2016-08-30 15:33
 */
public class BeanUtils {

    private static ApplicationContext context;

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static void setContext(ApplicationContext context) {
        BeanUtils.context = context;
    }
}
