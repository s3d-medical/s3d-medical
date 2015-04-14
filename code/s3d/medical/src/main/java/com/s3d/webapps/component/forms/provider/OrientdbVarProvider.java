package com.s3d.webapps.component.forms.provider;

import com.s3d.webapps.component.forms.IFormVarProvider;
import com.s3d.webapps.component.forms.exception.VarNotFoundException;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;

public class OrientdbVarProvider implements IFormVarProvider {

	@Override
	public Object getValue(Object contextData, String varName)
			throws Exception, VarNotFoundException {
		DaCustomerPicture picture = (DaCustomerPicture) contextData;
		
		return null;
	}
}
