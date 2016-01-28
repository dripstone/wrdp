package org.zhiyan.core.data;

import java.util.List;
import java.util.Map;

public abstract interface IRowSet {
	public abstract List<?> getDeleteRows();

	public abstract List<?> getFilterRows();

	public abstract List<?> getRows();

	public abstract List<?> getNewModifyRows();

	public abstract List<?> getSelectedRows();

	public abstract List<?> getModifyRows();

	public abstract IRow getRow(int paramInt);

	public abstract IRow getRow(int paramInt, String paramString);

	public abstract int getRowCount(String paramString);

	public abstract int getTotalCount();

	public abstract boolean isEmpty();

	public abstract void forEach(IRowHandler paramIRowHandler, String paramString);

	public abstract boolean every(IRowHandler paramIRowHandler, String paramString);

	public abstract boolean some(IRowHandler paramIRowHandler, String paramString);

	public abstract void deleteRow(int paramInt, String paramString);

	public abstract int addDeleteData(Map<?, ?> paramMap);

	public abstract int addFilterData(Map<?, ?> paramMap);

	public abstract void clear();

	public abstract int addRowData(Map<?, ?> paramMap);

	public abstract int addRow(IRow paramIRow);

	public abstract void insertRow(int paramInt, IRow paramIRow);

	public abstract void insertRowData(int paramInt, Map<?, ?> paramMap);

	public abstract void addBatchRowData(List<?> paramList);

	public abstract void delBatchRow(int[] paramArrayOfInt);
}