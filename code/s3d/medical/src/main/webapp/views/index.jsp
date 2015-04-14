<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>系统首页</title>
    <meta http-equiv="Content-Language" content="zh-cn" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="EHR">
	<link charset="utf-8" rel="stylesheet" href="<%=path %>/resources/css/index.css" />
  </head>  
  <body>
<!--[if IE 6]>
  <div id="kie-bar" class="kie-bar">
      您使用的浏览器版本过低，建议立即升级到
      <a href="http://ie.alipay.com/download" seed="kie-setup-IE8" target="_blank" ><i class="kie-bar-icon-ie"></i>Internet Explorer 8</a>
      或
      <a href="http://www.google.cn/intl/zh-CN/chrome/browser/" target="_blank" ><i class="kie-bar-icon-chrome"></i>Google Chrome</a>
  </div>
  <style>
      .kie-bar {
          height: 24px;
          line-height: 1.8;
          font-weight:normal;
          text-align: center;
          border-bottom:1px solid #fce4b5;
          background-color:#FFFF9B;
          color:#e27839;
          position: relative;
          font-size: 14px;
          text-shadow: 0px 0px 1px #efefef;
          padding: 5px 0;
      }
      .kie-bar a {
          color:#08c;
          text-decoration: none;
      }
  </style>
 <![endif]-->
 	<div class="topbar">
      <div class="grid-990 topbar-wrap fn-clear">
        <ul class="topmenu">
          <li class="topmenu-item topmenu-item-first"><a href="sysmng" target="_self" title="系统管理">系统管理</a></li>
          <li class="topmenu-item topmenu-item-dropdown" id="J-topmenu-dropdown">
          <a href="https://lab.s3d.com/user/i.htm" target="_blank">用户中心<i class="icon-dropdown"></i></a>
          <ul class="ui-list">
            <li class="ui-list-item"><a href="https://lab.s3d.com/consume/record/index.htm" target="_blank">处理记录</a></li>
            <li class="ui-list-item"><a href="https://shenghuo.s3d.com/transfer/index.htm" target="_blank">待定</a></li>
          </ul>
          </li>
          <li class="topmenu-item topmenu-item-last"><a href="http://help.s3d.com/lab/index.htm" target="_blank" title="帮助中心">帮助中心</a></li>
        </ul>
      </div>
    </div>
	<div class="box-css">
		<ul id="nav">
			<li class="top"><a href="http://www.s3d.com" class="top_link first">首页</a></li>
			<li class="top"><a href="http://www.s3d.com" class="top_link top_link_current"><span class="down down_current">主菜单1</span></a>
				<ul class="sub">
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk last">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
				</ul>
			</li>
			<li class="top"><a href="http://www.s3d.comnogo22" class="top_link"><span class="down">主菜单2</span></a>
				<ul class="sub sub01">
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk last">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
				</ul>
			</li>
			<li class="top"><a href="http://www.s3d.comnogo27" class="top_link"><span class="down">主菜单3</span></a>
				<ul class="sub">
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk last">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
				</ul>
			</li>
			<li class="top"><a href="#" class="top_link"><span class="down">主菜单4</span></a>
				<ul class="sub sub02">
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
					<div class="grp-sk last">
						<h5>待定</h5>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
						<p><a href="http://www.s3d.com">待定</a></p>
					</div>
				</ul>
			</li>
		</ul>
	</div>
	
  </body>
  <script>
  stuHover = function() {
  	var cssRule;
  	var newSelector;
  	for (var i = 0; i < document.styleSheets.length; i++)
  		for (var x = 0; x < document.styleSheets[i].rules.length ; x++)
  			{
  			cssRule = document.styleSheets[i].rules[x];
  			if (cssRule.selectorText.indexOf("LI:hover") != -1)
  			{
  				 newSelector = cssRule.selectorText.replace(/LI:hover/gi, "LI.iehover");
  				document.styleSheets[i].addRule(newSelector , cssRule.style.cssText);
  			}
  		}
  	var getElm = document.getElementById("nav").getElementsByTagName("LI");
  	for (var i=0; i<getElm.length; i++) {
  		getElm[i].onmouseover=function() {
  			this.className+=" iehover";
  		}
  		getElm[i].onmouseout=function() {
  			this.className=this.className.replace(new RegExp(" iehover\\b"), "");
  		}
  	}
  }
  if (window.attachEvent) window.attachEvent("onload", stuHover);
  </script>
</html>
