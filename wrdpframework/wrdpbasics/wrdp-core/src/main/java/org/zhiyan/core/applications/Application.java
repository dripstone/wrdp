package org.zhiyan.core.applications;

import java.io.Serializable;

public class Application implements Serializable {

	private static final long serialVersionUID = 3238999074751517477L;
	private String name;
	private Class<?>[] configClasses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?>[] getConfigClasses() {
		return configClasses;
	}

	public void setConfigClasses(Class<?>[] configClasses) {
		this.configClasses = configClasses;
	}
}
