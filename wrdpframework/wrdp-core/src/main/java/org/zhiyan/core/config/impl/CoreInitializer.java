/**
 * 
 */
package org.zhiyan.core.config.impl;

import java.util.ArrayList;
import java.util.List;

import org.zhiyan.core.config.AbstractApplicationInitializer;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年8月12日
 * @Version:1.1.0
 */
public class CoreInitializer extends AbstractApplicationInitializer {
    // 存储根上下文配置文件
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
    final protected Class<?>[] getRootConfigClasses() {
        Class<?>[] cls = new Class<?>[rootConfigClassesList.size()];
        for (int i = 0; i < rootConfigClassesList.size(); i++) {
            cls[i] = rootConfigClassesList.get(i);
        }
        return cls;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return null;
    }
}
