package org.zhiyan.ria.config;

import org.zhiyan.core.config.AbstractApplicationInitializer;

public class RiaInitializer extends AbstractApplicationInitializer {

    private String appName = "ria1";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return new Class<?>[] { RiaConfig.class, WebMvcCoreConfig.class };
    }

}
