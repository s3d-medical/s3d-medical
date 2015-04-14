package com.s3d.webapps.component.forms;

import org.jsoup.nodes.Document;

import com.s3d.webapps.component.forms.provider.DictionaryProvider;

public interface ParseContext {
	Object getContextData();
	Document getDocument();
	DictionaryProvider getDataDictionaryProvider();
}
