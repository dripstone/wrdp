package org.zhiyan.core.data.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zhiyan.core.data.IMetaData;
import org.zhiyan.core.data.MetaDataColumn;

import net.sf.json.JSONObject;

public class MetaData implements IMetaData {
	private JSONObject metaObj;

	public MetaData(JSONObject metaObj) {
		this.metaObj = metaObj;
	}

	public MetaData() {
		String metaStr = "{columns:{},order:\"\",condition:\"\"}";
		this.metaObj = JSONObject.fromObject(metaStr);
	}

	public final JSONObject getJSONObject() {
		return this.metaObj;
	}

	private JSONObject getColumnObj() {
		return this.metaObj.getJSONObject("columns");
	}

	@Override
	public void addColumn(String columnName, Map dataMap) {
		// if (getColumnObj().containsKey(columnName)) {
		// getColumnObj().remove(columnName);
		// }
		// getColumnObj().accumulate(columnName, "{}");
		// Iterator iter = dataMap.entrySet().iterator();
		//
		// while (iter.hasNext()) {
		// Map.Entry entry = (Map.Entry) iter.next();
		// getColumnObj().getJSONObject(columnName).accumulate(ConvertionUtil.toValidJson(entry.getKey().toString()),
		// entry.getValue());
		// }
	}

	@Override
	public void addColumn(MetaDataColumn column) {
		String columnName = column.getColumnName();
		if (getColumnObj().containsKey(column.getColumnName())) {
			getColumnObj().remove(columnName);
		}
		getColumnObj().accumulate(columnName, "{}");
		// if (column.getLabel() != null) {
		// getColumnObj().getJSONObject(columnName).accumulate("label",
		// ConvertionUtil.toValidJson(column.getLabel()));
		// }

		int dataType = 0;
		dataType = column.getDataType();
		if (dataType != 0) {
			getColumnObj().getJSONObject(columnName).accumulate("dataType", column.getDataType());
		}

		if (column.getDefaultValue() != null) {
			getColumnObj().getJSONObject(columnName).accumulate("defaultValue", column.getDefaultValue().toString());
		}
		if (column.getFormat() != null) {
			getColumnObj().getJSONObject(columnName).accumulate("format", column.getFormat());
		}
		getColumnObj().getJSONObject(columnName).accumulate("nullable", column.isNullable());
		int precision = -1;
		precision = column.getPrecision();
		if (precision != -1) {
			getColumnObj().getJSONObject(columnName).accumulate("precision", column.getPrecision());
		}
		getColumnObj().getJSONObject(columnName).accumulate("primaryKey", column.isPrimaryKey());
		int scale = 0;
		scale = column.getScale();
		if (scale != 0) {
			getColumnObj().getJSONObject(columnName).accumulate("scale", column.getScale());
		}
		if (column.getAttributes() != null) {
			Map attrMap = column.getAttributes();
			if (attrMap != null) {
				Iterator iter = attrMap.entrySet().iterator();

				while (iter.hasNext()) {
					Map.Entry entry = (Map.Entry) iter.next();
					if (!getColumnObj().getJSONObject(columnName).containsKey("attribute")) {
						getColumnObj().getJSONObject(columnName).accumulate("attribute", "{}");
					}
					getColumnObj().getJSONObject(columnName).getJSONObject("attribute")
							.accumulate(entry.getKey().toString(), entry.getValue().toString());
				}
			}
		}
	}

	@Override
	public List getColumns() {
		List list = new ArrayList();
		if (getColumnObj() != null) {
			Iterator iter = getColumnObj().entrySet().iterator();

			int dataType = 0;

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String columnName = entry.getKey().toString();
				JSONObject metaObj = getColumnObj().getJSONObject(columnName);
				Iterator colIter = metaObj.entrySet().iterator();
				MetaDataColumn colBean = new MetaDataColumn();
				colBean.setColumnName(columnName);
				while (colIter.hasNext()) {
					Map.Entry colEntry = (Map.Entry) colIter.next();
					String propertyName = colEntry.getKey().toString();

					if (propertyName.equals("label")) {
						colBean.setLabel(colEntry.getValue().toString());
					}

					if (propertyName.equals("dataType")) {
						if ((colEntry.getValue() == null) || ("".equals(colEntry.getValue().toString())))
							dataType = 0;
						else {
							dataType = Integer.parseInt(colEntry.getValue().toString());
						}
						colBean.setDataType(dataType);
					}

					if (propertyName.equals("defaultValue")) {
						// Object obj =
						// ConvertionUtil.constructObject(colEntry.getValue(),
						// dataType);
						// colBean.setDefaultValue(obj);
					}

					if (propertyName.equals("format")) {
						colBean.setFormat(colEntry.getValue().toString());
					}

					if (propertyName.equals("nullable")) {
						if (colEntry.getValue().toString().equals("false"))
							colBean.setNullable(false);
						else {
							colBean.setNullable(true);
						}
					}

					if (propertyName.equals("precision")) {
						if ((colEntry.getValue() == null) || ("".equals(colEntry.getValue().toString())))
							colBean.setPrecision(0);
						else {
							colBean.setPrecision(Integer.parseInt(colEntry.getValue().toString()));
						}
					}

					if (propertyName.equals("primaryKey")) {
						if (colEntry.getValue().toString().equals("false"))
							colBean.setPrimaryKey(false);
						else {
							colBean.setPrimaryKey(true);
						}
					}

					if (propertyName.equals("scale")) {
						if ((colEntry.getValue() == null) || ("".equals(colEntry.getValue().toString())))
							colBean.setScale(0);
						else {
							colBean.setScale(Integer.parseInt(colEntry.getValue().toString()));
						}
					}
					if ((propertyName.equals("attribute")) && (colEntry.getValue() != null)) {
						if (!"".equals(colEntry.getValue().toString())) {
							JSONObject attrObj = (JSONObject) colEntry.getValue();
							Iterator attriter = attrObj.entrySet().iterator();

							while (attriter.hasNext()) {
								Map.Entry attrEntry = (Map.Entry) attriter.next();
								colBean.setAttribute(attrEntry.getKey().toString(), attrEntry.getValue());
							}
						}
					}
				}

				list.add(colBean);
			}
		}
		return list;
	}

	@Override
	public MetaDataColumn getColumn(String columnName) {
		MetaDataColumn colBean = null;
		if ((getColumnObj() != null) && (getColumnObj().containsKey(columnName))) {
			colBean = new MetaDataColumn();
			colBean.setColumnName(columnName);
			JSONObject colObj = (JSONObject) getColumnObj().get(columnName);

			if (colObj.containsKey("label")) {
				colBean.setLabel(colObj.getString("label"));
			}
			int dataType = 0;

			if (colObj.containsKey("dataType")) {
				dataType = colObj.getInt("dataType");
				colBean.setDataType(dataType);
			}

			if (colObj.containsKey("defaultValue")) {
				// Object obj =
				// ConvertionUtil.constructObject(colObj.get("defaultValue"),
				// dataType);
				// colBean.setDefaultValue(obj);
			}

			if (colObj.containsKey("format")) {
				colBean.setFormat(colObj.getString("format"));
			}

			if (colObj.containsKey("nullable")) {
				colBean.setNullable(colObj.getBoolean("nullable"));
			}

			if (colObj.containsKey("precision")) {
				colBean.setPrecision(colObj.getInt("precision"));
			}

			if (colObj.containsKey("primaryKey")) {
				colBean.setPrimaryKey(colObj.getBoolean("primaryKey"));
			}

			if (colObj.containsKey("scale")) {
				colBean.setScale(colObj.getInt("scale"));
			}
			if (colObj.containsKey("attribute")) {
				JSONObject attrObj = (JSONObject) colObj.get("attribute");
				Iterator iter = attrObj.entrySet().iterator();

				while (iter.hasNext()) {
					Map.Entry attrEntry = (Map.Entry) iter.next();
					colBean.setAttribute(attrEntry.getKey().toString(), attrEntry.getValue());
				}
			}

		}

		return colBean;
	}

	@Override
	public Object getPropertyValue(String key) {
		Object value = null;
		if (this.metaObj.containsKey(key)) {
			value = this.metaObj.get(key);
		}
		return value;
	}

	@Override
	public void addProperty(String key, Object value) {
		this.metaObj.put(key, value);
	}
}