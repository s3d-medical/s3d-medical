<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/19
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="UTF-8" %>
<%@ page import="java.lang.Exception" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>错误页面</title>
</head>
<body>
<h1>出错了</h1>
<%
    Exception e = (Exception) request.getAttribute("exception");
    out.print(e.getMessage());
%>
</body>
</html>
