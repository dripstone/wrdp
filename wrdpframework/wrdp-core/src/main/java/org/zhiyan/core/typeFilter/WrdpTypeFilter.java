package org.zhiyan.core.typeFilter;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class WrdpTypeFilter implements TypeFilter {
    private static Log logger = LogFactory.getLog(WrdpTypeFilter.class);

    @Override
    public boolean match(MetadataReader metadataReader,
            MetadataReaderFactory metadataReaderFactory) throws IOException {
        logger.info(
                metadataReader.getAnnotationMetadata().getClassName() + "["
                        + metadataReader.getAnnotationMetadata()
                                .getAnnotationTypes().toString()
                        + "]" + "加载成功!");
        return true;
    }
}
