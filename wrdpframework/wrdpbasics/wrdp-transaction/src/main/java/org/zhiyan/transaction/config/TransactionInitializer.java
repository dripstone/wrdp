package org.zhiyan.transaction.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.zhiyan.core.listener.AppLoaderListener;

@Order(11)
public class TransactionInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AppLoaderListener.commonConfigClasses.add(TransactionProxy.class);
	}

}
