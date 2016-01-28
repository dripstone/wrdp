package org.zhiyan.persistence.config;

import org.zhiyan.core.config.RootContextInitializer;

public class PersistenceRootContextInitializer extends RootContextInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { PersistenceConfig.class };
	}

}
