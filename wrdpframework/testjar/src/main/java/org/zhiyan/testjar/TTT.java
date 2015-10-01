package org.zhiyan.testjar;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(Aa.class)
public class TTT implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses,
            ServletContext servletContext) throws ServletException {
        System.out.println("呵呵呵呵呵呵");
    }

}
