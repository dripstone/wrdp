package org.zhiyan.core.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.zhiyan.core.applications.Application;
import org.zhiyan.core.listener.AppLoaderListener;

@Order(30)
public abstract class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new AppLoaderListener(getApplication()));
	}

	protected abstract Application getApplication();
}
