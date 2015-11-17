/**
 * 
 */
package org.zhiyan.web1.config;

import org.zhiyan.core.config.AbstractApplicationInitializer;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
public class Web1Initializer extends AbstractApplicationInitializer {

    private final String appName = "web1";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return new Class<?>[] { WebMvcWeb1Config.class };
    }

}
