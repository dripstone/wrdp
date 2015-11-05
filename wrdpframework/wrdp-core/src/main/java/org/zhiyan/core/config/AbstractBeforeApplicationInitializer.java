package org.zhiyan.core.config;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

/**
 * @Title:系统配置初始化前执行
 * @Description:
 * @Author:zzy
 * @Since:2015年9月29日
 * @Version:1.1.0
 */
@Order(10)
public abstract class AbstractBeforeApplicationInitializer
        implements WebApplicationInitializer {

    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public abstract void onStartup(ServletContext servletContext);

}