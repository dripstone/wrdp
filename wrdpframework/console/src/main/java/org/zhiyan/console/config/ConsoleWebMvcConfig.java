/**
 * 
 */
package org.zhiyan.console.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
public class ConsoleWebMvcConfig extends WebMvcConfigurerAdapter {}