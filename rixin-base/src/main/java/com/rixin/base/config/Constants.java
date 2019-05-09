package com.rixin.base.config;

import com.google.common.collect.Sets;
import com.rixin.base.utils.ConfigUtils;
import org.apache.commons.lang.StringUtils;

import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Set;

/**
 * User: dairan
 * Date: 2016-09-23 16:40
 */
public class Constants {
    protected static Properties PROPS = ConfigUtils.getPropertiesFile("resources.properties");

    public static final String CHARSET_NAME = "UTF-8";
    public static final Charset CHARSET = Charset.forName(CHARSET_NAME);
    
    public static final String HR_CODE = (String) PROPS.get("hr.user.app.code");
    public static final String HR_KEY = (String) PROPS.get("hr.user.safe.key");
    
    public static final String FILE_FS_BASE = (String) PROPS.get("file.fs.base");
    public static final String FILE_FS_SERVER = (String) PROPS.get("file.fs.server");
    public static final String STORAGE_TOP_DIR = "/bpmn";
    public static final String STORAGE_SECOND_DIR = "";
    
    public static final String PROCESS_KEY = (String) PROPS.get("process.key");											// 统一代办流程Key
    public static final Set<String> PROCESS_OA = Sets.newHashSet();														// 支持统一代办的流程
    static {
        String process_oa = (String) PROPS.get("process.oa");
        if(StringUtils.isNotBlank(process_oa)) {
            for(String process : process_oa.split(",")) {
                PROCESS_OA.add(process);
            }
        }
    }
    public static final Set<String> PROCESS_ADMIN = Sets.newHashSet();													// 超级管理员集合
    static {
        String process_admin = (String) PROPS.get("process.admin");
        if(StringUtils.isNotBlank(process_admin)) {
            for(String process : process_admin.split(",")) {
                PROCESS_ADMIN.add(process);
            }
        }
    }
}
