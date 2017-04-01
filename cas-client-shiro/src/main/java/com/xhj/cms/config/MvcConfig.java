package com.xhj.cms.config;

import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.utility.XmlEscape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean(name = "freemarkerLayoutDirectives")
    public Map<String, TemplateModel> freemarkerLayoutDirectives() {

        Map<String, TemplateModel> freemarkerLayoutDirectives = new HashMap<>();
        //        freemarkerLayoutDirectives.put("extends", new ExtendsDirective());
        return freemarkerLayoutDirectives;
    }

    /**
     * 自定义一个ShiroTagFreeMarkerConfigurer继承Spring本身提供的FreeMarkerConfigurer,目的是在FreeMarker的Configuration中添加shiro的配置
     * @author projack
     */
    //    public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    //        @Override
    //        public void afterPropertiesSet() throws IOException, TemplateException {
    //            super.afterPropertiesSet();
    //            this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    //        }
    //    }

    @Bean(name = "freemarkerConfig")
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {

        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
        configurer.setDefaultEncoding("UTF-8");

        //freemarkerSettings
        Properties settings = new Properties();
        settings.setProperty("locale", "zh_CN");
        settings.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        settings.setProperty("date_format", "yyyy-MM-dd");
        settings.setProperty("time_format", "HH:mm:ss");
        settings.setProperty("number_format", "#.##");
        configurer.setFreemarkerSettings(settings);

        //freemarkerVariables
        Map<String, Object> variables = new HashMap<>();
        variables.put("xml_escape", new XmlEscape());
        configurer.setFreemarkerVariables(variables);
        return configurer;
    }

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver() {

        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".html");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.freeMarker();
    }
}