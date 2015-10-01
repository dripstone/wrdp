package org.zhiyan.persistence.config;

import javax.servlet.ServletContext;

import org.zhiyan.core.config.BeforeApplicationInitializer;
import org.zhiyan.core.config.CoreInitializer;

public class PersistenceBeforeApplicationInitializer
        extends BeforeApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        CoreInitializer.rootConfigClassesList.add(PersistenceConfig.class);
    }

}
