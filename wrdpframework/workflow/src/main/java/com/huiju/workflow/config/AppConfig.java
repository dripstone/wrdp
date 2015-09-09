/**
 * 
 */
package com.huiju.workflow.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

/**
 * @Title:应用配置类
 * @Description:负责注册除Controller等web层以外的所有bean，包括aop代理，service层，dao层，缓存，等等
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Configuration
@ComponentScan(basePackages = {
        "com.huiju" }, useDefaultFilters = true, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
                Controller.class }) )
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
