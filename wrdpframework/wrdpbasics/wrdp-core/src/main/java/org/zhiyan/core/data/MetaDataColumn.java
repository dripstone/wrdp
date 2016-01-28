package org.zhiyan.core.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MetaDataColumn {
	private static final String NAME = "name";
	private static final String DATATYPE = "dataType";
	private static final String NULLABLE = "nullable";
	private static final String PRECISION = "precision";
	private static final String SCALE = "scale";
	private static final String PRIMARYKEY = "primaryKey";
	private static final String LABEL = "label";
	private static final String DEFAULTVALUE = "defaultValue";
	private static final String FORMAT = "format";
	private static final String MIN = "min";
	private static final String MAX = "max";
	private static final String RANGE = "range";
	private static final String PAST = "past";
	private static final String FUTURE = "future";
	private static final String PATTERN = "pattern";
	private static final String PROMPTS = "prompts";
	private Map attributes = new HashMap();

	public String getColumnName() {
		return (String) this.attributes.get("name");
	}

	public void setColumnName(String columnName) {
		this.attributes.put("name", columnName);
	}

	public int getDataType() {
		if (this.attributes.containsKey("dataType")) {
			Integer dataType = (Integer) this.attributes.get("dataType");
			return dataType.intValue();
		}
		return 12;
	}

	public void setDataType(int dataType) {
		this.attributes.put("dataType", new Integer(dataType));
	}

	public boolean isNullable() {
		if (this.attributes.containsKey("nullable")) {
			Boolean nullable = (Boolean) this.attributes.get("nullable");
			return nullable.booleanValue();
		}
		return true;
	}

	public void setNullable(boolean nullable) {
		this.attributes.put("nullable", new Boolean(nullable));
	}

	public int getPrecision() {
		if (this.attributes.containsKey("precision")) {
			Integer precision = (Integer) this.attributes.get("precision");
			return precision.intValue();
		}
		return -1;
	}

	public void setPrecision(int precision) {
		this.attributes.put("precision", new Integer(precision));
	}

	public int getScale() {
		if (this.attributes.containsKey("scale")) {
			Integer scale = (Integer) this.attributes.get("scale");
			return scale.intValue();
		}
		return 0;
	}

	public void setScale(int scale) {
		this.attributes.put("scale", new Integer(scale));
	}

	public boolean isPrimaryKey() {
		if (this.attributes.containsKey("primaryKey")) {
			Boolean primaryKey = (Boolean) this.attributes.get("primaryKey");
			return primaryKey.booleanValue();
		}
		return false;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.attributes.put("primaryKey", new Boolean(primaryKey));
	}

	public String getLabel() {
		return (String) this.attributes.get("label");
	}

	public void setLabel(String label) {
		this.attributes.put("label", label);
	}

	public Object getDefaultValue() {
		return this.attributes.get("defaultValue");
	}

	public void setDefaultValue(Object defaultValue) {
		this.attributes.put("defaultValue", defaultValue);
	}

	public String getFormat() {
		return (String) this.attributes.get("format");
	}

	public void setFormat(String format) {
		this.attributes.put("format", format);
	}

	public int getMax() {
		if (this.attributes.containsKey("max")) {
			Integer max = (Integer) this.attributes.get("max");
			return max.intValue();
		}
		return 2147483647;
	}

	public void setMax(int max) {
		this.attributes.put("max", new Integer(max));
	}

	public int getMin() {
		if (this.attributes.containsKey("min")) {
			Integer min = (Integer) this.attributes.get("min");
			return min.intValue();
		}
		return -2147483648;
	}

	public void setMin(int min) {
		this.attributes.put("min", new Integer(min));
	}

	public int getMinRange() {
		Map range = (Map) this.attributes.get("range");
		if ((range != null) && (range.containsKey("min"))) {
			return ((Integer) range.get("min")).intValue();
		}
		return -2147483648;
	}

	public int getMaxRange() {
		Map range = (Map) this.attributes.get("range");
		if ((range != null) && (range.containsKey("max"))) {
			return ((Integer) range.get("max")).intValue();
		}
		return 2147483647;
	}

	public void setMinRange(int min) {
		if (!this.attributes.containsKey("range")) {
			this.attributes.put("range", new HashMap());
		}
		((Map) this.attributes.get("range")).put("min", new Integer(min));
	}

	public void setMaxRange(int max) {
		if (!this.attributes.containsKey("range")) {
			this.attributes.put("range", new HashMap());
		}
		((Map) this.attributes.get("range")).put("max", new Integer(max));
	}

	public void setMinMaxRange(int min, int max) {
		setMinRange(min);
		setMaxRange(max);
	}

	public Date getPast() {
		if (this.attributes.containsKey("past")) {
			Long past = (Long) this.attributes.get("past");
			return new Date(past.longValue());
		}
		return null;
	}

	public void setPast(Date past) {
		this.attributes.put("past", new Long(past.getTime()));
	}

	public Date getFuture() {
		if (this.attributes.containsKey("future")) {
			Long future = (Long) this.attributes.get("future");
			return new Date(future.longValue());
		}
		return null;
	}

	public void setFuture(Date future) {
		this.attributes.put("future", new Long(future.getTime()));
	}

	public String getPattern() {
		return (String) this.attributes.get("pattern");
	}

	public void setPattern(String pattern) {
		this.attributes.put("pattern", pattern);
	}

	public String getPrompt(String name) {
		Map prompts = (Map) this.attributes.get("prompts");
		return prompts != null ? (String) prompts.get(name) : null;
	}

	public void setPrompt(String name, String value) {
		if (!this.attributes.containsKey("prompts")) {
			this.attributes.put("prompts", new HashMap());
		}
		Map prompts = (Map) this.attributes.get("prompts");
		prompts.put(name, value);
	}

	public Map getAttributes() {
		return this.attributes;
	}

	public Object getAttribute(String key) {
		return this.attributes.get(key);
	}

	public void setAttribute(String key, Object value) {
		this.attributes.put(key, value);
	}
}