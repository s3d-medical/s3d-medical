<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common.jsp"%>
<form id="pagerForm" method="post" action='<c:url value="/sysmng/user/edit/${vo.fdId}" />'>
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
<form method="post" action='<c:url value="/sysmng/user/updatepwd?navTabId=userLiNav" />' class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="fdId" value="${vo.fdId}"/>
	<div class="pageFormContent" layoutH="57">
		<p>
			<label>用户名: </label>
			<input type="text" name="fdLoginName" value="${vo.fdLoginName}" readonly="readonly"/>
		</p>
		<p>
			<label>昵称: </label>
			<input type="text" name="fdName" value="${vo.fdName}" readonly="readonly" />
		</p>
		
		<p>
			<label>输入密码: </label>
			<input type="text" name="fdPassword" value="" class="required" maxlength="30"/>
		</p>
		<p>
			<label>确认密码: </label>
			<input type="text" name="fdConfirmPassword" value="" class="required" maxlength="30"/>
		</p>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>