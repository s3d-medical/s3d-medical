<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="cms" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="cms" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="cms" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="cms" class="no-js"> <!--<![endif]-->
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
    <link rel="stylesheet" href="styles/css/style.css">
    <script src="vendor/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body ng-controller="RootCtrl as rt" ng-class="{'style-blue': options.style == 'blue', 'style-green': options.style == 'green', 'bg': options.currentState == 'home'}">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div ui-view class="container"></div>

<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->
<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="vendor/angular/angular.min.js"></script>
<script src="vendor/lodash/lodash.min.js"></script>
<script src="vendor/ui-router/release/angular-ui-router.min.js"></script>
<script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="vendor/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>

<script src="scripts/app.js"></script>
<script src="scripts/app.route.js"></script>

<script src="scripts/controllers/root.controller.js"></script>
<script src="scripts/controllers/home.controller.js"></script>
<script src="scripts/controllers/main.controller.js"></script>
<script src="scripts/controllers/system/system.controller.js"></script>
<script src="scripts/controllers/system/departments.controller.js"></script>
<script src="scripts/controllers/system/department.controller.js"></script>
<script src="scripts/controllers/system/employee.controller.js"></script>
<script src="scripts/controllers/system/roles.controller.js"></script>
<script src="scripts/controllers/system/role.controller.js"></script>
<script src="scripts/controllers/system/user.roles.controller.js"></script>
<script src="scripts/controllers/system/permissions.controller.js"></script>

<%@ include file="views/home.jsp"%>
<%@ include file="views/main.jsp"%>
<%@ include file="views/system/system.jsp"%>
<%@ include file="views/system/departments.jsp"%>
<%@ include file="views/system/department.jsp"%>
<%@ include file="views/system/employee.jsp"%>
<%@ include file="views/system/roles.jsp"%>
<%@ include file="views/system/role.jsp"%>
<%@ include file="views/system/user-roles.jsp"%>
<%@ include file="views/system/permissions.jsp"%>

</body>
</html>
