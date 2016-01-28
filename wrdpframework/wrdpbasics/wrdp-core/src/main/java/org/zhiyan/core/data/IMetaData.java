package org.zhiyan.core.data;

import java.util.List;
import java.util.Map;

public abstract interface IMetaData {
	public abstract void addColumn(String paramString, Map paramMap);

	public abstract void addColumn(MetaDataColumn paramMetaDataColumn);

	public abstract List getColumns();

	public abstract MetaDataColumn getColumn(String paramString);

	public abstract Object getPropertyValue(String paramString);

	public abstract void addProperty(String paramString, Object paramObject);
}