package com.s3d.webapps.component.forms.provider;

import java.util.List;

import com.s3d.webapps.component.forms.DataDictionary;

public interface DictionaryProvider {
	
	public List<DataDictionary> getDataDictionary(Object contextData, String type)
			throws Exception;
}
