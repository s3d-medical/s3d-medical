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
	  title : '盘号',
	  width : parseInt($(this).width() * 0.25),
	  dataIndex :'fdName',
	  renderer : function(value,obj){
		  if(obj.fdOrgType==8){
			  if(obj.fdStatus == 9){
				var v =  value+'&nbsp;&nbsp;&nbsp;<button type="button" class="grid-command startEditCategory button button-small"><i class="icon-caret-right"></i>人工分拣</button>';
				return v;
			  }else if(obj.fdStatus == 0)
				return value+'&nbsp;&nbsp;&nbsp;<button type="button" class="grid-command startScan button button-small"><i class="icon-caret-right"></i>开始扫描</button>';
		  }
		  return value;
		}       
	},{
	  title : '存档日期',
	  width : parseInt($(this).width() * 0.06),
	  dataIndex :'fdCreateTime'          
	},{
	  title : '文件数',
	  width : parseInt($(this).width() * 0.06),
	  dataIndex :'fdFileCount',
	  renderer : function(value,obj){
		if(obj.fdStatus==0){
			return '未知'
		}else if(obj.fdStatus==1){
			return "正在扫描中"
		}
		return value;
		}
	},{
	  title : '最小光点号',
	  width : parseInt($(this).width() * 0.06),
	  dataIndex : 'fdFrom'
	},{
	  title : '最大光点号',
	  width : parseInt($(this).width() * 0.06),
	  dataIndex : 'fdTo'
	},{
	  title : '未识别分类的数量',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex : 'categoryNullCount',
	  renderer : function(value,obj){
		  if(obj.fdStatus != 9){
			return '未知';
		  }
		  return value;
		}
	},{
	  title : '未识别病案号的数量',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex : 'fileNoNullCount',
	  renderer : function(value,obj){
		  if(obj.fdStatus != 9){
			return '未知';
		  }
		  return value;
		}
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
			if(obj.fdOrgType=="8"){
				var aobj = ['<a href=',' target=_blank><i class="icon-edit" title="编辑"></i></a>'];
				retArr.push(aobj.join('<c:url value="/da/customer/label/edit/" />'+value));
			}
			return retArr.join('');
		}
	}];

	var store = new Data.TreeStore({
		url : '<c:url value="/da/customer/hospital/listchildrenjson?orgType=11" />',
		autoLoad : true
    });
	
	var tbar = {
        items:[]
    };
		
	tbar.items.push({
        xclass:'bar-item-button',
        btnCls : 'button button-small',
        text:'<i class="icon-plus"></i>新建盘号',
        handler : function(){
        	var openurl = '<c:url value="/da/customer/label/add" />';
        	var selections = tree.getSelection();
        	var parentId = null;
        	if(selections && selections.length==1){
            	if(selections[0].fdOrgType==2){
            		parentId = selections[0].fdId; 
            	}
        	}
        	if(! parentId){
            	alert('必须先选择一个项目,然后在项目下面创建盘号');
            	return;
        	}
        	openurl = $b.SetUrlParameter(openurl, "parent", parentId);
        	top.topManager.openPage({
        		id : 'newlabelpage',
        		moduleId : 'sysorg',
        		title : '新建盘号',
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
		itemStatusFields : {
            red1 : 'categoryNullCount',
            red2 : 'fileNoNullCount'
		},		
		tbar:tbar	
	});
	tree.on('cellclick',function  (ev) {
		var record = ev.record,
		field = ev.field,
		target = $(ev.domTarget);
		if(target.hasClass('startScan')){
			if(confirm('扫描文件需要的时间比较长,请确认是否继续?')){
				var scanurl = '<c:url value="/da/customer/label/scanpicture" />';
				scanurl+='?id='+record.fdId;
				$.getJSON(scanurl,function(result){
					BUI.Message.Alert(result.message,'warning');
				});
				//TODO
				//record.fdId
			}
		}else if(target.hasClass('startEditCategory')){
			var url = '<c:url value="/da/customer/label/editcategory" />';
			url+='/'+record.fdId;
			window.open(url,'_blank');
		}else if(target.hasClass('startEditIndexPage')){
			var url = '<c:url value="/da/customer/label/editFileIndex" />';
			url+='/'+record.fdId;
			window.open(url,'_blank');
		}
    });
     
	tree.render();      
  });
</script>
	<div class="container">
		<div class="well well-small" style="margin-left: 5px; margin-top: 5px">
		<span class="badge badge-info">提示</span>
		<p>
			在此你可以对<span class="label label-important"><strong>盘号</strong></span>进行编辑!
		</p>
		</div>
		
		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
	</div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>