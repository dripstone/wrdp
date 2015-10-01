package org.zhiyan.persistence.config;

import org.zhiyan.core.config.AbstractAnnotationConfigInitializer;

public class PersistenceInitializer
        extends AbstractAnnotationConfigInitializer {

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
