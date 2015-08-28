/**
 * 
 */
package org.zhiyan.web.config;

import javax.servlet.Filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.zhiyan.core.config.AppConfig;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
public class SpringWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Log logger = LogFactory
            .getLog(SpringWebAppInitializer.class);

    /**
     * 应用上下文，除web部分
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // RequestMappingHandlerAdapter s;
        logger.info("加载应用上下文配置除web部分");
        return new Class<?>[] { AppConfig.class };
    }

    /**
     * web上下文
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("加载web上下文");
        return new Class<?>[] { WebMvcConfig.class };
    }

    /**
     * DispatcherServlet的映射路径
     */
    @Override
    protected String[] getServletMappings() {
        logger.info("加载DispatcherServlet的映射路径'/'");
        return new String[] { "/" };
    }

    /**
     * 注册过滤器，映射路径与DispatcherServlet一致，
     * 路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
     */

    @Override
    protected Filter[] getServletFilters() {
        logger.info("加载consolefilter");
        return null;
    }

}
