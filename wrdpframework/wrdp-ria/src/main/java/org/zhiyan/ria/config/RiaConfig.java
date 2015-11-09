package org.zhiyan.ria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.zhiyan.ria.typeFilter.LoadMetadata;

@Configuration
@ComponentScan(basePackages = {
        "org.zhiyan" }, useDefaultFilters = true, includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, value = {
                LoadMetadata.class }) )
public class RiaConfig {
}
