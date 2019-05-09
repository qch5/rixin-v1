package com.rixin.base.interceptor;

import com.rixin.base.config.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: dairan
 * Date: 2016-09-23 16:46
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logoutUrl = SystemConfig.getLogoutUrl();
        request.setAttribute("logoutUrl", logoutUrl);
        if(isLogin(request)) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
    
    private boolean isLogin(HttpServletRequest request) {
        Object username = request.getSession().getAttribute("username");
        if(username == null) {
            return false;
        }
        String name = (String) username;
        request.getSession().setAttribute("username", name);
        String realname = (String) request.getSession().getAttribute("realname");
        request.setAttribute("username", name);
        request.setAttribute("realname", realname);
        return true;
    }
    
}
