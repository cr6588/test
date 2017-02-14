package com.cheny.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Component
public class LanguageIntercepter extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger(LanguageIntercepter.class);

    @Autowired
    private SessionLocaleResolver localeResolver;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        //如果是刚点进来，session为空，则读取cookie
//        Object locale = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
//        if(locale == null){
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null){
//                for(int i=0;i<cookies.length;i++){
//                    if("logistics_locale".equals(cookies[i].getName())){
//                        Locale l = new Locale(cookies[i].getValue());
//                        localeResolver.setLocale(request, response, l);
//                        response.sendRedirect("/");
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//        }
        return flag;
    }
}
