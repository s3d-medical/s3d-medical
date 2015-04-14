<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
	<hr>
    <form id="J_Form" action="<c:url value="/da/customer/shytemplate/update" />" method="post" class="form-horizontal">
    <input type="hidden" name="fdId" value="${model.fdId}">
    <input type="hidden" name="fdDesignerHtml" value="${model.fdDesignerHtml}">
    <input type="hidden" name="fdCharHTML" value="">
    <input type="hidden" name="fdCharXML" value="">
      <div class="control-group">
        <label class="control-label"><s>*</s>名称：</label>
        <div class="controls">
          <span class="x-form-text">${model.fdName}</span>
        </div>
      </div>
      <div class="control-group">
      <iframe id=if_xform  src="<c:url value="/resources/eform/designer/designPanel.jsp?contentField=CharHTMLDIV&xmlField=CharXMLDIV&formTemplateTd=iframetd&fdKey=ShyTemplate&tid=${model.fdId}" />" width="98%" height="100%" scrolling="yes"></iframe>
      </div>
		<br>
      <div class="row actions-bar">       
          <div class="form-actions span13 offset3">
            <button type="button" onclick="submitForm();" class="button button-primary">保存</button>
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
	<script type="text/javascript">
	function submitForm(){
		saveXFormHTML(function(){
			document.forms[0].submit();
		});	
	}
	function saveXFormHTML(afterSaveXformAction){
		var customIframe = window.frames['if_xform'];
		if(customIframe.contentWindow.Designer != null && customIframe.contentWindow.Designer.instance != null){
			var instance = customIframe.contentWindow.Designer.instance;
			$('input[name="fdCharHTML"]')[0].value = instance.getHTML();
			$('input[name="fdCharXML"]')[0].value = instance.getXML();		
		}
		if(afterSaveXformAction) afterSaveXformAction.call(window); 
	}
	</script>
	
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>