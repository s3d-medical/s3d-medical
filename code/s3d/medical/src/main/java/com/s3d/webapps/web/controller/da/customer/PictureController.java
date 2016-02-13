package com.s3d.webapps.web.controller.da.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.config.persistence.DaConfigCategory;
import com.s3d.webapps.da.config.service.IDaConfigCategoryService;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.service.IDaCustomerPictureService;
import com.s3d.webapps.util.FileMimeTypeUtil;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.util.io.IOUtil;

@Controller
@RequestMapping(value=PictureController.RequestMappingPath)
public class PictureController extends BaseController<DaCustomerPicture>{
	public final static String RequestMappingPath = "/da/customer/picture";
		
	@Autowired
	private IDaCustomerPictureService daCustomerPictureService;
	
	@Autowired
	private IDaConfigCategoryService daConfigCategoryService;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daCustomerPictureService;
	}
	
	@RequestMapping(value = "/savejson", method = RequestMethod.POST)
	public ModelAndView savejson(HttpServletRequest request,HttpServletResponse response) {
		
		String json = request.getParameter("json");
		JSONArray jsonArray = JSON.parseArray(json);
		for (Object o : jsonArray) {
			JSONObject jsonobj = (JSONObject) o;
			String fdId = jsonobj.getString("fdId");
			DaCustomerPicture picture = (DaCustomerPicture) daCustomerPictureService.findByPrimaryKey(fdId, null, true);
			if(picture!=null){
				if(StringUtil.isNotNull(jsonobj.getString("fdFileNo"))){
					picture.setFdFileNo(jsonobj.getString("fdFileNo"));
				}
				if(StringUtil.isNotNull(jsonobj.getString("fdCategoryId"))){
					DaConfigCategory category =  (DaConfigCategory) daConfigCategoryService.findByPrimaryKey(jsonobj.getString("fdCategoryId"));
					if(category!=null){
						picture.setFdCategory(category);
					}
				}
				daCustomerPictureService.update(picture);
			}
		}		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;

		String isshouyeonly = request.getParameter("isshouyeonly");
		if("1".equals(isshouyeonly)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdCategory.fdType=1");
		}
		
		String labelId = request.getParameter("labelId");
		if(StringUtil.isNotNull(labelId)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdLabel.fdId='"+labelId+"'");
		}

		String fdLabelName = "";
		try {
			fdLabelName = new String(request.getParameter("fdLabelName").getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(StringUtil.isNotNull(fdLabelName)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdLabel.fdName='"+fdLabelName+"'");
		}
		
		String fdFileNo = request.getParameter("fdFileNo");
		if(StringUtil.isNotNull(fdFileNo)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdFileNo='"+fdFileNo+"'");
		}
		
		String fdFrom = request.getParameter("fdFrom");
		if(StringUtil.isNotNull(fdFrom)){
			Integer from = 0;
			try {
				from = Integer.valueOf(fdFrom);
			} catch (Exception e) {
			}
			if(from>0)
				whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdOrder >="+from+"");
		}
		
		String fdTo = request.getParameter("fdTo");
		if(StringUtil.isNotNull(fdTo)){
			Integer to = 0;
			try {
				to = Integer.valueOf(fdTo);
			} catch (Exception e) {
			}
			if(to>0)
				whereBlock = StringUtil.linkString(whereBlock, " and ", "daCustomerPicture.fdOrder <="+to+"");
		}
		
		return whereBlock;
	}	
	
	@Override
	protected IJSONSerializeConfig listjsonSerializeConfig() {
		return new IJSONSerializeConfigImpl();
	}
	
	@RequestMapping("/getthumb/{fdId}")
	public ModelAndView getThumb(HttpServletRequest request,HttpServletResponse response,@PathVariable("fdId") String fdId) {
		OutputStream out = null;
		InputStream in = null;
		try {
			String filename = "default_pic.jpg";
			
			long fileSize = 0;
			String fileContentType = "";
			
			DaCustomerPicture picture = (DaCustomerPicture) getBaseService().findByPrimaryKey(fdId);

			if ((picture != null) ) {
				
				in = picture.getFdThumb().getBinaryStream();
				fileSize = in.available();
				filename = picture.getFdPicName()+"-thumb.jpg";
				fileContentType = FileMimeTypeUtil.getContentType(filename);
				response.setContentLength((int) fileSize);
				response.setContentType(fileContentType);
				//response.setHeader("Content-Disposition","attachment;filename=\"" + filename + "\"");

				out = response.getOutputStream();
				
				IOUtil.write(in, out);

				response.flushBuffer();

				return null;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return error(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
				in = null;
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
				out = null;
			}
		}
		
		
		return null;
	}
	
	@RequestMapping("/getpicture/{fdId}")
	public ModelAndView getOriginal(HttpServletRequest request,HttpServletResponse response,@PathVariable("fdId") String fdId) {
		
		OutputStream out = null;
		InputStream in = null;
		try {		
			long fileSize = 0;
			String fileContentType = "";
			
			DaCustomerPicture picture = (DaCustomerPicture) getBaseService().findByPrimaryKey(fdId);

			if ((picture != null) ) {
				
				String filePath = picture.getFdPicPath();
				File file = new File(filePath);
				fileSize = file.length();
				String filename = encodeFileName(request, file.getName());
				fileContentType = FileMimeTypeUtil.getContentType(file);
				response.setContentLength((int) fileSize);
				response.setContentType(fileContentType);
				//response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

				out = response.getOutputStream();
				FileInputStream fr = new FileInputStream(file);
				
				IOUtil.write(fr, out);

				response.flushBuffer();

				return null;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return error(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
				in = null;
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
				out = null;
			}
		}
		
		
		return null;
	}
	
	private String encodeFileName(HttpServletRequest request, String oldFileName)
			throws UnsupportedEncodingException {
		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") == -1)
			oldFileName = new String(oldFileName.getBytes("UTF-8"), "ISO8859-1");
		else
			oldFileName = URLEncoder.encode(oldFileName, "UTF-8");
		oldFileName = oldFileName.replace("+", "%20");
		return oldFileName;
	}

    class IJSONSerializeConfigImpl implements IJSONSerializeConfig{

        @Override
        public String[] getPropertyFilterNames() {
            return new String[]{"new","interceptFieldCallback","fdCreateTime","fdOrder","fdPicPath","fdLastModifiedTime","fdMd5Hash","fdThumb","fdLabel","fdCategory"};
        }

        @Override
        public Map<String, Object> getAdditionalProperties(Object object) {
            if (object instanceof DaCustomerPicture) {
                Map<String, Object> map = new HashMap<String, Object>();
                DaCustomerPicture picture = (DaCustomerPicture) object;
                map.put("fdLabelName", picture.getFdLabel().getFdName());
                if(picture.getFdCategory()!=null){
                    map.put("categoryCheck", true);
                    map.put("fdCategoryName", picture.getFdCategory().getFdName());
                    map.put("fdCategoryId", picture.getFdCategory().getFdId());
                }
                if(StringUtil.isNotNull(picture.getFdFileNo())){
                    map.put("fileNoCheck", true);
                }
                return map;
            }
            return null;
        }

        @Override
        public String getDateFormat() {
            return "yyyy-MM-dd";
        }
    }
}
