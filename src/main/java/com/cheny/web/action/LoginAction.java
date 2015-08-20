package com.cheny.web.action;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.cheny.web.bean.Language;



@Controller
public class LoginAction {

    @Autowired
    private SessionLocaleResolver localeResolver;

    /**
     * 更换语言
     * @param request
     * @param locale
     * @param response
     */
    @RequestMapping(value = "/language", method = RequestMethod.GET)
    @ResponseBody
    public String changeLanguage(@RequestParam("locale") String languageStr, HttpServletRequest request, HttpServletResponse response) {
        Language language = Language.create(languageStr);
        Locale locale;
        switch (language) {
            case CHINESE:
                locale = new Locale(Language.CHINESE.getShortName());
                break;
            case ENGLISH:
                locale = new Locale(Language.ENGLISH.getShortName());
                break;
            default:
                locale = request.getLocale();
                break;
        }
        localeResolver.setLocale(request, response, locale);
        return null;
    }

}
