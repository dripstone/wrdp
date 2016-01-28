package org.zhiyan.core.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhiyan.core.data.IRow;
import org.zhiyan.core.data.IRowHandler;
import org.zhiyan.core.data.IRowSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RowSet implements IRowSet {
	JSONObject rowsetObj;

	public RowSet(JSONObject rowsetObj) {
		this.rowsetObj = rowsetObj;
	}

	public List getDeleteRows() {
		return getRowsFromArray("delete");
	}

	public List getFilterRows() {
		return getRowsFromArray("filter");
	}

	public List getRows() {
		return getRowsFromArray("primary");
	}

	private List getRowsFromArray(String area) {
		JSONArray array = this.rowsetObj.getJSONArray(area);
		List list = new ArrayList();

		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = array.getJSONObject(i);
			IRow row = new Row(obj, i);
			list.add(row);
		}
		return list;
	}

	public List getNewModifyRows() {
		List list = getRows();
		List filterList = getFilterRows();
		if (filterList.size() > 0) {
			list.add(getFilterRows());
		}
		List insertList = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			Row row = (Row) list.get(i);
			if (row.isNewModify()) {
				insertList.add(row);
			}
		}
		return insertList;
	}

	public List getSelectedRows() {
		List list = getRows();
		List filterList = getFilterRows();
		if (filterList.size() > 0) {
			list.add(getFilterRows());
		}
		List selectedList = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			Row row = (Row) list.get(i);
			if (row.isSeleted()) {
				selectedList.add(row);
			}
		}
		return selectedList;
	}

	public List getModifyRows() {
		List list = getRows();
		List filterList = getFilterRows();
		if (filterList.size() > 0) {
			list.add(filterList);
		}
		List modifyList = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			Row row = (Row) list.get(i);
			if (row.isModify()) {
				modifyList.add(row);
			}
		}
		return modifyList;
	}

	public IRow getRow(int index) {
		return getRow(index, "primary");
	}

	public IRow getRow(int index, String area) {
		List list = null;
		if (area.equalsIgnoreCase("filter"))
			list = getFilterRows();
		else if (area.equalsIgnoreCase("delete"))
			list = getDeleteRows();
		else {
			list = getRows();
		}
		if (list == null) {
			return null;
		}
		IRow row = (IRow) list.get(index);
		return row;
	}

	public void forEach(IRowHandler handler, String area) {
		List list = getRowsFromArray(area);

		for (int i = 0; i < list.size(); i++) {
			IRow row = (IRow) list.get(i);
			handler.handle(row);
		}
	}

	public boolean every(IRowHandler handler, String area) {
		List list = getRowsFromArray(area);

		boolean isSatisfied = false;
		for (int i = 0; i < list.size(); i++) {
			IRow row = (IRow) list.get(i);
			isSatisfied = handler.handle(row);
			if (!isSatisfied)
				return false;
		}
		return true;
	}

	public boolean some(IRowHandler handler, String area) {
		List list = getRowsFromArray(area);

		boolean isSatisfied = false;
		for (int i = 0; i < list.size(); i++) {
			IRow row = (IRow) list.get(i);
			isSatisfied = handler.handle(row);
			if (isSatisfied)
				return true;
		}
		return false;
	}

	public int getRowCount(String area) {
		List list = getRowsFromArray(area);

		return list.size();
	}

	public int getTotalCount() {
		int count = getFilterRows().size();
		count += getDeleteRows().size();
		count += getRows().size();
		return count;
	}

	public boolean isEmpty() {
		if (getTotalCount() == 0) {
			return true;
		}
		return false;
	}

	public void deleteRow(int index, String area) {
		JSONObject rowsetObj = this.rowsetObj;
		if (area.equalsIgnoreCase("primary")) {
			JSONArray arr = rowsetObj.getJSONArray("primary");
			if ((arr.size() == 0) || (index > arr.size() - 1)) {
				return;
			}
			arr.remove(index);
		} else if (area.equalsIgnoreCase("delete")) {
			JSONArray arr = rowsetObj.getJSONArray("delete");
			if ((arr.size() == 0) || (index > arr.size() - 1)) {
				return;
			}
			arr.remove(index);
		} else if (area.equalsIgnoreCase("filter")) {
			JSONArray arr = rowsetObj.getJSONArray("filter");
			if ((arr.size() == 0) || (index > arr.size() - 1)) {
				return;
			}
			arr.remove(index);
		}
	}

	public int addDeleteData(Map rowValueMap) {
		if (rowValueMap == null) {
			rowValueMap = new HashMap();
		}
		JSONArray delArray = this.rowsetObj.getJSONArray("delete");
		delArray.add(rowValueMap);
		return delArray.size() - 1;
	}

	public int addFilterData(Map rowValueMap) {
		if (rowValueMap == null) {
			rowValueMap = new HashMap();
		}
		JSONArray filterArray = this.rowsetObj.getJSONArray("filter");
		filterArray.add(rowValueMap);
		return filterArray.size() - 1;
	}

	public void clear() {
		this.rowsetObj.put("primary", new JSONArray());
		this.rowsetObj.put("delete", new JSONArray());
		this.rowsetObj.put("filter", new JSONArray());
	}

	public void addBatchRowData(List list) {
		int i = 0;
		for (int l = list.size(); i < l; i++)
			addRowData((Map) list.get(i));
	}

	public int addRow(IRow row) {
		row.setRowStatus(1);
		JSONArray primaryArray = this.rowsetObj.getJSONArray("primary");
		primaryArray.add(((Row) row).getRowObj());
		return primaryArray.size() - 1;
	}

	public int addRowData(Map rowValueMap) {
		if (rowValueMap == null) {
			rowValueMap = new HashMap();
		}
		JSONArray primaryArray = this.rowsetObj.getJSONArray("primary");
		primaryArray.add(rowValueMap);
		return primaryArray.size() - 1;
	}

	public void delBatchRow(int[] arr) {
		int max = -1;
		int loc = 0;
		for (int i = 0; i < arr.length; i++) {
			loc = i;
			max = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
					loc = j;
				}
			}
			arr[loc] = arr[i];
			JSONArray primaryArray = this.rowsetObj.getJSONArray("primary");
			primaryArray.remove(max);
		}
	}

	public void insertRow(int index, IRow row) {
		row.setRowStatus(1);
		JSONArray primaryArray = this.rowsetObj.getJSONArray("primary");
		primaryArray.add(index, ((Row) row).getRowObj());
	}

	public void insertRowData(int index, Map rowValueMap) {
		if (rowValueMap == null) {
			rowValueMap = new HashMap();
		}
		JSONArray primaryArray = this.rowsetObj.getJSONArray("primary");
		primaryArray.add(index, rowValueMap);
	}
}