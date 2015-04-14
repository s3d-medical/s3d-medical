<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>
<script>
function user_updateUser(){
	 $('#user_editform').form('submit',{
         url: '<c:url value="/sysmng/user/update" />',
         onSubmit: function(){
             return $(this).form('validate');
         },
         success: function(result){
        	 after_modalwindow_opt(result,$('#user_gridviewtable'));
         }
     });
}
$(function(){
	$('#user_editform').form();
})
</script>
<style type="text/css">
#user_editform{
	margin:0;
	padding:10px 30px;
}
</style>
<div style="margin:10px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="user_updateUser()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#modalwindowdiv').dialog('close')">关闭</a>
 </div>
<div class="ftitle">用户信息</div>
<form method="post" id="user_editform">
	<input type="hidden" name="fdId" value="${vo.fdId}"/>
     <div class="fitem">
         <label>用户名:</label>
         <input type="text" name="fdLoginName" value="${vo.fdLoginName}" readonly="readonly"/>
     </div>
     <div class="fitem">
         <label>密码:</label>
         <input type="text" name="fdPassword" value="${vo.fdPassword}" class="easyui-validatebox" required="true" />
     </div>
     <div class="fitem">
         <label>昵称:</label>
         <input type="text" name="fdName" value="${vo.fdName}" class="easyui-validatebox" required="true" />
     </div>
     <div class="fitem">
         <label>性别:</label>
         <select name="fdGender" class="easyui-combobox">
			<c:forEach var="item" items="${genderList}">
				<option value="${item.code}" ${item.code eq vo.fdGender ? 'selected="selected"' : ''}>${item.desc}</option>
			</c:forEach>
		</select>
     </div>
     <div class="fitem">
         <label>Email:</label>
         <input type="text" name="fdEmail" value="${vo.fdEmail}" class="easyui-validatebox" data-options="required:true,validType:'email'" />
     </div>
      <div class="fitem">
         <label>电话:</label>
         <input type="text" name="fdPhone" value="${vo.fdPhone}"/>
     </div>
 </form>
