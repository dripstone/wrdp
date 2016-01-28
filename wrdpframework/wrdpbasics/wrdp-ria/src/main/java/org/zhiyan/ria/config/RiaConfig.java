package org.zhiyan.ria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.zhiyan.core.stereotype.RootConfiguration;

@Configuration
@ComponentScan(basePackages = "org.zhiyan.ria", useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { RootConfiguration.class }) })
public class RiaConfig {

}
