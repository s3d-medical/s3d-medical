<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
	<hr>
    <form id="J_Form" action="save" method="post" class="form-horizontal">
      <div class="control-group">
        <label class="control-label"><s>*</s>服务器图片目录：</label>
        <div class="controls">
          <input name="p_datafilepath" type="text" value="${p_datafilepath}" class="input-large"  data-rules="{required : true}">
        </div>
      </div>
      
		<br>
      <div class="row actions-bar">       
          <div class="form-actions span13 offset3">
            <button type="submit" class="button button-primary">保存</button>
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