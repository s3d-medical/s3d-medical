<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/resources/jsp/bui_edit_top.jsp" %>
<hr>
<form id="J_Form" action="" method="post" class="form-horizontal">
    <%--<input name="fdType"  type="hidden" value="${fdType}">--%>

    <div class="control-group">
        <label class="control-label"><s>*</s>手术名称：</label>
        <div class="controls">
            <input name="name" type="text" class="input-large" data-rules="{required : true}">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"><s>*</s>手术编码：</label>
        <div class="controls">
            <input name="code" type="text" class="input-large" data-rules="{required : true}">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"><s>*</s>手术等级：</label>
        <div class="controls">
            <select name="grade" data-rules="{required : true}">
                <option value="">--请选择--</option>
                <option value="1">一级</option>
                <option value="2">二级</option>
                <option value="3">三级</option>
                <option value="4">四级</option>
            </select>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"><s>*</s>快捷键：</label>
        <div class="controls">
            <input name=shortcut type="text" class="input-large" data-rules="{required : true}">
        </div>
    </div>
    <%--<div class="control-group">
        <label class="control-label"><s></s>客户/项目：</label>
        <div class="controls">
            <input name=fdExclusive type="text" class="input-large" data-rules="{required : false}" readonly> &nbsp;&nbsp;&nbsp;<font
                color=blue> 说明: 此处如果为空，表示此配置对所有客户都通用。</font>
        </div>
    </div>--%>
    <div class="control-group">
        <label class="control-label"><s>*</s>状态：</label>

        <div class="controls">
            <label class="radio" for=""><input type="radio" name="status" value="1" checked="checked">启用</label>&nbsp;&nbsp;&nbsp;
            <label class="radio" for=""><input type="radio" name="status" value="0">停用</label>
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
    /*function initHospitals () {
        $.ajax({
            url: Com_Parameter.ContextPath + 'da/customer/hospital/listchildrenjson',
            type: 'GET',
            dataType: 'json',
            success: function (resp) {
                $.each(resp, function (index, item) {
                    $("#hospitals").append("<option value='" + item.id + "'>" + item.fdName + "</option>");
                })
            }
        })
    }

    initHospitals();*/

    BUI.use('bui/form', function (Form) {
        new Form.Form({
            srcNode: '#J_Form'
        }).render();
    });

</script>

<%@ include file="/resources/jsp/bui_edit_down.jsp" %>