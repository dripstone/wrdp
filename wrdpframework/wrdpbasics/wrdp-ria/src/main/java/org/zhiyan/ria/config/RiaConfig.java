package org.zhiyan.ria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.zhiyan.core.stereotype.BO;
import org.zhiyan.core.stereotype.DAO;

@Configuration
@ComponentScan(basePackages = "org.zhiyan.ria", useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { BO.class, DAO.class }) })
public class RiaConfig {

}
