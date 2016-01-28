package org.zhiyan.core.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zhiyan.core.applications.Application;

public class AppLoaderListener extends ContextLoaderListener implements ServletContextListener {
	public static Set<Class<?>> commonConfigClasses = new LinkedHashSet<Class<?>>();

	public static List<String> appList = new ArrayList<String>();

	public static final String APP_CONTEXT_PREFIX = AppLoaderListener.class.getName() + ".CONTEXT.";

	private Application application;

	public AppLoaderListener(Application application) {
		this.application = application;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String attrName = APP_CONTEXT_PREFIX + this.application.getName();
		if (sce.getServletContext().getAttribute(attrName) != null) {
			throw new IllegalStateException("不能加载该应用【" + this.application.getName() + "】,因为该应用已存在！");
		}
		WebApplicationContext rootContext = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext());
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		Class<?>[] appClasses = this.application.getConfigClasses();
		Class<?>[] commonClasses = commonConfigClasses.toArray(new Class<?>[commonConfigClasses.size()]);
		Class<?>[] classes = Arrays.copyOf(appClasses, appClasses.length + commonClasses.length);
		System.arraycopy(commonClasses, 0, classes, appClasses.length, commonClasses.length);
		if (!ObjectUtils.isEmpty(classes)) {
			appContext.register(classes);
		}
		appContext.setServletContext(sce.getServletContext());
		appContext.setNamespace(attrName + "-space");
		if (!appContext.isActive()) {
			if (appContext.getParent() == null) {
				appContext.setParent(rootContext);
			}
			appContext.refresh();
		}
		sce.getServletContext().setAttribute(attrName, appContext);
		appList.add(this.application.getName());
	}

}