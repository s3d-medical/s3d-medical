package com.s3d.webapps.component.forms.provider;

import com.s3d.webapps.component.forms.DataDictionary;

public class SimpleDataDictionary implements DataDictionary {
	private String shortcut;
	private String text;
	private String value;
	
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getShortcut() {
		return shortcut;
	}

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}
}
