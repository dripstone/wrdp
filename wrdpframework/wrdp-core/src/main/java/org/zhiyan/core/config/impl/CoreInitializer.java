/**
 * 
 */
package org.zhiyan.core.config.impl;

import org.springframework.core.annotation.Order;
import org.zhiyan.core.config.AbstractAnnotationConfigInitializer;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Order(20)
public class CoreInitializer extends AbstractAnnotationConfigInitializer {

    private final String appName = "core";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return new Class<?>[] { CoreControllerConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
