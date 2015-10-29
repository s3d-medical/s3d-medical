package com.s3d.webapps.da.customer.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.component.forms.HtmlParser;
import com.s3d.webapps.component.forms.provider.DictionaryProvider;
import com.s3d.webapps.component.orientdb.OrientdbHelper;
import com.s3d.webapps.da.config.persistence.DaConfigPtemplate;
import com.s3d.webapps.da.config.service.IDaConfigPtemplateService;
import com.s3d.webapps.da.config.service.IDaConfigSetService;
import com.s3d.webapps.da.customer.dao.IDaCustomerShouyeDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.persistence.DaCustomerShouye;
import com.s3d.webapps.da.customer.service.IDaCustomerShouyeService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.util.ConfigLocationsUtil;
import com.s3d.webapps.util.FileUtils;
import com.s3d.webapps.util.StringUtil;


@ChildOf(parent="BaseService")
@Service(IDaCustomerShouyeService.SERVICE_NAME)
public class DaCustomerShouyeServiceImp extends AbstractBaseServiceMgr implements IDaCustomerShouyeService {
	@Autowired
	private IDaCustomerShouyeDao daCustomerShouyeDao;
	
	@Autowired
	private IDaConfigSetService daConfigSetService;
	
	@Autowired
	private IDaConfigPtemplateService daConfigPtemplateService;
	
	public IBaseDao getBaseDao(){
		return daCustomerShouyeDao;
	}


	@Override
	public String genarateEditingShouyeHTML(DaCustomerPicture picture) {
		
		boolean templateIsNew = false;
		DaConfigPtemplate template = daConfigPtemplateService.getTemplateByName("default");
		if(template==null){
			templateIsNew = true;
			template = new DaConfigPtemplate();
			template.setFdCreateTime(new Date());
			template.setFdName("default");
			template.setFdVersion(1);
		}
		String fileContent = FileUtils.getFileContent(ConfigLocationsUtil.getWebContentPath()+ "/template/template0.html");
		HtmlParser parser = new HtmlParser();
		parser.setContextData(picture);
		parser.setDataDictionaryProvider((DictionaryProvider) daConfigSetService);
		parser.loadFromString(fileContent);
		try {
			parser.parse();
			template.setFdHTMLContent(parser.doc2String());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(templateIsNew){
			daConfigPtemplateService.add(template);
		}else{
			daConfigPtemplateService.update(template);
		}
		
		synchronized(this){
			DaCustomerShouye daCustomerShouye = (DaCustomerShouye) findByPrimaryKey(picture.getFdId(),null,true);
			if(daCustomerShouye==null){			
				daCustomerShouye = new DaCustomerShouye();
				daCustomerShouye.setFdId(picture.getFdId());
				daCustomerShouye.setFdCreateTime(new Date());
				daCustomerShouye.setFdFileNo(picture.getFdFileNo());
				daCustomerShouye.setFdLabel(picture.getFdLabel());
				daCustomerShouye.setFdPicture(picture);
				daCustomerShouye.setFdTemplate(template);
				daCustomerShouye.setFdLastModifiedTime(new Date());
				add(daCustomerShouye);
			}
		}		
		//element value
		
		ODatabaseDocumentTx database = OrientdbHelper.getProjectDatabase(picture.getFdLabel().getFdParent().getFdId());
		
		ODocument document = OrientdbHelper.getDocumentById(database, picture.getFdId(), false);
		if(document!=null){
			Document doc = Jsoup.parse(fileContent);
			Elements storageElements = doc.select("control.storage");
			
			Document doc2 = parser.getDocument();
			for (Element element : storageElements) {
				String name = element.attr("name");
				if(StringUtil.isNotNull(name)){
					Object value = document.field(name);
					if(value!=null)
						setPropertyValue(doc2.getElementsByAttributeValue("name", name), value);
				}
			}
			return doc2.toString();
		}
		
		return template.getFdHTMLContent();
	}

	private void setPropertyValue(Elements elements,Object oValue) {
		if(oValue==null)return;
		
		Object sValue = null;
		List lValue = null;
		if (oValue instanceof Object[]) {
			Object[] arr = (Object[]) oValue;
			sValue =  StringUtils.join(arr, ";");
			lValue = Arrays.asList(arr);
		}else if (oValue instanceof List<?>) {
			lValue = (List) oValue;
			sValue = StringUtils.join(lValue, ";");
		}else{
			sValue = oValue.toString();
			lValue = Arrays.asList(StringUtils.split((String) sValue, ";"));
		}
		
		for (Element element : elements) {
			String tagName = element.tagName();
			String type = element.attr("type");
			if(type.equalsIgnoreCase("checkbox")){
				String myV = element.attr("value");
				if(lValue.contains(myV)){
					element.attr("checked","checked");
				}
				continue;
			}
			
			if(type.equalsIgnoreCase("radio")){
				if(element.attr("value").equals(sValue)){
					element.attr("checked", "true");
				}else{
					element.removeAttr("checked");
				}
			}else if(tagName.equalsIgnoreCase("select")){
				List<Node> nodes =element.childNodes();
				for (Node node : nodes) {
					if (node instanceof Element) {
						Element eleInSelect = (Element) node;
						eleInSelect.removeAttr("selected");
						if(eleInSelect.attr("value").equals(sValue)){
							eleInSelect.attr("selected", "true");
						}
					}
				}
			}else if(tagName.equalsIgnoreCase("textarea")){
				element.text(sValue.toString());
			}else if(type.equalsIgnoreCase("text") || type.equalsIgnoreCase("password") ){
				element.attr("value",sValue.toString());
			}
		}
	}
	
	/**
	 * 数字首页录入后点击保存触发,将表单数据保存进Orientdb数据库
	 */
	@Override
	public void updateShouye(HttpServletRequest request,
			DaCustomerPicture picture) {
		
		DaCustomerShouye daCustomerShouye = (DaCustomerShouye) findByPrimaryKey(picture.getFdId()); //
		
		String fileContent = FileUtils.getFileContent(ConfigLocationsUtil.getWebContentPath()+ "/template/template0.html");
		
		Document doc = Jsoup.parse(fileContent);
		
		Elements storageElements = doc.select("control.storage");
		
		Map dataMap = request.getParameterMap();		
		
		ODatabaseDocumentTx database = OrientdbHelper.getProjectDatabase(picture.getFdLabel().getFdParent().getFdId());
		
		ODocument document = OrientdbHelper.getDocumentById(database, picture.getFdId(), true);
		
		for (Element element : storageElements) {
			String name = element.attr("name");
			String type = element.attr("type");
			boolean isMultiValue = "checkbox".equals(type) || "true".equals(element.attr("data-isMultiValue").toLowerCase());
			if(StringUtil.isNotNull(name)){
				String[] values = (String[]) dataMap.get(name);
				//TODO 适配各种数据类型 String Number Boolean Date ....
				if(!isMultiValue){
					String value =  StringUtils.join(values, ";");
					document.removeField(name);
					document.field(name, value);
				}else{
					document.removeField(name);
					document.field(name, values);
				}
			}
		}
		document.save();
	}
}
