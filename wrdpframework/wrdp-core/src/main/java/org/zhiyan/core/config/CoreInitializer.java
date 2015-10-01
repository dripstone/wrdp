/**
 * 
 */
package org.zhiyan.core.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
@Order(20)
public class CoreInitializer extends AbstractAnnotationConfigInitializer {

    public static List<Class<?>> rootConfigClassesList = new ArrayList<Class<?>>();

    private final String appName = "core";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    /**
     * 根上下文配置类加载
     */
    @Override
    protected final Class<?>[] getRootConfigClasses() {
        Class<?>[] cls = new Class<?>[rootConfigClassesList.size()];
        for (int i = 0; i < rootConfigClassesList.size(); i++) {
            cls[i] = rootConfigClassesList.get(i);
        }
        return cls;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return new Class<?>[] { CoreControllerConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
