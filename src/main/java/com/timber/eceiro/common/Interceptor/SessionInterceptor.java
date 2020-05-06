package com.timber.eceiro.common.Interceptor;

import com.timber.eceiro.common.config.UrlConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class SessionInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //登录不做拦截
        if(request.getRequestURI().equals("/gtgx/login") || request.getRequestURI().equals("/gtgx/login")||
        request.getRequestURI().startsWith("/gaoxin_app/api/v1"))
        {
            return true;
        }
        Cookie[] cookies = request.getCookies();
        String sessionID = "";
        if (cookies != null && cookies.length > 0) {
            for(int i=0;i<cookies.length;i++){
                if("gtgx_session".equals(cookies[i].getName())) {
                    sessionID = cookies[i].getValue();
                }
            }
        }
        if (sessionID == null || "".equals(sessionID)){
            if(UrlConfig.PROFILES_ACTIVE.equals("sale")){
                response.sendRedirect("http://appgt.ove-ipark.com/gtgx/login");
            }else{
                response.sendRedirect("/gtgx/login");
            }

            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}


