package org.zhiyan.core.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zhiyan.core.data.IDataCenter;
import org.zhiyan.core.data.IDataStore;

import net.sf.json.JSONObject;

public class DataCenter implements IDataCenter {
	private JSONObject jsonObj;
	private HashMap<String, Object> paramMap = new HashMap<String, Object>();
	private Map<String, DataStore> dataStoreMap = new HashMap<String, DataStore>();

	public DataCenter() {
		String initDcStr = "{header:{\"code\": 0,\"message\":{\"title\": \"\",\"detail\": \"\"}},body: {parameters:{},dataStores:{}}}";

		this.jsonObj = JSONObject.fromObject(initDcStr);
	}

	public final JSONObject getJSONObject() {
		return this.jsonObj;
	}

	public DataCenter(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
		initDataStores();
	}

	@Override
	public String toString() {
		return getJSONObject().toString();
	}

	private void initDataStores() {
		JSONObject storeObjs = getBodyObj().getJSONObject("dataStores");
		Iterator<?> iter = storeObjs.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String storeName = entry.getKey().toString();
			DataStore store = new DataStore(storeName, storeObjs.getJSONObject(storeName));
			this.dataStoreMap.put(storeName, store);
		}
	}

	private JSONObject getHeaderObj() {
		return this.jsonObj.getJSONObject("header");
	}

	private JSONObject getBodyObj() {
		return this.jsonObj.getJSONObject("body");
	}

	@Override
	public long getCode() {
		String codevalue = getHeaderObj().get("code").toString();

		return Long.parseLong(codevalue);
	}

	@Override
	public void setCode(long code) {
		getHeaderObj().put("code", String.valueOf(code));
	}

	@Override
	public IDataStore getDataStore(String storeName) {
		return this.dataStoreMap.get(storeName);
	}

	@Override
	public List getDataStores() {
		Iterator iter = this.dataStoreMap.entrySet().iterator();

		List list = new ArrayList();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public void addDataStore(IDataStore store) {
		JSONObject storesObj = getBodyObj().getJSONObject("dataStores");
		DataStore ds = (DataStore) store;
		storesObj.put(store.getStoreName(), ds.getJSONObject());
		this.dataStoreMap.put(store.getStoreName(), ds);
	}

	@Override
	public String getDetail() {
		JSONObject messageObj = getHeaderObj().getJSONObject("message");
		String detail = messageObj.get("detail").toString();
		return detail;
	}

	@Override
	public void setDetail(String detail) {
		JSONObject messageObj = getHeaderObj().getJSONObject("message");
		messageObj.put("detail", detail);
	}

	@Override
	public Map getParameters() {
		JSONObject paraObj = getBodyObj().getJSONObject("parameters");

		Iterator iter = paraObj.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object entryValue = entry.getValue();
			this.paramMap.put(entry.getKey().toString(), entryValue);
		}
		return this.paramMap;
	}

	@Override
	public Object getParameter(String key) {
		JSONObject paraObj = getBodyObj().getJSONObject("parameters");
		return paraObj.get(key);
	}

	@Override
	public void addParameter(String name, Object value) {
		JSONObject paraObj = getBodyObj().getJSONObject("parameters");
		paraObj.put(name, value);
	}

	@Override
	public void removeParameter(String name) {
		JSONObject paraObj = getBodyObj().getJSONObject("parameters");
		if (paraObj.isNullObject())
			return;
		if (paraObj.containsKey(name))
			paraObj.remove(name);
	}

	@Override
	public String getTitle() {
		JSONObject messageObj = getHeaderObj().getJSONObject("message");
		String title = messageObj.get("title").toString();
		return title;
	}

	@Override
	public void setTitle(String title) {
		JSONObject messageObj = getHeaderObj().getJSONObject("message");
		messageObj.put("title", title);
	}

	@Override
	public Map getHeaderAttributes() {
		Iterator iter = getHeaderObj().entrySet().iterator();
		Map headerAttrMap = new HashMap();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			if ((!entry.getKey().toString().equals("code")) && (!entry.getKey().toString().equals("message"))) {
				headerAttrMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
		}
		return headerAttrMap;
	}

	@Override
	public void addHeaderAttribute(String name, String value) {
		getHeaderObj().put(name, value);
	}

	@Override
	public Object clone() {
		return new DataCenter(JSONObject.fromObject(this.jsonObj));
	}
}