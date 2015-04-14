<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>
<decorator:title/><fmt:message key="ui.title" /></title>
<link href="/styles/theme/css/core.css" rel="stylesheet" type="text/css" />
<link href="/styles/theme/css/yuanzhao.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="/styles/theme/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->
<style type="text/css">
/* suggest */
#suggest{position:absolute; z-index:2000; left:0; top:0;}
#suggest ul{list-style:none; padding:1px; margin:0; background-color:#fff; border:1px solid #999; width:150px;}
#suggest li{display:block; color:#000; padding:3px; margin:0; border:1px solid #fff; background-color:transparent; text-align:left; cursor:default;}
#suggest li.selected{border:1px solid #0a246a; background-color:#b6bdd2}
#calendar {z-index:1000}

#alertBackground { display:none; width:100%; height:100%; opacity:0.4; filter:alpha(opacity=40); background:#FFF; position:absolute; top:0; left:0; z-index:100;}
</style>
<!--[if lt IE 9]>
<script src="/styles/js/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".menubar li").hover(function(){
		$(this).addClass("selected");
	},function(){
		$(this).removeClass("selected");
	});
	
	$(".onlineSupport").hover(function(){
		$(this).addClass("onlineSupportOpen");
	},function(){
		$(this).removeClass("onlineSupportOpen");
	});
});
</script>
<decorator:head/>
</head>
<body>
<section id="container" class="container">
	<c:import url="/views/layout/header.jsp" charEncoding="UTF-8"/>
	<section id="content">
		<decorator:body/>
	</section>
	<c:import url="/views/layout/footer.jsp" charEncoding="UTF-8"/>
</section>
</body>
</html>