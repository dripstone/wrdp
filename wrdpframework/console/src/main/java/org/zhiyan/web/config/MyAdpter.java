package org.zhiyan.web.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyAdpter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加拦截器");
    }

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        System.out.println("添加消息转换器");
        WiselyMessageConverter converter = new WiselyMessageConverter();
        converters.add(converter);
    }
}
