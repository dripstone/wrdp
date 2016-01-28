package org.zhiyan.core.data;

import java.util.List;
import java.util.Map;

import javax.sql.RowSetWriter;

public abstract interface IDataStore {
	public abstract String getStoreName();

	public abstract void setStoreName(String paramString);

	public abstract Map<?, ?> getAttributes();

	public abstract void addAttribute(String paramString1, String paramString2, String paramString3);

	public abstract void removeAttribute(String paramString);

	public abstract void setAttributes(Map<?, ?> paramMap);

	public abstract String getCondition();

	public abstract void setCondition(String paramString);

	public abstract Object getPropertyValue(String paramString);

	public abstract void addProperty(String paramString, Object paramObject);

	public abstract Map<?, ?> getParameters();

	public abstract void addParameter(String paramString, Object paramObject);

	public abstract void removeParameter(String paramString);

	public abstract void setParameters(Map<?, ?> paramMap);

	public abstract IMetaData getMetaData();

	public abstract void setMetaData(IMetaData paramIMetaData);

	public abstract String getOrder();

	public abstract void setOrder(String paramString);

	public abstract int getPageNo();

	public abstract void setPageNo(int paramInt);

	public abstract int getPageSize();

	public abstract void setPageSize(int paramInt);

	public abstract List<?> getConditionValues();

	public abstract void setConditionValues(List<?> paramList);

	public abstract void insertConditionObj(int paramInt, Object paramObject);

	public abstract void insertConditionValue(int paramInt, String paramString1, String paramString2);

	public abstract String getPool();

	public abstract void setPool(String paramString);

	public abstract int getRecordCount();

	public abstract void setRecordCount(int paramInt);

	public abstract List<?> getRowDatasWithStatus();

	public abstract List<?> getRowDatas();

	/** @deprecated */
	@Deprecated
	public abstract void addRowData(Map paramMap);

	/** @deprecated */
	@Deprecated
	public abstract List<?> getDeleteDatas();

	/** @deprecated */
	@Deprecated
	public abstract void addDeleteData(Map<?, ?> paramMap);

	public abstract List<?> getFilterDatasWithStatus();

	/** @deprecated */
	@Deprecated
	public abstract void addFilterData(Map paramMap);

	public abstract String getRowSetName();

	public abstract void setRowSetName(String paramString);

	public abstract String getStatementName();

	public abstract void setStatementName(String paramString);

	public abstract Map getStatistics();

	public abstract void addStatistics(String paramString, Map paramMap);

	public abstract void addStatistics(String paramString1, String paramString2);

	public abstract boolean isDistinct();

	public abstract void setDistinct(boolean paramBoolean);

	public abstract void setRowSetWriter(RowSetWriter paramRowSetWriter);

	public abstract Object clone();

	/** @deprecated */
	@Deprecated
	public abstract void clearRowSet();

	/** @deprecated */
	@Deprecated
	public abstract void deleteRow(int paramInt, String paramString);

	public abstract IRowSet getRowSet();
}