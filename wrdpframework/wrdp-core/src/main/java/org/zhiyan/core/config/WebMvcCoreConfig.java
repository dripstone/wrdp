/**
 * 
 */
package org.zhiyan.core.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
public class WebMvcCoreConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
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
        url.setPrefix("/");
        url.setSuffix(".jsp");
        return url;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
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
        messageSource.setUseCodeAsDefaultMessage(true);
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加拦截器");
    }

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        System.out.println("添加消息转换器");
        // WiselyMessageConverter converter = new WiselyMessageConverter();
        // converters.add(converter);
    }
}