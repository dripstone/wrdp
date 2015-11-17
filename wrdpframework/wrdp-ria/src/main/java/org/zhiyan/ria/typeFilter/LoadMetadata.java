package org.zhiyan.ria.typeFilter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.zhiyan.ria.cache.EntityMetadata;
import org.zhiyan.ria.cache.EntityMetadataCache;

public class LoadMetadata implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader,
            MetadataReaderFactory metadataReaderFactory) throws IOException {
        Set<String> annotationSet = metadataReader.getAnnotationMetadata()
                .getAnnotationTypes();
        if (annotationSet.contains("javax.persistence.Entity")) {
            System.out.println(
                    metadataReader.getAnnotationMetadata().getClassName());
            this.loadEntityMetadata(
                    metadataReader.getAnnotationMetadata().getClassName());
        }
        return false;
    }

    private void loadEntityMetadata(String className) {
        Class<?> cl;
        try {
            cl = Class.forName(className);
            final String entityName = cl.getName();
            ReflectionUtils.doWithFields(cl, new FieldCallback() {
                @Override
                public void doWith(Field field) throws IllegalArgumentException,
                        IllegalAccessException {
                    String fieldName = field.getName();
                    if (!"serialVersionUID".equals(fieldName)) {
                        EntityMetadata metadata = new EntityMetadata();
                        metadata.setName(
                                entityName.concat(".").concat(fieldName));
                        metadata.setType(field.getType().getName());
                        EntityMetadataCache.put(entityName, metadata);
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
