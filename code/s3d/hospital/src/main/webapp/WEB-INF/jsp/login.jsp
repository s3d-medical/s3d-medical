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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>病案管理系统</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="vendor/html5-boilerplate/dist/css/normalize.css">
    <link rel="stylesheet" href="vendor/html5-boilerplate/dist/css/main.css">
    <link rel="stylesheet" href="vendor/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/css/common.css">
    <link rel="stylesheet" href="styles/css/login.css">
    <script src="vendor/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body class="bg">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->


<div class="login">
    <div class="header">

    </div>
    <div class="content">
        <div>
            <ul class="theme-wrap">
                <li class="bg-blue" onclick="changeTheme('style-blue')" title="切换主题"></li>
                <li class="bg-green" onclick="changeTheme('style-green')" title="切换主题"></li>
            </ul>
            <h3>病案管理系统</h3>
            <form action="<%=request.getContextPath()%>/authenticate" method="post">
                <div class="form-group">
                    <i class="glyphicon glyphicon-user"></i>
                    <input type="text" class="form-control" name="userName" placeholder="用户名">
                </div>
                <div class="form-group">
                    <i class="glyphicon glyphicon-lock"></i>
                    <input type="password" class="form-control" name="password" placeholder="密码">
                </div>
                <button type="submit" class="btn btn-primary btn-block form-group">用户登录</button>
            </form>
        </div>
    </div>
    <div class="footer">

    </div>
</div>

<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        var themeClass = localStorage.getItem('themeClass') || 'style-blue';
        $('body').addClass(themeClass);
    });

    function changeTheme (themeClass) {
        var $body = $('body');
        $body.removeClass('style-blue style-green');
        $body.addClass(themeClass);
        localStorage.setItem('themeClass', themeClass);
    }

</script>

</body>
</html>
