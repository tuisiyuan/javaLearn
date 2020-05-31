package com.mashibing.uac.filter;

import com.mashibing.uac.MyException.BusinessException;
import com.mashibing.uac.enums.CommonConstant;
import com.mashibing.uac.utils.ParseDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(value = "adminFilter", urlPatterns = "/admin")
public class AdminFilter implements Filter {

    @Autowired
    RedisTemplate redisTemplate;

    private static String[] notNeedLogin = {"/admin/login", "/css", "/js", "/images", "/fonts", "/layui"};

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //不需要登录
        if (!isNeedLogin(httpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String sessionId = httpServletRequest.getSession().getId();

        //需要登录 判断有没有登录
        Object accountId = redisTemplate.opsForValue().get(ParseDataUtils.sessionIdToCacheKey(sessionId));
        if (accountId == null) {
            httpServletResponse.sendRedirect("/admin/login/index");
            return;
        }
    }

    private boolean isNeedLogin(HttpServletRequest httpServletRequest) {
        for (String curUri : notNeedLogin) {
            if (httpServletRequest.getRequestURI().startsWith(curUri)) {
                return false;
            }
        }

        return true;
    }

    public void destroy() {

    }
}
