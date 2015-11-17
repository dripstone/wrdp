package org.zhiyan.persistence.config;

import javax.servlet.ServletContext;

import org.zhiyan.core.config.AbstractBeforeApplicationInitializer;
import org.zhiyan.core.config.impl.CoreInitializer;

public class PersistenceBeforeApplicationInitializer
        extends AbstractBeforeApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        CoreInitializer.rootConfigClassesList.add(PersistenceConfig.class);
    }

}
