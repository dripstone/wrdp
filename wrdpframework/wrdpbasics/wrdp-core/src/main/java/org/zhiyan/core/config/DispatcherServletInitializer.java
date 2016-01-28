package org.zhiyan.core.config;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(20)
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public static Set<Class<?>> rootConfigClasses = new LinkedHashSet<Class<?>>();

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return rootConfigClasses.toArray(new Class<?>[rootConfigClasses.size()]);
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
