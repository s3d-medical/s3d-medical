<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
<script type="text/javascript">
BUI.use(['bui/extensions/treegrid','bui/data'],function (TreeGrid,Data) {
	var fdIsBusinessEnumObj = {"true":"是","false":"否"};
	var columns = [{
	  title : '名称',
	  width : 500,
	  dataIndex :'fdName'          
	},{
	  title : '编码',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex :'fdCode'
	},{
	  title : '描述',
	  width : parseInt($(this).width() * 0.2),
	  dataIndex : 'fdDescription'
	},{
	  title : '创建时间',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex :'docCreateTime'          
	},{
		title : '操作',
		width : parseInt($(this).width() * 0.1),
		dataIndex : 'fdId',
		renderer : function(value,obj){
			var aobj = ['<a href=',' target=_blank><i class="icon-edit" title="编辑"></i></a>'];
			if(obj.fdOrgType=="1"){
				return aobj.join('<c:url value="/da/customer/hospital/edit/" />'+value);
			}else if(obj.fdOrgType=="2"){
				return aobj.join('<c:url value="/da/customer/project/edit/" />'+value);
			}
			return "";
		}
	}];

	var store = new Data.TreeStore({
		url : '<c:url value="/da/customer/hospital/listchildrenjson" />',
		autoLoad : true
    });
	
	var tbar = {
        items:[]
    };
		
	tbar.items.push({
        xclass:'bar-item-button',
        btnCls : 'button button-small',
        text:'<i class="icon-plus"></i>新建客户',
        handler : function(){
        	var openurl = '<c:url value="/da/customer/hospital/add" />';
        	var selections = tree.getSelection();
        	if(selections && selections.length==1){
				openurl = $b.SetUrlParameter(openurl, "parent", selections[0].fdId);
        	}
        	top.topManager.openPage({
        		id : 'newhospitalpage',
        		moduleId : 'sysorg',
        		title : '新建客户',
        		href : openurl,
        		closeable : true
            });
        }
    });
    
	tbar.items.push({
        xclass:'bar-item-button',
        btnCls : 'button button-small',
        text:'<i class="icon-plus"></i>新建项目',
        handler : function(){
        	var openurl = '<c:url value="/da/customer/project/add" />';
        	var selections = tree.getSelection();
        	if(selections && selections.length==1){
				openurl = $b.SetUrlParameter(openurl, "parent", selections[0].fdId);
        	}
        	top.topManager.openPage({
        		id : 'newprojectpage',
        		moduleId : 'sysorg',
        		title : '新建项目',
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
	
	tree.render();      
  });
</script>
	<div class="container">
		<div class="well well-small" style="margin-left: 5px; margin-top: 5px">
		<span class="badge badge-info">提示</span>
		<p>
			在此你可以对<span class="label label-important"><strong>客户和项目</strong></span>进行编辑!
		</p>
		</div>
		
		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
	</div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>