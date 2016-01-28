package org.zhiyan.core.data;

import java.util.Map;

public class Column {
	private String name;
	private String title;
	private int width;
	private int colSpan = 1;

	private int rowSpan = 1;
	private boolean isMulTitle;
	private String format;
	private Map<?, ?> codelist = null;

	public Column() {
	}

	public Column(String _name) {
		this.name = _name;
	}

	public Column(String _name, String _title) {
		this.name = _name;
		this.title = _title;
	}

	public Column(String _name, String _title, int _width) {
		this.name = _name;
		this.title = _title;
		this.width = _width;
	}

	public boolean ifCodeList() {
		return this.codelist != null;
	}

	public Map<?, ?> getCodelist() {
		return this.codelist;
	}

	public void setCodelist(Map<?, ?> codelist) {
		this.codelist = codelist;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getColSpan() {
		return this.colSpan;
	}

	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}

	public int getRowSpan() {
		return this.rowSpan;
	}

	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	public boolean isMulTitle() {
		return this.isMulTitle;
	}

	public void setMulTitle(boolean isMulTitle) {
		this.isMulTitle = isMulTitle;
	}
}