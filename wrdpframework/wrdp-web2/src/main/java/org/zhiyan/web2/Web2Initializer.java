/**
 * 
 */
package org.zhiyan.web2;

import org.zhiyan.core.config.AbstractApplicationInitializer;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
public class Web2Initializer extends AbstractApplicationInitializer {

    private final String appName = "web2";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return null;
    }

}
