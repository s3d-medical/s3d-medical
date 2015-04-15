<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/*response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	response.flushBuffer();*/
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>欢迎登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="xx">
	<link rel="shortcut icon" type="image/x-icon" href="<%=path%>/resources/images/iconkey.ico" media="screen" />
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.cookie.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/zice.style.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/tipsy.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/resources/css/buttons.css">
	<script type="text/javascript" src="<%=path%>/resources/js/iphone.check.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery-jrumble.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.tipsy.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/login.js"></script>
	<script type="text/javascript">
		var contentBase = '<%=path %>';
		if(top!=self){
			if(top.location != self.location)
			 top.location=self.location; 
		}
	</script>
	 <style type="text/css">
html {
	background-image: none;
}

label.iPhoneCheckLabelOn span {
	padding-left: 0px
}

#versionBar {
	background-color: #212121;
	position: fixed;
	width: 100%;
	height: 35px;
	bottom: 0;
	left: 0;
	text-align: center;
	line-height: 35px;
	z-index: 11;
	-webkit-box-shadow: black 0px 10px 10px -10px inset;
	-moz-box-shadow: black 0px 10px 10px -10px inset;
	box-shadow: black 0px 10px 10px -10px inset;
}

.copyright {
	text-align: center;
	font-size: 10px;
	color: #CCC;
}

.copyright a {
	color: #A31F1A;
	text-decoration: none
}

/*update-begin--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
.on_off_checkbox{
	width:0px;
}
/*update-end--Author:tanghong  Date:20130419 for：【是否】按钮错位*/
#login .logo {
	width: 500px;
	height: 51px;
}
#cap{
margin-left: 88px;
}
</style>
  </head>
  <body>
	<div id="alertMessage"></div>
	<div id="successLogin"></div>
	<div class="text_success">
		<img src="<%=path%>/resources/images/loader_green.gif" alt="Please wait" /> <span>登陆成功!请稍后....</span>
	</div>
	<div id="login">
		<div class="ribbon" style="background-image:url(<%=path%>/resources/images/typelogin.png);"></div>
		<div class="inner">
			<div class="logo">
				<img src="<%=path%>/resources/images/toplogo-jeecg.png" />
			</div>
			<div class="formLogin">
				<form name="formLogin" action="<%=path %>/j_spring_security_check" id="formLogin" method="post">
					<input type=hidden id="redirectTo" name="redirectTo" value="<%=path%><%--<c:out value="${redirectTo}" />--%>">
					<div class="tip">
						<input class="userName" name="username" type="text" id="username" title="用户名" iscookie="true" value="admin" nullmsg="请输入用户名!" />
					</div>
					<div class="tip">
						<input class="password" name="password" type="password" id="password" title="密码" value="1" nullmsg="请输入密码!" />
					</div>
					<div class="loginButton">
						<div style="float: left; margin-left: -9px;">
							<input type="checkbox" id="on_off" name="remember" checked="ture" class="on_off_checkbox" value="0" /> <span class="f_help">是否记住用户名?</span>
						</div>
						<div style="float: right; padding: 3px 0; margin-right: -12px;">
							<div>
								<ul class="uibutton-group">
									<li><a class="uibutton normal" href="javascript:void(0);" id="but_login">登陆</a>
									</li>
									<li><a class="uibutton normal" href="javascript:void(0);" id="forgetpass">重置</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
		<div class="shadow"></div>
	</div>
	<!--Login div-->
	<div class="clear"></div>
	<div id="versionBar">
		<div class="copyright">&copy; 版权所有 <span class="tip"><a href="javascript:void(0);" title="sysErp">sy</a>
				(推荐使用谷歌浏览器可以获得更快,更安全的页面响应速度)技术支持:<a href="javascript:void(0);" title="sysErp">xx</a> </span>
		</div>
	</div>
</body>
</html>
