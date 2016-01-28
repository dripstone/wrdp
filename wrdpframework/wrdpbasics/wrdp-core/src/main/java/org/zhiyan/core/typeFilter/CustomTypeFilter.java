package org.zhiyan.core.typeFilter;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class CustomTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		AnnotationMetadata s = metadataReader.getAnnotationMetadata();
		if (s != null && s.getAnnotationTypes() != null) {
			String a = s.getAnnotationTypes().iterator().next();
			System.out.println(a);
		}
		return false;
	}

}
