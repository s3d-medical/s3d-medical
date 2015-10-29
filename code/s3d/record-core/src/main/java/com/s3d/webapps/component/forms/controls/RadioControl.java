package com.s3d.webapps.component.forms.controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;

import com.s3d.webapps.component.forms.DataDictionary;
import com.s3d.webapps.component.forms.FormTemplateControl;
import com.s3d.webapps.component.forms.ParseContext;
import com.s3d.webapps.util.StringUtil;

public class RadioControl extends BaseControl implements FormTemplateControl{
	public final static String Selector = "control[type=radio]";
	
	@Override
	public void doParse(ParseContext parser) throws Exception {
		select(parser.getDocument());
		
		for (Element ele : elements) {
			Element parentnode = ele.parent();
			String name = ele.attr("name");
			Set<String> classes = ele.classNames();
			String data_source = ele.attr(Dictionary_source_attr_name);
			
			List<DataDictionary> data = new ArrayList<DataDictionary>(0);
			if(StringUtil.isNotNull(data_source)){
				List<DataDictionary> dbdata = parser.getDataDictionaryProvider().getDataDictionary(parser.getContextData(), data_source);
				if(dbdata!=null){
					data.addAll(dbdata);
				}
			}else{
				data.addAll(getDictionaryFromElement(ele));
				deleteDictionaryElements(ele);
			}
			
			for (DataDictionary dataDictionary : data) {
				Element label = parentnode.appendElement("label");
				label.addClass("control-label");
				label.addClass("radio");
				
				Element input = label.appendElement("input").
				attr("type", "radio").
				attr("name", name).
				classNames(classes).
				attr("value", dataDictionary.getValue()).
				appendText(dataDictionary.getText());
				
				copyAttributes(ele, input);
			}
			ele.remove();	
		}
	}
	
	@Override
	protected String getSelector() {
		return Selector;
	}
}
