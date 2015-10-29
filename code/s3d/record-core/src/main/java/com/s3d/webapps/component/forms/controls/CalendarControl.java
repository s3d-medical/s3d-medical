package com.s3d.webapps.component.forms.controls;

import com.s3d.webapps.component.forms.FormTemplateControl;
import com.s3d.webapps.component.forms.ParseContext;

public class CalendarControl extends BaseControl implements FormTemplateControl{
	public final static String Selector = "input.calendar";
	
	@Override
	public void doParse(ParseContext parser) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected String getSelector() {
		return Selector;
	}
}
