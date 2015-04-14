package com.s3d.webapps.component.forms.controls;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import com.s3d.webapps.component.forms.DataDictionary;
import com.s3d.webapps.component.forms.FormTemplateControl;
import com.s3d.webapps.component.forms.ParseContext;
import com.s3d.webapps.util.StringUtil;

public class SelectControl extends BaseControl implements FormTemplateControl{
	public final static String Selector = "control[type=select]";
	
	@Override
	public void doParse(ParseContext parser) throws Exception {
		select(parser.getDocument());
		
		for (Element ele : elements) {
			Element parentnode = ele.parent();
			Element selection = parentnode.ownerDocument().createElement("select");
			String data_source = ele.attr(Dictionary_source_attr_name);
						
			selection.classNames(ele.classNames()); //class
			selection.attr("name",ele.attr("name")); //name
			
			copyAttributes(ele, selection);
			
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
				selection.appendElement("option").
				attr("value",dataDictionary.getValue()).
				attr("data-right", dataDictionary.getShortcut()).
				attr("searchcontent", dataDictionary.getShortcut()).				
				text(dataDictionary.getText());				    
			}
			ele.replaceWith(selection);			
		}
	}
	
	@Override
	protected String getSelector() {
		return Selector;
	}
}
