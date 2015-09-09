/**
 * 
 */
package org.zhiyan.console.config;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Title:springMVC配置类
 * @Description:mvc层只负责扫描@Controller
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.zhiyan.console", useDefaultFilters = false, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
                Controller.class }) })
public class ConsoleWebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = Logger
            .getLogger(ConsoleWebMvcConfig.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("login/form").setViewName("login");
        registry.addViewController("welcome").setViewName("welcome");
        registry.addViewController("admin").setViewName("admin");
        registry.addViewController("user").setViewName("user");
        registry.addViewController("console").setViewName("console");
        registry.addViewController("queryuser").setViewName("queryuser");
        registry.addViewController("orgmanage").setViewName("orgmanage");
        registry.addViewController("menumanage").setViewName("menumanage");
        registry.addViewController("rolemanage").setViewName("rolemanage");
        if (logger.isDebugEnabled()) {
            logger.debug("addViewControllers");
        }
    }

    /**
     * 注册视图处理器
     * 
     * @return
     * @Description:
     */
    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver url = new InternalResourceViewResolver();
        url.setPrefix("/WEB-INF/jsp/");
        url.setSuffix(".jsp");
        if (logger.isDebugEnabled()) {
            logger.debug("prefix:".concat("/WEB-INF/jsp/"));
            logger.debug("suffix:".concat(".jsp"));
        }
        return url;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        if (logger.isDebugEnabled()) {
            logger.debug("ResourceHandler:".concat("/resources/**"));
            logger.debug("ResourceLocations:".concat("/resources/"));
        }
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 注册消息资源处理器
     * 
     * @return
     * @Description:
     */
    @Bean(name = "messageSource")
    public MessageSource configureMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.put("org.springframework.dao.DataAccessException", "error");
        b.setExceptionMappings(mappings);
        return b;
    }

}