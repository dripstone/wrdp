/**
 * 
 */
package org.zhiyan.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Title:核心配置类
 * @Description:将公共资源注册到根上下文中
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Configuration
@ComponentScan(basePackages = "org.zhiyan.core", useDefaultFilters = false, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
                Controller.class }) })
public class CoreServiceConfig {
}
