package com.rixin.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: dairan
 * Date: 2016-03-23 09:16
 */
public class ConfigUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);

    /**
     * 读取Properties配置文件
     */
    public static Properties getPropertiesFile(String confPath) {
        InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream(confPath);
        Properties prop = new Properties();
        try {
            prop.load(is);
            is.close();
            logger.debug("load config file success ,filePath is "+confPath);
        } catch (IOException ex) {
            logger.error("读取配置文件失败，配置文件路径为："+confPath, ex);
        }
        return prop;

    }
}
