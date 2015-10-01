package org.zhiyan.ria.cache;

import java.io.Serializable;

public class EntityMetadata implements Serializable {
	private static final long serialVersionUID = -8165088805169263863L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;
}
