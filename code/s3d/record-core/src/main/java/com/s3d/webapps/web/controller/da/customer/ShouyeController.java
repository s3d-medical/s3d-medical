package com.s3d.webapps.web.controller.da.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.persistence.DaCustomerShouye;
import com.s3d.webapps.da.customer.service.IDaCustomerPictureService;
import com.s3d.webapps.da.customer.service.IDaCustomerShouyeService;

@Controller
@RequestMapping(value=ShouyeController.RequestMappingPath)
public class ShouyeController extends BaseController<DaCustomerShouye>{
	public final static String RequestMappingPath = "/da/customer/shouye";
		
	@Autowired
	private IDaCustomerShouyeService daCustomerShouyeService;
	
	@Autowired
	private IDaCustomerPictureService daCustomerPictureService;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daCustomerShouyeService;
	}
	
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;
		
		return whereBlock;
	}	
	
	@RequestMapping("/gethtml")
	public String getHTMLTepmlate(HttpServletRequest request,HttpServletResponse response) {
		String fdId = request.getParameter("id");
		DaCustomerPicture picture =  daCustomerPictureService.findByPrimaryKey(fdId);
		try {
			String result = daCustomerShouyeService.genarateEditingShouyeHTML(picture);
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
