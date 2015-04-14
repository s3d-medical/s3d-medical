<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>
<script>
function user_newUser(){
	$("#modalwindowdiv").window({
		title:"添加用户",
		href:"<c:url value="/sysmng/user/add" />",
		width:600,
	    height:400,
	    modal:true
	});
}

function user_editUser(){
	var row = $('#user_gridviewtable').datagrid('getSelected');
	if(row){
		$("#modalwindowdiv").window({
			title:"编辑用户",
			href:"<c:url value="/sysmng/user/edit/" />" + row.fdId,
			width:600,
		    height:400,
		    modal:true
		});
	}
}

function user_deleteUser(){
	var row = $('#user_gridviewtable').datagrid('getSelected');
	if(row){
		after_deletefromgrid(
			'<c:url value="/sysmng/user/delete/" />'+row.fdId,
			$('#user_gridviewtable'),
			'确认删除?');
	}
}
</script>
<div class="easyui-layout" fit="true" style="height:250px;">
	<div region="north" style="height:32px;border-bottom-width:0">
		<div style="float:left;margin:4px 5px 0 0" >
			<input style="width:300px" id="user_keywordsBox">
		</div>
		<div style="float:right;padding:2px 5px;">
			<a href="#" class="easyui-linkbutton" onclick="user_newUser()" iconCls="icon-add" plain="true">添加</a>
			<a href="#" class="easyui-linkbutton" onclick="user_editUser()" iconCls="icon-edit" plain="true">编辑</a>
			<a href="#" class="easyui-linkbutton" onclick="user_deleteUser()" iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>
	
	<div region="center">
		<table id="user_gridviewtable">
		</table>
		<script>
		$(function(){
			var tbObj = $('#user_gridviewtable');
			var searchObj = $('#user_keywordsBox');
			var jsonObject = <json:object>
				<json:property name="total" value="${vo.totalCount}"/>
				<json:array name="rows" var="item" items="${list}">
					<json:object>
			 		    <json:property name="fdId" value="${item.fdId}"/>
			   			<json:property name="fdName" value="${item.fdName}"/>
			   			<json:property name="fdLoginName" value="${item.fdLoginName}"/>
			   			<json:property name="fdEmail" value="${item.fdEmail}"/>
			   			<json:property name="fdPhone" value="${item.fdPhone}"/>
			   			<json:property name="fdCreateTime" value="${item.fdCreateTime}"/>
			   			<json:property name="fdIsActived" value="${item.fdIsActived}"/>
					</json:object>
				</json:array>
			</json:object>;
			var myoptions={
				columns:[[
					{field:'fdLoginName',title:'用户名',width:"100"},
					{field:'fdName',title:'昵称',width:"100"},					
					{field:'fdEmail',title:'Email',width:"100"},
					{field:'fdPhone',title:'手机号码',width:"120"},
					{field:'fdCreateTime',title:'创建时间',width:"120"},
					{field:'fdIsActived',title:'已激活',width:"120"}
				]]
			};
			<c:import url="../eui/grid.jsp"></c:import>
		});
		</script>
	</div>
</div>
