<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>

<div class="easyui-layout" fit="true" style="height:250px;">
	<div region="north" style="height:32px;border-bottom-width:0">
		<div style="float:left;margin:4px 5px 0 0">
			<input style="width:300px" id="role_keywordsBox">
		</div>
		<div style="float:right;padding:2px 5px;">
			<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save',toggle:true">Save</a>
			<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'">Print</a>
		</div>
	</div>
	
	<div region="center">
		<table id="role_gridviewtable">
		</table>
		<script>
		$(function(){
			var tbObj = $('#role_gridviewtable');
			var searchObj = $('#role_keywordsBox');
			var jsonObject = <json:object>
				<json:property name="total" value="${vo.totalCount}"/>
				<json:array name="rows" var="item" items="${list}">
						<json:object>
				 		    <json:property name="fdId" value="${item.fdId}"/>
				   			<json:property name="fdName" value="${item.fdName}"/>
				   			<json:property name="fdDescription" value="${item.fdDescription}"/>
						</json:object>
				</json:array>
			</json:object>;
			var myoptions={
				columns:[[
					{field:'fdName',title:'角色名',width:"200"},
					{field:'fdDescription',title:'说明',width:"300"}
				]]
			};
			<c:import url="../eui/grid.jsp"></c:import>
		});
		</script>
	</div>
</div>
