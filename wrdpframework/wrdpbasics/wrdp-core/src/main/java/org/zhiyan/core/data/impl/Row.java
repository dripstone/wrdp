package org.zhiyan.core.data.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zhiyan.core.data.IRow;

import net.sf.json.JSONObject;

public class Row implements IRow {
	private int index = -1;
	private JSONObject rowObj = new JSONObject();

	public Row() {
	}

	public Row(Map rowValueMap) {
		if (rowValueMap == null) {
			rowValueMap = new HashMap();
		}
		this.rowObj.putAll(rowValueMap);
	}

	public Row(JSONObject obj, int index) {
		this.rowObj = obj;
		this.index = index;
	}

	public JSONObject getRowObj() {
		return this.rowObj;
	}

	@Override
	public boolean isNewModify() {
		return checkStatus(1);
	}

	@Override
	public boolean isModify() {
		return checkStatus(3);
	}

	private boolean checkStatus(int compared) {
		if (!this.rowObj.containsKey("_t")) {
			return false;
		}
		int status = Integer.parseInt(this.rowObj.get("_t").toString());
		if (status == compared) {
			return true;
		}
		return false;
	}

	@Override
	public int getRowStatus() {
		if (!this.rowObj.containsKey("_t")) {
			return 2;
		}
		int status = Integer.parseInt(this.rowObj.get("_t").toString());
		return status;
	}

	@Override
	public boolean isSeleted() {
		if (!this.rowObj.containsKey("_s")) {
			return false;
		}
		boolean isSelected = this.rowObj.getBoolean("_s");
		return isSelected;
	}

	@Override
	public boolean isModify(String colName) {
		if (!isModify()) {
			return false;
		}
		JSONObject obj = (JSONObject) this.rowObj.get("_o");
		if (!obj.containsKey(colName)) {
			return false;
		}
		return true;
	}

	@Override
	public Object getItemValue(String name) {
		if (!this.rowObj.containsKey(name)) {
			return null;
		}
		return this.rowObj.get(name);
	}

	@Override
	public void setItemValue(String name, Object value) {
		this.rowObj.put(name, value);
	}

	@Override
	public Object getOrigValue(String colName) {
		if (!isModify()) {
			return null;
		}
		JSONObject obj = (JSONObject) this.rowObj.get("_o");
		if (!obj.containsKey(colName)) {
			return null;
		}
		return obj.get(colName);
	}

	@Override
	public void setSelected(boolean isSelected) {
		this.rowObj.put("_s", Boolean.valueOf(isSelected));
	}

	@Override
	public int getRowIndex() {
		return this.index;
	}

	@Override
	public void setRowStatus(int status) {
		this.rowObj.put("_t", new Integer(status));
	}

	@Override
	public void resetUpdate() {
		if (this.rowObj.containsKey("_t")) {
			String key = "_t";
			this.rowObj.remove(key);
		}
		if (this.rowObj.containsKey("_s")) {
			String key = "_s";
			this.rowObj.remove(key);
		}
		if (this.rowObj.containsKey("_o")) {
			String key = "_o";
			this.rowObj.remove(key);
		}
	}

	@Override
	public boolean getBoolean(String colName) {
		return this.rowObj.getBoolean(colName);
	}

	@Override
	public Date getDate(String colName) {
		return new Date(getLong(colName));
	}

	@Override
	public double getDouble(String colName) {
		return this.rowObj.getDouble(colName);
	}

	@Override
	public float getFloat(String colName) {
		return 1;// Float.parseFloat(getDouble(colName));
	}

	@Override
	public int getInt(String colName) {
		return this.rowObj.getInt(colName);
	}

	@Override
	public String getString(String colName) {
		return this.rowObj.getString(colName);
	}

	@Override
	public long getLong(String colName) {
		return this.rowObj.getLong(colName);
	}

	@Override
	public void setBoolean(String colName, boolean value) {
		setItemValue(colName, Boolean.valueOf(value));
	}

	@Override
	public void setDate(String colName, Date value) {
		setItemValue(colName, new Long(value.getTime()));
	}

	@Override
	public void setDouble(String colName, double value) {
		setItemValue(colName, new Double(value));
	}

	@Override
	public void setFloat(String colName, float value) {
		setItemValue(colName, new Float(value));
	}

	@Override
	public void setInt(String colName, int value) {
		setItemValue(colName, new Integer(value));
	}

	@Override
	public void setString(String colName, String value) {
		setItemValue(colName, value);
	}

	@Override
	public void setLong(String colName, long value) {
		setItemValue(colName, new Long(value));
	}
}