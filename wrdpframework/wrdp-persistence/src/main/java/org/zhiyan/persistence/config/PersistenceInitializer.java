package org.zhiyan.persistence.config;

import org.zhiyan.core.config.AbstractApplicationInitializer;

public class PersistenceInitializer extends AbstractApplicationInitializer {

    private String appName = "persistence";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return null;
    }

}
