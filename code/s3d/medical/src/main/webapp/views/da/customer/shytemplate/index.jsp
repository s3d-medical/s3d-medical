<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
<style>
.bui-grid-row-red1{
    color: red;
}
.bui-grid-row-red2{
    color: red;
}
</style>
<script type="text/javascript">
BUI.use(['bui/extensions/treegrid','bui/data'],function (TreeGrid,Data) {
	var fdIsBusinessEnumObj = {"true":"是","false":"否"};
	var columns = [{
	  title : '首页模版',
	  width : parseInt($(this).width() * 0.3),
	  dataIndex :'fdName',
	  renderer : function(value,obj){
		  
		  return value;
		}       
	},{
	  title : '创建时间',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex :'fdCreateTime'          
	},{
	  title : '备注',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex : 'fdDescription'
	},{
		title : '操作',
		width : parseInt($(this).width() * 0.1),
		dataIndex : 'fdId',
		renderer : function(value,obj){
			var retArr = [];
			if(obj.fdOrgType=="4"){
				var aobj = ['<a href=',' target=_blank><i class="icon-edit" title="编辑"></i></a>'];
				retArr.push(aobj.join('<c:url value="/da/customer/shytemplate/edit/" />'+value));
			}
			return retArr.join('');
		}
	}];

	var store = new Data.TreeStore({
		url : '<c:url value="/da/customer/hospital/listchildrenjson?orgType=4" />',
		autoLoad : true
    });
	
	var tbar = {
        items:[]
    };
		
	tbar.items.push({
        xclass:'bar-item-button',
        btnCls : 'button button-small',
        text:'<i class="icon-plus"></i>新建首页模版',
        handler : function(){
        	var openurl = '<c:url value="/da/customer/shytemplate/add" />';
        	var selections = tree.getSelection();
        	var parentId = null;
        	if(selections && selections.length==1){
            	if(selections[0].fdOrgType==2){
            		parentId = selections[0].fdId; 
            	}
        	}
        	if(! parentId){
            	alert('必须先选择一个项目,然后在项目下面创建首页模版');
            	return;
        	}
        	openurl = $b.SetUrlParameter(openurl, "parent", parentId);
        	top.topManager.openPage({
        		id : 'newlabelpage',
        		moduleId : 'sysorg',
        		title : '新建首页模版',
        		href : openurl,
        		closeable : true
            });
        }
    });
    
	
	var tree = new TreeGrid({
		render : '#grid',
		store : store,
		checkType: 'custom',
		columns : columns,		
		tbar:tbar	
	});
	tree.on('cellclick',function  (ev) {
		var record = ev.record,
		field = ev.field,
		target = $(ev.domTarget);
		if(target.hasClass('startScan')){
			
		}
    });
     
	tree.render();      
  });
</script>
	<div class="container">
		<div class="well well-small" style="margin-left: 5px; margin-top: 5px">
		<span class="badge badge-info">提示</span>
		<p>
			在此你可以对<span class="label label-important"><strong>首页模版</strong></span>进行编辑!
		</p>
		</div>
		
		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
	</div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>