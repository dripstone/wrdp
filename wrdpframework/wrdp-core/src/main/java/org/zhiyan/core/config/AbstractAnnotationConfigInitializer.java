package org.zhiyan.core.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.zhiyan.core.exception.CoreException;

/**
 * @Title: 核心配置抽象类
 * @Description:
 * @Author:zzy
 * @Since:2015年9月25日
 * @Version:1.1.0
 */
public abstract class AbstractAnnotationConfigInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Log logger = LogFactory.getLog(getClass());

    // 存储appName
    private static Set<String> appNameSet = new HashSet<String>();
    // 存储根上下文配置文件
    public static List<Class<?>> rootConfigClassesList = new ArrayList<Class<?>>();

    /**
     * 获取APP名称
     * 
     * @return
     * @Description:
     */
    protected abstract String getAppName();

    @Override
    protected final String getServletName() {
        if (this.getAppName() == null || "".equals(getAppName()))
            throw new CoreException("appName不能为空");
        if (appNameSet.contains(this.getAppName()))
            throw new CoreException("存在相同的appName:" + this.getAppName());
        appNameSet.add(this.getAppName());
        return this.getAppName();
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

    /**
     * 子上下文配置类加载
     */
    @Override
    protected final Class<?>[] getServletConfigClasses() {
        if (this.createServletConfigClasses() != null) {
            Class<?>[] cls = new Class<?>[this
                    .createServletConfigClasses().length + 1];
            for (int i = 0; i < this.createServletConfigClasses().length; i++) {
                cls[i] = this.createServletConfigClasses()[i];
            }
            cls[this.createServletConfigClasses().length] = WebMvcCoreConfig.class;
            return cls;
        } else
            return new Class<?>[] { WebMvcCoreConfig.class };
    }

    /**
     * 子上下文配置类加载
     * 
     * @return
     * @Description:
     */
    protected abstract Class<?>[] createServletConfigClasses();

    @Override
    protected String[] getServletMappings() {
        String mappingUrl = "/".concat(this.getAppName()).concat("/*");
        logger.info("加载[" + this.getAppName() + "]的映射路径:".concat(mappingUrl));
        return new String[] { mappingUrl };
    }

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new MyListener());
    }
}
