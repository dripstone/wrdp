package org.zhiyan.config;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Title: 组件WebApplicationInitializer配置
 * @Description:配置系统启动时该组件需要加载的servlet，filter，listener
 * @Author:zzy
 * @Since:2015年8月28日
 * @Version:1.1.0
 */
public class SecurityInitializer
        extends AbstractSecurityWebApplicationInitializer {
    private static Log logger = LogFactory.getLog(SecurityInitializer.class);

    @Override
    public void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        logger.info("加载security组件");
    }

}