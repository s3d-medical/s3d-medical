package com.s3d.webapps.component.forms.controls;

import org.jsoup.nodes.Element;

import com.s3d.webapps.component.forms.FormTemplateControl;
import com.s3d.webapps.component.forms.ParseContext;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;

public class FormControl extends BaseControl implements FormTemplateControl{
	public final static String Selector = "form";
	
	@Override
	public void doParse(ParseContext parser) throws Exception {
		select(parser.getDocument());
		DaCustomerPicture picture = (DaCustomerPicture) parser.getContextData();
		
		for (Element ele : elements) {
			ele.attr("action", "updatepic/"+picture.getFdId());
		}
	}
	
	@Override
	protected String getSelector() {
		return Selector;
	}
}
