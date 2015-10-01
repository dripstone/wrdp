package org.zhiyan.ria.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityMetadataCache {
	protected static final HashMap<String, List<EntityMetadata>> map = new HashMap<String, List<EntityMetadata>>();

	public static final void put(String entityName, EntityMetadata entityMetadata) {
		List<EntityMetadata> list = map.get(entityName);
		if (list == null) {
			list = new ArrayList<EntityMetadata>();
			map.put(entityName, list);
		}
		list.add(entityMetadata);
	}

	public static List<EntityMetadata> get(String entityName) {
		return map.get(entityName);
	}
}
