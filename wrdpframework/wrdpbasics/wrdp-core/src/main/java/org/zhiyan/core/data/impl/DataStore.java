package org.zhiyan.core.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.RowSetWriter;

import org.zhiyan.core.data.IDataStore;
import org.zhiyan.core.data.IMetaData;
import org.zhiyan.core.data.IRowSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataStore implements IDataStore {
	private String storeName;
	private JSONObject storeObj;
	private RowSetWriter rowSetWriter = null;

	public DataStore(String storeName) {
		this.storeName = storeName;
		String storeStr = "{rowSet: {\"primary\": [],\"filter\": [],\"delete\": []},parameters:{},name: \"" + storeName
				+ "\",pageNumber: 1,pageSize: 2147483647,recordCount: 0}";
		this.storeObj = JSONObject.fromObject(storeStr);
	}

	public DataStore(String storeName, JSONObject storeObj) {
		this.storeName = storeName;
		this.storeObj = storeObj;
	}

	@Override
	public String getStoreName() {
		return this.storeName;
	}

	@Override
	public void setStoreName(String name) {
		this.storeName = name;
	}

	public final JSONObject getJSONObject() {
		return this.storeObj;
	}

	public final JSONArray getPrimaryArray() {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
		return rowsetObj.getJSONArray("primary");
	}

	public final JSONArray getFilterArray() {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
		return rowsetObj.getJSONArray("filter");
	}

	public final JSONArray getDeleteArray() {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
		return rowsetObj.getJSONArray("delete");
	}

	@Override
	public Map getAttributes() {
		// Map attrMap = null;
		// if (this.storeObj.containsKey("attributes")) {
		// attrMap = new HashMap();
		// JSONObject attrObj = this.storeObj.getJSONObject("attributes");
		// Iterator iter = attrObj.entrySet().iterator();
		//
		// while (iter.hasNext()) {
		// Map.Entry entry = (Map.Entry) iter.next();
		// List list = new ArrayList();
		// try {
		// Object[] obj = ((JSONArray) entry.getValue()).toArray();
		// if ((obj == null) || (obj.length != 2)) {
		// LogFactory.getLog(SystemConfig.logCatagroy).error("attributes
		// 的值格式不正确。");
		// System.out.println("attributes 的值格式不正确。");
		// } else {
		// list.add(obj[0]);
		// list.add(obj[1]);
		// attrMap.put(entry.getKey().toString(), list);
		// }
		// } catch (Exception e) {
		// LogFactory.getLog(SystemConfig.logCatagroy).error("attributes
		// 的值格式不正确。",
		// e);
		// System.out.println("attributes 的值格式不正确。");
		// e.printStackTrace();
		// }
		// }
		// }
		//
		// return attrMap;
		return null;
	}

	@Override
	public void addAttribute(String key, String value, String dataType) {
		if (!this.storeObj.containsKey("attributes")) {
			this.storeObj.accumulate("attributes", "{}");
		}
		String keyvalue = "[\"" + value + "\",\"" + dataType + "\"]";
		this.storeObj.getJSONObject("attributes").accumulate(key, keyvalue);
	}

	@Override
	public void removeAttribute(String key) {
		if (!this.storeObj.containsKey("attributes"))
			return;
		JSONObject json = this.storeObj.getJSONObject("attributes");
		if (json.containsKey(key))
			json.remove(key);
	}

	@Override
	public void setAttributes(Map attrMap) {
		if (attrMap != null) {
			Iterator iter = attrMap.entrySet().iterator();

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				if (!this.storeObj.containsKey("attributes")) {
					this.storeObj.accumulate("attributes", "{}");
				}
				this.storeObj.getJSONObject("attributes").accumulate(entry.getKey().toString(), entry.getValue());
			}
		}
	}

	@Override
	public String getCondition() {
		String condition;
		if (this.storeObj.containsKey("condition"))
			condition = this.storeObj.get("condition").toString();
		else {
			condition = null;
		}
		return condition;
	}

	@Override
	public void setCondition(String condition) {
		this.storeObj.put("condition", condition);
	}

	@Override
	public Object getPropertyValue(String key) {
		Object value = null;
		if (this.storeObj.containsKey(key)) {
			value = this.storeObj.get(key);
		}
		return value;
	}

	@Override
	public void addProperty(String key, Object value) {
		this.storeObj.put(key, value.toString());
	}

	@Override
	public Map getParameters() {
		return getMapUtil("parameters");
	}

	@Override
	public void addParameter(String key, Object value) {
		if (!this.storeObj.containsKey("parameters")) {
			this.storeObj.put("parameters", "{}");
		}
		this.storeObj.getJSONObject("parameters").put(key, value);
	}

	@Override
	public void removeParameter(String key) {
		if (!this.storeObj.containsKey("parameters"))
			return;
		JSONObject obj = this.storeObj.getJSONObject("parameters");
		if (obj.containsKey(key))
			obj.remove(key);
	}

	@Override
	public void setParameters(Map contextMap) {
		if (contextMap != null) {
			if (!this.storeObj.containsKey("parameters")) {
				this.storeObj.accumulate("parameters", "{}");
			}
			Iterator iter = contextMap.entrySet().iterator();

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				this.storeObj.getJSONObject("parameters").put(entry.getKey().toString(), entry.getValue());
			}
		}
	}

	@Override
	public IMetaData getMetaData() {
		MetaData meta = null;
		if (this.storeObj.containsKey("metaData")) {
			meta = new MetaData(this.storeObj.getJSONObject("metaData"));
		}
		return meta;
	}

	@Override
	public void setMetaData(IMetaData metaData) {
		if (!this.storeObj.containsKey("metaData")) {
			this.storeObj.accumulate("metaData", "{}");
		}
		MetaData md = (MetaData) metaData;
		this.storeObj.put("metaData", md.getJSONObject());
	}

	@Override
	public String getOrder() {
		String order = null;
		if (this.storeObj.containsKey("order")) {
			order = this.storeObj.get("order").toString();
		}
		return order;
	}

	@Override
	public void setOrder(String order) {
		this.storeObj.put("order", order);
	}

	@Override
	public int getPageNo() {
		String noValue = this.storeObj.get("pageNumber").toString();
		return Integer.parseInt(noValue);
	}

	@Override
	public void setPageNo(int pageNo) {
		this.storeObj.put("pageNumber", new Integer(pageNo));
	}

	@Override
	public int getPageSize() {
		String noValue = this.storeObj.get("pageSize").toString();
		return Integer.parseInt(noValue);
	}

	@Override
	public void setPageSize(int pageSize) {
		this.storeObj.put("pageSize", new Integer(pageSize));
	}

	@Override
	public List getConditionValues() {
		List list = null;
		if (this.storeObj.containsKey("conditionValues")) {
			JSONArray paraArray = this.storeObj.getJSONArray("conditionValues");
			Object[] obj = paraArray.toArray();

			list = new ArrayList();
			for (int i = 0; i < obj.length; i++) {
				Object[] valueObj = ((JSONArray) obj[i]).toArray();
				list.add(valueObj);
			}
		}
		return list;
	}

	@Override
	public void setConditionValues(List list) {
		// this.storeObj.put("conditionValues", "[]");
		// if (list != null) {
		// for (int i = 0; i < list.size(); i++) {
		// Object obj = list.get(i);
		// int dataType =
		// ConvertionUtil.javaTypeToSqlType(obj.getClass().toString());
		// insertConditionValue(i, ConvertionUtil.toJson(obj),
		// String.valueOf(dataType));
		// }
		// }
	}

	@Override
	public void insertConditionValue(int index, String value, String dataType) {
		if (!this.storeObj.containsKey("conditionValues")) {
			this.storeObj.accumulate("conditionValues", "[]");
		}
		JSONArray paraArray = this.storeObj.getJSONArray("conditionValues");
		JSONArray valueArray = new JSONArray();
		valueArray.add(0, value);
		valueArray.add(1, dataType);
		paraArray.add(index, valueArray);
	}

	@Override
	public void insertConditionObj(int index, Object obj) {
		// int dataType =
		// ConvertionUtil.javaTypeToSqlType(obj.getClass().toString());
		// insertConditionValue(index, ConvertionUtil.toJson(obj),
		// String.valueOf(dataType));
	}

	@Override
	public String getPool() {
		String pool = null;
		if (this.storeObj.containsKey("pool")) {
			pool = this.storeObj.get("pool").toString();
		}
		return pool;
	}

	@Override
	public void setPool(String pool) {
		this.storeObj.put("pool", pool);
	}

	@Override
	public int getRecordCount() {
		String countValue = this.storeObj.get("recordCount").toString();
		return Integer.parseInt(countValue);
	}

	@Override
	public void setRecordCount(int recordCount) {
		this.storeObj.put("recordCount", new Integer(recordCount));
	}

	@Override
	public List getRowDatasWithStatus() {
		JSONArray primaryArray = getPrimaryArray();
		return getListUtil(primaryArray);
	}

	@Override
	public List getRowDatas() {
		JSONArray paraArray = getPrimaryArray();

		List list = new ArrayList();
		for (int i = 0; i < paraArray.size(); i++) {
			JSONObject obj = (JSONObject) paraArray.get(i);
			Iterator iter = obj.entrySet().iterator();
			Map map = new HashMap();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = entry.getKey().toString();
				Object value = entry.getValue();
				if ((!key.equals("_o")) && (!key.equals("_s")) && (!key.equals("_t"))) {
					if (isNull(value)) {
						value = null;
					}
					map.put(key, value);
				}
			}
			list.add(map);
		}
		return list;
	}

	public List getRowDataObjs() {
		JSONArray paraArray = getPrimaryArray();
		List list = new ArrayList();

		for (int i = 0; i < paraArray.size(); i++) {
			JSONObject obj = (JSONObject) paraArray.get(i);
			list.add(obj);
		}
		return list;
	}

	@Override
	public void addRowData(Map rowValueMap) {
		if (rowValueMap != null) {
			JSONArray primaryArray = getPrimaryArray();
			primaryArray.add(rowValueMap);
		}
	}

	@Override
	public List getDeleteDatas() {
		JSONArray deleteArry = getDeleteArray();
		return getListUtil(deleteArry);
	}

	public List getDeleteRowObjs() {
		JSONArray paraArray = getDeleteArray();
		List list = new ArrayList();

		for (int i = 0; i < paraArray.size(); i++) {
			JSONObject obj = (JSONObject) paraArray.get(i);
			list.add(obj);
		}
		return list;
	}

	@Override
	public void addDeleteData(Map rowValueMap) {
		if (rowValueMap != null)
			getDeleteArray().add(rowValueMap);
	}

	@Override
	public List getFilterDatasWithStatus() {
		JSONArray filterArry = getFilterArray();
		return getListUtil(filterArry);
	}

	public List getFilterRowDataObjs() {
		JSONArray paraArray = getFilterArray();
		List list = new ArrayList();

		for (int i = 0; i < paraArray.size(); i++) {
			JSONObject obj = (JSONObject) paraArray.get(i);
			list.add(obj);
		}
		return list;
	}

	@Override
	public void addFilterData(Map rowValueMap) {
		if (rowValueMap != null)
			getFilterArray().add(rowValueMap);
	}

	@Override
	public String getRowSetName() {
		String rowSetName = null;
		if (this.storeObj.containsKey("rowSetName")) {
			rowSetName = this.storeObj.get("rowSetName").toString();
		}
		return rowSetName;
	}

	@Override
	public void setRowSetName(String rowsetName) {
		this.storeObj.put("rowSetName", rowsetName);
	}

	@Override
	public String getStatementName() {
		String statementName = null;
		if (this.storeObj.containsKey("statementName")) {
			statementName = this.storeObj.get("statementName").toString();
		}
		return statementName;
	}

	@Override
	public void setStatementName(String statementName) {
		this.storeObj.put("statementName", statementName);
	}

	@Override
	public Map getStatistics() {
		Map staticMap = null;
		if (this.storeObj.containsKey("statistics")) {
			staticMap = new HashMap();
			JSONObject staticObj = this.storeObj.getJSONObject("statistics");
			Iterator iter = staticObj.entrySet().iterator();

			while (iter.hasNext()) {
				Map.Entry colentry = (Map.Entry) iter.next();
				JSONObject subobj = (JSONObject) colentry.getValue();
				Iterator valueiter = subobj.entrySet().iterator();
				Map valueMap = new HashMap();
				while (valueiter.hasNext()) {
					Map.Entry valueentry = (Map.Entry) valueiter.next();
					valueMap.put(valueentry.getKey().toString(), valueentry.getValue().toString());
				}
				staticMap.put(colentry.getKey().toString(), valueMap);
			}
		}
		return staticMap;
	}

	@Override
	public void addStatistics(String colName, Map staticMap) {
		if (!this.storeObj.containsKey("statistics")) {
			this.storeObj.accumulate("statistics", "{}");
		}
		JSONObject staticObj = this.storeObj.getJSONObject("statistics");
		if (!staticObj.containsKey(colName)) {
			staticObj.accumulate(colName, "{}");
		}
		Iterator iter = staticMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String value = entry.getValue().toString();
			staticObj.getJSONObject(colName).put(entry.getKey().toString(), value);
		}
	}

	@Override
	public void addStatistics(String colName, String pattern) {
		if (!this.storeObj.containsKey("statistics")) {
			this.storeObj.accumulate("statistics", "{}");
		}
		JSONObject staticObj = this.storeObj.getJSONObject("statistics");
		if (!staticObj.containsKey(colName)) {
			staticObj.accumulate(colName, "{}");
		}
		staticObj.getJSONObject(colName).put(pattern, "");
	}

	@Override
	public boolean isDistinct() {
		boolean isDistinct = false;
		if (this.storeObj.containsKey("distinct")) {
			String strValue = this.storeObj.get("distinct").toString();
			if (strValue.equals("true")) {
				isDistinct = true;
			}
		}
		return isDistinct;
	}

	@Override
	public void setDistinct(boolean isDistinct) {
		if (isDistinct)
			this.storeObj.put("distinct", "true");
		else
			this.storeObj.put("distinct", "false");
	}

	private Map getMapUtil(String nodeName) {
		Map map = null;
		if (this.storeObj.containsKey(nodeName)) {
			map = new HashMap();
			JSONObject attrObj = this.storeObj.getJSONObject(nodeName);
			Iterator iter = attrObj.entrySet().iterator();

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				map.put(entry.getKey().toString(), entry.getValue());
			}
		}
		return map;
	}

	private List getListUtil(JSONArray paraArray) {
		List list = new ArrayList();

		for (int i = 0; i < paraArray.size(); i++) {
			JSONObject obj = (JSONObject) paraArray.get(i);
			Iterator iter = obj.entrySet().iterator();
			Map map = new HashMap();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = entry.getKey().toString();
				Object value = entry.getValue();
				if (key.equals("_o")) {
					JSONObject _o = (JSONObject) value;
					Iterator items = _o.entrySet().iterator();
					Map m = new HashMap();
					while (items.hasNext()) {
						Map.Entry ent = (Map.Entry) items.next();
						Object v = ent.getValue();
						m.put(ent.getKey(), isNull(v) ? null : v);
					}
					value = m;
				} else if (isNull(value)) {
					value = null;
				}
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}

	private boolean isNull(Object value) {
		if ((value instanceof JSONObject)) {
			JSONObject v = (JSONObject) value;
			if (v.isNullObject()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setRowSetWriter(RowSetWriter rowSetWriter) {
		this.rowSetWriter = rowSetWriter;
	}

	public RowSetWriter getRowSetWriter() {
		return this.rowSetWriter;
	}

	@Override
	public Object clone() {
		DataStore ds = new DataStore(this.storeName, JSONObject.fromObject(this.storeObj));
		ds.setRowSetWriter(this.rowSetWriter);
		return ds;
	}

	@Override
	public void clearRowSet() {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
		rowsetObj.put("primary", new JSONArray());
		rowsetObj.put("delete", new JSONArray());
		rowsetObj.put("filter", new JSONArray());
	}

	@Override
	public void deleteRow(int index, String area) {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
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

	@Override
	public IRowSet getRowSet() {
		JSONObject rowsetObj = this.storeObj.getJSONObject("rowSet");
		return new RowSet(rowsetObj);
	}
}