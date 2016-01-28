package org.zhiyan.core.config;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

@Order(10)
public abstract class RootContextInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		DispatcherServletInitializer.rootConfigClasses.addAll(Arrays.asList(getRootConfigClasses()));
	}

	protected abstract Class<?>[] getRootConfigClasses();
}