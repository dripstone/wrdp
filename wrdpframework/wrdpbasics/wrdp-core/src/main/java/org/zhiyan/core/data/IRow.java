package org.zhiyan.core.data;

import java.util.Date;

public abstract interface IRow {
	public abstract boolean isNewModify();

	public abstract boolean isModify();

	public abstract int getRowStatus();

	public abstract boolean isSeleted();

	public abstract boolean isModify(String paramString);

	public abstract Object getItemValue(String paramString);

	public abstract void setItemValue(String paramString, Object paramObject);

	public abstract Object getOrigValue(String paramString);

	public abstract void setSelected(boolean paramBoolean);

	public abstract int getRowIndex();

	public abstract void setRowStatus(int paramInt);

	public abstract void resetUpdate();

	public abstract int getInt(String paramString);

	public abstract float getFloat(String paramString);

	public abstract double getDouble(String paramString);

	public abstract Date getDate(String paramString);

	public abstract String getString(String paramString);

	public abstract boolean getBoolean(String paramString);

	public abstract long getLong(String paramString);

	public abstract void setInt(String paramString, int paramInt);

	public abstract void setFloat(String paramString, float paramFloat);

	public abstract void setDouble(String paramString, double paramDouble);

	public abstract void setDate(String paramString, Date paramDate);

	public abstract void setString(String paramString1, String paramString2);

	public abstract void setBoolean(String paramString, boolean paramBoolean);

	public abstract void setLong(String paramString, long paramLong);
}