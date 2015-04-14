<%@ include file="/resources/jsp/common.jsp"%>
<!DOCTYPE HTML>
<%@ page import="javax.servlet.http.Cookie, com.s3d.webapps.util.*" %>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="No-Cache">
<script type="text/javascript">
<%
	String WEBAPPS_Parameter_Style = request.getParameter("s_css");
	if(WEBAPPS_Parameter_Style==null || WEBAPPS_Parameter_Style.equals("")){
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0)
			for (int i = 0; i < cookies.length; i++)
				if ("WEBAPPS_Style".equals(cookies[i].getName())) {
					WEBAPPS_Parameter_Style = cookies[i].getValue();
					break;
				}
	}
	if(WEBAPPS_Parameter_Style==null || WEBAPPS_Parameter_Style.equals(""))
		WEBAPPS_Parameter_Style="default";  
	
	if(WEBAPPS_Parameter_Style.toLowerCase().indexOf("script") > 0){
		WEBAPPS_Parameter_Style = "default"; 
	}
	request.setAttribute("WEBAPPS_Parameter_Style", WEBAPPS_Parameter_Style);
	String WEBAPPS_Parameter_ContextPath = request.getContextPath()+"/";
	request.setAttribute("WEBAPPS_Parameter_ContextPath", WEBAPPS_Parameter_ContextPath);
	String WEBAPPS_Parameter_ResPath = WEBAPPS_Parameter_ContextPath+"resources/";
	request.setAttribute("WEBAPPS_Parameter_ResPath", WEBAPPS_Parameter_ResPath);
	String WEBAPPS_Parameter_StylePath = WEBAPPS_Parameter_ResPath + "style/"+WEBAPPS_Parameter_Style+"/";
	request.setAttribute("WEBAPPS_Parameter_StylePath", WEBAPPS_Parameter_StylePath);
	request.setAttribute("WEBAPPS_Parameter_CurrentUserId", UserUtil.getUser().getFdId());
%>
var Com_Parameter = {
	ContextPath:"${WEBAPPS_Parameter_ContextPath}",
	ResPath:"${WEBAPPS_Parameter_ResPath}",
	Style:"${WEBAPPS_Parameter_Style}",
	StylePath:"${WEBAPPS_Parameter_StylePath}",
	Lang:"<%= request.getLocale().toString().toLowerCase().replace('_', '-') %>",
	CurrentUserId:"${WEBAPPS_Parameter_CurrentUserId}"
};
</script>
<link rel="shortcut icon" href="${WEBAPPS_Parameter_ContextPath}favicon.ico"> 
<link href="${WEBAPPS_Parameter_ResPath}bui/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="${WEBAPPS_Parameter_ResPath}bui/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="${WEBAPPS_Parameter_ResPath}css/icon.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/base.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}bui/bui.js"></script>
<style type="text/css">
body {
	font-family: helvetica, tahoma, verdana, sans-serif;
	font-size: 13px;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
}
div.container	{
	margin-left:0;margin-top:0;width:auto;padding:10px 10px 0 10px;
}
</style>