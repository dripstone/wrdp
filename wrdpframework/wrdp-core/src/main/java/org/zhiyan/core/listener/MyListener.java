package org.zhiyan.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("1");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("2");
    }

}
