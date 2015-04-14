<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>欢迎使用</title>
    
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />

</head>
<body leftmargin="8" topmargin='8'>

<table width="98%" align="center" border="0" cellpadding="4"
	cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
	<tr bgcolor="#EEF4EA">
		<td colspan="2"><span>友情提示</span></td>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td>您的登录状态已失效,请重新登录!</td>
		<td><input type="button" class="submit" value="返回登录" onclick="top.location.href='<%=path %>/logout';"/></td>
	</tr>
</table>
</body>
</html>
