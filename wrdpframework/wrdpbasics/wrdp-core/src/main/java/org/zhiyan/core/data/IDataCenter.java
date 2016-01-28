package org.zhiyan.core.data;

import java.util.List;
import java.util.Map;

public abstract interface IDataCenter {
	public abstract void setCode(long paramLong);

	public abstract long getCode();

	public abstract void setTitle(String paramString);

	public abstract String getTitle();

	public abstract void setDetail(String paramString);

	public abstract String getDetail();

	public abstract void addParameter(String paramString, Object paramObject);

	public abstract void removeParameter(String paramString);

	public abstract Map<?, ?> getParameters();

	public abstract Object getParameter(String paramString);

	public abstract void addHeaderAttribute(String paramString1, String paramString2);

	public abstract Map<?, ?> getHeaderAttributes();

	public abstract void addDataStore(IDataStore paramIDataStore);

	public abstract List<?> getDataStores();

	public abstract IDataStore getDataStore(String paramString);

	@Override
	public abstract String toString();

	public abstract Object clone();
}