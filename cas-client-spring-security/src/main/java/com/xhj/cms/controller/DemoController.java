package com.xhj.cms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/protected")
public class DemoController {


    @RequestMapping(value = "/demo")
    @ResponseBody
    public String demo() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        auth.getPrincipal();

        Object obj = SecurityUtils.getSubject().getPrincipal();
        PrincipalCollection ps = SecurityUtils.getSubject().getPrincipals();
        Map as = (Map) ps.asList().get(1);
        return obj + "（" + as.get("name") + "）" + "已登录";
    }

}
