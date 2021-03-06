<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
	<hr>
    <form id="J_Form" action="insert" method="post" class="form-horizontal">
    	<input type="hidden" name="fdParentId" value="${param.parent}">
      <div class="control-group">
        <label class="control-label">项目名称：</label>
        <div class="controls">
          <span class="x-form-text">${parent.fdName}</span>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label"><s>*</s>名称：</label>
        <div class="controls">
          <input name="fdName" type="text" class="input-large" data-rules="{required : true}">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label"><s>*</s>存档日期：</label>
        <div class="controls">
          <input name="fdCreateTime" type="text" class="calendar" data-rules="{required:true}">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">描述：</label>
        <div class="controls">
          <textarea name="fdDescription" class="input-large" type="text"></textarea>
        </div>
      </div>
		<br>
      <div class="row actions-bar">       
          <div class="form-actions span13 offset3">
            <button type="submit" class="button button-primary">保存</button>
            <button type="reset" class="button">重置</button>
          </div>
      </div>       
    </form>

    <script type="text/javascript">
      BUI.use('bui/form',function(Form){
      	new Form.Form({
        	srcNode : '#J_Form'
    	  }).render();      
	  });  
      
	</script>
	
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>