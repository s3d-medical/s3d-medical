package com.s3d.webapps.component.forms.controls;

import org.jsoup.nodes.Element;

import com.s3d.webapps.component.forms.FormTemplateControl;
import com.s3d.webapps.component.forms.ParseContext;

public class TextAreaControl extends BaseControl implements FormTemplateControl{
	public final static String Selector = "control[type=textarea]";
	
	@Override
	public void doParse(ParseContext parser) throws Exception {
		select(parser.getDocument());
		
		for (Element ele : elements) {
			Element parentnode = ele.parent();
			Element input = parentnode.ownerDocument().createElement("textarea");
						
			input.classNames(ele.classNames()); //class
			input.attr("name",ele.attr("name")); //name
			
			copyAttributes(ele, input);
			
			ele.replaceWith(input);			
		}
	}
	
	@Override
	protected String getSelector() {
		return Selector;
	}
}
