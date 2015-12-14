package com.cheny.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheny.web.util.RequestSessionUtil;

@Controller
@RequestMapping("/sec")
public class SecAction {

    @RequestMapping(value = "/{pageName}")
    public ModelAndView viewSecPages(HttpServletRequest request, @PathVariable("pageName") String pageName) throws Exception {
        return new ModelAndView("/sec/" + pageName, RequestSessionUtil.getRequestParamData(request));
    }
}
