<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
	<hr>
    <form id="J_Form" action="insert" method="post" class="form-horizontal">
    	
      <div class="control-group">
        <label class="control-label"><s>*</s>分类名称：</label>
        <div class="controls">
          <input name="fdName" type="text" class="input-large" data-rules="{required : true}">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label"><s>*</s>分类编码：</label>
        <div class="controls">
          <input name="fdCode" type="text" class="input-large" data-rules="{required : true}">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label"><s>*</s>快捷键：</label>
        <div class="controls">
          <input name=fdShortcut type="text" class="input-large" data-rules="{required : true}">
        </div>
      </div>
     <div class="control-group">
        <label class="control-label"><s>*</s>状态：</label>
        <div class="controls">
          <label class="radio" for=""><input type="radio" name="fdStatus" value="1" checked="checked">启用</label>&nbsp;&nbsp;&nbsp;
          <label class="radio" for=""><input type="radio" name="fdStatus" value="0">停用</label>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label"><s>*</s>类型：</label>
        <div class="controls">
          <label class="radio" for=""><input type="radio" name="fdType" value="0" checked="checked">其他页</label>&nbsp;&nbsp;&nbsp;
          <label class="radio" for=""><input type="radio" name="fdType" value="1">病案首页</label>&nbsp;&nbsp;&nbsp;
          <label class="radio" for=""><input type="radio" name="fdType" value="9">重复(无效)页</label>
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