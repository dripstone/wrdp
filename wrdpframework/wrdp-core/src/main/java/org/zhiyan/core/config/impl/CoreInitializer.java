/**
 * 
 */
package org.zhiyan.core.config.impl;

import org.zhiyan.core.config.AbstractApplicationInitializer;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
public class CoreInitializer extends AbstractApplicationInitializer {

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
