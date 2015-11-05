/**
 * 
 */
package org.zhiyan.core.config;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

/**
 * @Title:系统配置初始化完成后执行
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Order(30)
public abstract class AbstractAfterApplicationInitializer
        implements WebApplicationInitializer {

    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public abstract void onStartup(ServletContext servletContext);

}
