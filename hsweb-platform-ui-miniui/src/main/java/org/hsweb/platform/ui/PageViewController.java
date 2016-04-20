package org.hsweb.platform.ui;

import org.hsweb.web.authorize.annotation.Authorize;
import org.hsweb.web.bean.common.QueryParam;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouhao on 16-4-8.
 */
@Controller
@Authorize
public class PageViewController {


    @RequestMapping(value = "/admin/**/*.html")
    public ModelAndView view(HttpServletRequest request) {
        String path = request.getRequestURI();
        String content = request.getContextPath();
        if (path.startsWith(content)) {
            path = path.substring(content.length() + 1);
        }
        if (path.contains("."))
            path = path.split("[.]")[0];
        ModelAndView modelAndView = new ModelAndView(path);
        return modelAndView;
    }
}
