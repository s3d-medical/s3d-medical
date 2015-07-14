<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String WEBAPPS_Parameter_Style="bootstrap";
	Cookie cookies[] =request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(Cookie cookie : cookies){
			if (cookie.getName().equals("cookiesColor")) {
				WEBAPPS_Parameter_Style = cookie.getValue();
				break;
			}
		}
	}
	String WEBAPPS_Parameter_ContextPath = request.getContextPath()+"/";
	request.setAttribute("WEBAPPS_Parameter_ContextPath", WEBAPPS_Parameter_ContextPath);
	String WEBAPPS_Parameter_ResPath = WEBAPPS_Parameter_ContextPath+"resources/";
	request.setAttribute("WEBAPPS_Parameter_ResPath", WEBAPPS_Parameter_ResPath);
	String WEBAPPS_Parameter_ThemePath = WEBAPPS_Parameter_ResPath + "themes/"+WEBAPPS_Parameter_Style+"/";
	request.setAttribute("WEBAPPS_Parameter_ThemePath", WEBAPPS_Parameter_ThemePath);
%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>系统管理</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${WEBAPPS_Parameter_ResPath}bui/css/dpl-min.css" rel="stylesheet" type="text/css" />
	<link href="${WEBAPPS_Parameter_ResPath}bui/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="${WEBAPPS_Parameter_ResPath}bui/css/main-min.css" rel="stylesheet" type="text/css" />
   	<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.js"></script>
	<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/base.js"></script>
	<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}bui/bui.js"></script>
   
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
        <a href="/" title="地址" target="_blank">
         
        </a>
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">admin</span><a href="###" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>

  <script>
    BUI.use('common/main',function(){
      var config = [{
            id:'sysorg',
            menu:[{
                text:'系统初始化',
                items:[
                  {id:'customerdataconfig',text:'参数设置',href:'<c:url value="/sysmng/properties" />'}
                ]
              },{
                text:'项目管理',
                items:[
                  {id:'orgmng',text:'客户及项目管理',href:'<c:url value="/da/customer/" />'},
                  {id:'labelmng',text:'盘号管理',href:'<c:url value="/da/customer/label" />'}
                ]
              },{
                 text:'数字首页管理',
                 items:[
                   {id:'shouyemng',text:'数字首页',href:'<c:url value="/da/customer/label/shouye" />'}
                 ]
               },{
                  text:'基础配置',
                  items:[
                    {id:'categorymng',text:'病案分类',href:'<c:url value="/da/config/category" />'},
                    {id:'KSmng',text:'科室设置',href:'<c:url value="/da/config/set" />?type=KS'},
                    {id:'GJmng',text:'国籍',href:'<c:url value="/da/config/set" />?type=GJ'},
                    {id:'MZmng',text:'民族',href:'<c:url value="/da/config/set" />?type=MZ'},
                    {id:'ZJmng',text:'证件类型',href:'<c:url value="/da/config/set" />?type=ZJ'},
                    {id:'GXmng',text:'关系设置',href:'<c:url value="/da/config/set" />?type=GX'},
                    {id:'HYmng',text:'婚姻状况',href:'<c:url value="/da/config/set" />?type=HY'},
                    {id:'ZYmng',text:'职业',href:'<c:url value="/da/config/set" />?type=ZY'},
                    {id:'SSmng',text:'省市县地址',href:'<c:url value="/da/config/set" />?type=SS'},
                    {id:'JBmng',text:'疾病编码',href:'<c:url value="/da/config/set" />?type=JB'},
                    {id:'RYTJmng',text:'入院途径',href:'<c:url value="/da/config/set" />?type=RYTJ'},
                    {id:'LYFSmng',text:'离院方式',href:'<c:url value="/da/config/set" />?type=LYFS'},
                    {id:'RYJCmng',text:'入院检查情况',href:'<c:url value="/da/config/set" />?type=RYJC'},
                    {id:'RYBQmng',text:'入院病情',href:'<c:url value="/da/config/set" />?type=RYBQ'},
                    {id:'RYSEXmng',text:'性别',href:'<c:url value="/da/config/set" />?type=SEX'},
                    {id:'YSmng',text:'医生',href:'<c:url value="/da/config/doctors/index" />'}
                  ]
                }]
          }];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>
