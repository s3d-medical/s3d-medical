package com.s3d.webapps.component.forms;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import com.s3d.webapps.component.forms.controls.CalendarControl;
import com.s3d.webapps.component.forms.controls.CheckBoxControl;
import com.s3d.webapps.component.forms.controls.ElementValueControl;
import com.s3d.webapps.component.forms.controls.FormControl;
import com.s3d.webapps.component.forms.controls.InputTextControl;
import com.s3d.webapps.component.forms.controls.RadioControl;
import com.s3d.webapps.component.forms.controls.SelectControl;
import com.s3d.webapps.component.forms.controls.TextAreaControl;
import com.s3d.webapps.component.forms.provider.DictionaryProvider;
import com.s3d.webapps.util.FileUtils;

public class HtmlParser implements ParseContext {
	
	private Document doc;
	
	private Object contextData;
	
	private DictionaryProvider dataDictionaryProvider;
	
	private static final List<FormTemplateControl> controls = new ArrayList<FormTemplateControl>();
	
	static {
		initControls();
	}
	
	private static final void initControls(){
		controls.add(new SelectControl());
		controls.add(new CheckBoxControl());
		controls.add(new RadioControl());
		
		controls.add(new FormControl());
		controls.add(new CalendarControl());
		controls.add(new InputTextControl());
		controls.add(new TextAreaControl());
		
		//--------------------
		controls.add(new ElementValueControl()); //at last
	}
	
	public String doc2String() { 
		return ControlUtil.removeUnnecessaryTags(this.doc.toString());
	}
	
	public String bodyHTML(){
		Element body = this.doc.select("body").first();
		String html = ControlUtil.removeUnnecessaryTags(body.html());
		return ControlUtil.removeUnnecessaryBlank(html);
	}
	
	public void loadFromFile(String path){
		String fileContent = FileUtils.getFileContent(path);
		loadFromString(fileContent);
	}
	
	public void loadFromString(String s) {
		//this.doc = Parser.parse(ControlUtil.removeUnecessaryChars(s), "");
		this.doc = Parser.parse(s, "");
	}
	
	public void parse() throws Exception{
		for (FormTemplateControl control : controls) {
			control.doParse(this);
		}
	}
	
	public void setContextData(Object contextData) {
		this.contextData = contextData;
	}

	public Object getContextData() {
		return contextData;
	}
	
	public DictionaryProvider getDataDictionaryProvider() {
		return dataDictionaryProvider;
	}

	public void setDataDictionaryProvider(DictionaryProvider dataDictionaryProvider) {
		this.dataDictionaryProvider = dataDictionaryProvider;
	}

	public Document getDocument() {
		return this.doc;
	}
}
