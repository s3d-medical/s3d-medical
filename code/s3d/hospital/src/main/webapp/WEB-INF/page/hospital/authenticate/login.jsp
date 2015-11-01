<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
hospital login page.

<form action="<%=request.getContextPath()%>/authenticate" method="post">
   User Name:  <input id="userName" name="userName" type="text" value=""/>
   Password:   <input id="password" name="password" type="password" value=""/>

   <button type="submit" name="loginIn" title="Sign In"></button>
</form>
</body>
</html>
