package com.mashibing.uac.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Current 保存请求的request和response
 */
public class Current implements Filter {

    //存储controller里面的变量
    public static ThreadLocal controllerLocal = new ThreadLocal();

    //存储到ThreadLocal里面的内容
    public Map<String, Object> localContext;

    public static final String httpServletRequestPackage = "javax.servlet.http.HttpServletRequest";
    public static final String httpServletResponsePackage = "javax.servlet.http.HttpServletResponse";

    public Current() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");

        setLocalContext(httpServletRequestPackage, req);
        setLocalContext(httpServletResponsePackage, req);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void setLocalContext(String key, Object val) {
        if (localContext == null) {
            localContext = new HashMap<String, Object>();
        }

        localContext.put(key, val);

        controllerLocal.set(localContext);
    }

    public static Map getLocalContext() {
        if (controllerLocal == null) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            controllerLocal.set(hashMap);
            return hashMap;
        }

        return (Map<String, Object>) controllerLocal.get();
    }

    public static HttpServletRequest getRequest() {
        if (!getLocalContext().containsKey(httpServletRequestPackage)) {
            return null;
        }

        return (HttpServletRequest) getLocalContext().get(httpServletRequestPackage);
    }
}
