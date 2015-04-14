<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/bui_edit_top.jsp"%>
<script type="text/javascript">
$(function(){

	BUI.use(['bui/grid','bui/data'],function(Grid,Data){
		var Grid = Grid.Grid,
		Store = Data.Store;

		var fdStatusEnumObj = {"1":"启用","0":"禁用"};
		var columns = [{
		  title : '病案分类',
		  width : parseInt($(this).width() * 0.2),
		  dataIndex :'fdName'
		},{
		  title : '分类编码',
		  width : parseInt($(this).width() * 0.08),
		  dataIndex :'fdCode'          
		},{
		  title : '快捷键',
		  width : parseInt($(this).width() * 0.08),
		  dataIndex :'fdShortcut'          
		},{
		  title : '状态',
		  width : parseInt($(this).width() * 0.1),
		  dataIndex : 'fdStatus',
		  renderer:BUI.Grid.Format.enumRenderer(fdStatusEnumObj)
		},{
			title : '操作',
			width : parseInt($(this).width() * 0.1),
			dataIndex : 'fdId',
			renderer : function(value,obj){
				var retArr = [];
					var aobj = ['<a href=',' target=_blank><i class="icon-edit" title="编辑"></i></a>'];
					retArr.push(aobj.join('<c:url value="/da/config/category/edit/" />'+value));
					var aobj = ['<a href=',' target=_blank><i class="icon-close" title="删除"></i></a>'];
					retArr.push(aobj.join('<c:url value="/da/config/category/delete/" />'+value));
				return retArr.join('&nbsp;&nbsp;&nbsp;&nbsp;');
			}
		}];

		var tbar = {
	        items:[]
	    };
			
		tbar.items.push({
	        xclass:'bar-item-button',
	        btnCls : 'button button-small',
	        text:'<i class="icon-plus"></i>新建病案分类',
	        handler : function(){
	        	var openurl = '<c:url value="/da/config/category/add" />';
	        	
	        	top.topManager.openPage({
	        		id : 'newcategorypage',
	        		moduleId : 'sysorg',
	        		title : '新建病案分类',
	        		href : openurl,
	        		closeable : true
	            });
	        }
	    });
		/**
		 * 自动发送的数据格式：
		 *  1. start: 开始记录的起始数，如第 20 条,从0开始
		 *  2. limit : 单页多少条记录
		 *  3. pageIndex : 第几页，同start参数重复，可以选择其中一个使用
		 *
		 * 返回的数据格式：
		 *  {
		 *     "rows" : [{},{}], //数据集合
		 *     "results" : 100, //记录总数
		 *     "hasError" : false, //是否存在错误
		 *     "error" : "" // 仅在 hasError : true 时使用
		 *   }
		 * 
		 */
		
		var store = new Store({
			url : '<c:url value="/da/config/category/listjson" />',
	    	autoLoad : true, //自动加载数据
	    	params : { //配置初始请求的参数
	    	},
	    	pageSize : 10
		});
		
		var grid = new Grid({
			render:'#grid',
		    columns : columns,
		    loadMask: true, //加载数据时显示屏蔽层
		    store: store,
		    tbar:tbar,
		    // 底部工具栏
		    bbar:{
		        // pagingBar:表明包含分页栏
		        pagingBar:true
		    }
		});
		grid.render();
	});
		

});
</script>
	<div class="container">
		<div class="well well-small" style="margin-left: 5px; margin-top: 5px">
		<span class="badge badge-info">提示</span>
		<p>
			在此你可以对<span class="label label-important"><strong>病案分类</strong></span>进行编辑!
		</p>
		</div>
		
		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>