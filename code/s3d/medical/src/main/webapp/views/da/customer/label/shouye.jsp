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
				var v =  value+'';
				if(obj.categoryNullCount==0 && obj.fileNoNullCount==0){
					v += '&nbsp;&nbsp;&nbsp;<button type="button" class="grid-command startEditIndexPage button button-small"><i class="icon-caret-right"></i>录入首页</button>';
				}
				return v;
			  }
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
	  title : '未录入的首页数量',
	  width : parseInt($(this).width() * 0.1),
	  dataIndex : 'noFillIndexPageCount',
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
	
	var tree = new TreeGrid({
		render : '#grid',
		store : store,
		checkType: 'custom',
		columns : columns,
		itemStatusFields : {
            red1 : 'noFillIndexPageCount'
		},		
		tbar:tbar	
	});
	tree.on('cellclick',function  (ev) {
		var record = ev.record,
		field = ev.field,
		target = $(ev.domTarget);
		if(target.hasClass('startEditIndexPage')){
			var url = '<c:url value="/da/customer/label/editfileindex" />';
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
			在此你可以对<span class="label label-important"><strong>数字首页</strong></span>进行编辑!
		</p>
		</div>
		
		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
	</div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>