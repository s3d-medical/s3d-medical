package com.s3d.webapps.component.forms.controls;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.s3d.webapps.component.forms.DataDictionary;
import com.s3d.webapps.component.forms.provider.SimpleDataDictionary;
import com.s3d.webapps.util.StringUtil;

public abstract class BaseControl {
	protected static final String Dictionary_source_attr_name = "dictionary-source";
	protected Elements elements = null;
	
	public void select(Element doc) {
		this.elements = doc.select(this.getSelector());
	}

	protected abstract String getSelector();
	
	protected void copyAttributes(Element srcEle,Element distEle) {
		Attributes attrs = srcEle.attributes();
		for (Attribute attribute : attrs) {
			if(attribute.getKey().startsWith("data-")){
				distEle.attr(attribute.getKey(), attribute.getValue());
			}
		}
	}
	
	protected List<DataDictionary> getDictionaryFromElement(Element ele){
		Elements dics = ele.getElementsByTag("dictionary");
		List<DataDictionary> data = new ArrayList<DataDictionary>(dics.size());
		for (Element element : dics) {
			SimpleDataDictionary dataDictionary = new SimpleDataDictionary();
			dataDictionary.setShortcut(element.attr("shortcut"));
			dataDictionary.setValue(element.attr("value"));
			if(StringUtil.isNotNull(element.attr("text"))){
				dataDictionary.setText(element.attr("text"));
			}else{
				dataDictionary.setText(element.text());
			}
			data.add(dataDictionary);
		}
		return data;
	}
	
	protected void deleteDictionaryElements(Element ele){
		Elements dics = ele.getElementsByTag("dictionary");
		dics.remove();
	}
}
