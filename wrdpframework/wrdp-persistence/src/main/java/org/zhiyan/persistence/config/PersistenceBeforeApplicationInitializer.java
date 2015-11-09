package org.zhiyan.persistence.config;

import javax.servlet.ServletContext;

import org.zhiyan.core.config.BeforeApplicationInitializer;

public class PersistenceBeforeApplicationInitializer
        extends BeforeApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        // CoreInitializer.rootConfigClassesList.add(PersistenceConfig.class);
    }

}
