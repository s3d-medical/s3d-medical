<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/22
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<br>
current session id : <%=request.getSession().getId()%>
<br>
current server name: <%=request.getServerName()%>
<br>
current server port: <%=request.getServerPort()%>
<br>
user maintain home page.

</body>
</html>
