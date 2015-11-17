package org.zhiyan.user.config;

import org.zhiyan.core.config.AbstractApplicationInitializer;

public class UserInitializer extends AbstractApplicationInitializer {

    private String appName = "user1";

    @Override
    protected String getAppName() {
        return this.appName;
    }

    @Override
    protected Class<?>[] createServletConfigClasses() {
        return new Class<?>[] { UserWebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        String mappingUrl = "/";
        logger.info("加载[" + this.getAppName() + "]的映射路径:".concat(mappingUrl));
        return new String[] { mappingUrl };
    }

}
