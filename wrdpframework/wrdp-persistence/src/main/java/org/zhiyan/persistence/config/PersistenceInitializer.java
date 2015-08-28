package org.zhiyan.persistence.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;

public class PersistenceInitializer implements WebApplicationInitializer {
    private static Log logger = LogFactory.getLog(PersistenceInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        logger.info("加载persistence组件");
        OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
        FilterRegistration.Dynamic filterRegistration = servletContext
                .addFilter("openEntityManagerInViewFilter",
                        openEntityManagerInViewFilter);
        filterRegistration
                .addMappingForUrlPatterns(
                        EnumSet.of(DispatcherType.REQUEST,
                                DispatcherType.FORWARD, DispatcherType.INCLUDE),
                        false, "/");

    }
}
