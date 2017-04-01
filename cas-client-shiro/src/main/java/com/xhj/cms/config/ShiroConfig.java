package com.xhj.cms.config;

import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by projack
 */
@Configuration
public class ShiroConfig {

//    private static String casUrl = "https://xxx.xhj.com:8443/cas";
    private static String casUrl = "https://zhanqi.net/cas";

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean sb = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        sb.setSecurityManager(securityManager);
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/shiro-cas", "casFilter");
        filterChainDefinitionMap.put("/protected/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        sb.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
        sb.setLoginUrl(casUrl + "/login?service=http://xxx.xhj.com:88/shiro-cas");

        // 登录成功后要跳转的链接
        sb.setSuccessUrl("/protected/success");

        //未授权界面;
        sb.setUnauthorizedUrl("/403");

        CasFilter filter = new CasFilter();

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("casFilter", filter);
        sb.setFilters(filterMap);

        return sb;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        CasRealm casRealm = new CasRealm() {
            @Override
            protected TicketValidator createTicketValidator() {
                return new Cas30ServiceTicketValidator(getCasServerUrlPrefix());
            }
        };
        casRealm.setCasServerUrlPrefix(casUrl);
        casRealm.setCasService("http://xxx.xhj.com:88/shiro-cas");
        securityManager.setRealm(casRealm);
        return securityManager;
    }

}
