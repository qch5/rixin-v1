package com.rixin.base.config;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: dairan
 * Date: 2016-09-23 16:41
 */
public class SystemConfig {
    private static final Logger logger = LoggerFactory.getLogger(SystemConfig.class);
    private static String DEFAULT_CONFIG_FILE = "authen.properties";
    
    private static String logoutAddress = null;         // 登出链接
    private static String domain = null;                // 项目域名

    protected static CombinedConfiguration config;
    static {
        config = new CombinedConfiguration();
        try {
            PropertiesConfiguration plain = new PropertiesConfiguration(DEFAULT_CONFIG_FILE);
            plain.setReloadingStrategy(new FileChangedReloadingStrategy());
            logger.info(String.format("{%s}配置文件加载成功", DEFAULT_CONFIG_FILE));
            config.append(plain);
        } catch (ConfigurationException e) {
            logger.error(String.format("配置文件{%s}加载失败!", DEFAULT_CONFIG_FILE),e);
        }
    }
    
    public static String getLogoutUrl(){
        if(logoutAddress == null)
            logoutAddress = config.getString("logout.address");
        return logoutAddress;
    }
    
    public static String getDomain() {
        if(domain == null)
            domain = config.getString("webapp.domain.name");
        return domain;
    }
}
