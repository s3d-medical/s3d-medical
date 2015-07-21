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
		  title : '手术名称',
		  width : parseInt($(this).width() * 0.2),
		  dataIndex :'name'
		},{
		  title : '手术编码',
		  width : parseInt($(this).width() * 0.08),
		  dataIndex :'code'
		},{
		  title : '快捷键',
		  width : parseInt($(this).width() * 0.08),
		  dataIndex :'shortcut'
		},{
			title : '等级',
			width : parseInt($(this).width() * 0.08),
			dataIndex :'grade'
		},{
		  title : '状态',
		  width : parseInt($(this).width() * 0.1),
		  dataIndex : 'status',
		  renderer:BUI.Grid.Format.enumRenderer(fdStatusEnumObj)
		},{
			title : '操作',
			width : parseInt($(this).width() * 0.1),
			dataIndex : 'id',
			renderer : function(value,obj){
				var retArr = [];
					var aobj = ['<a href=',' target=_blank><i class="icon-edit" title="编辑"></i></a>'];
					retArr.push(aobj.join('<c:url value="/da/config/operations/edit/" />'+value));
					var aobj = ['<a href=',' target=_blank><i class="icon-close" title="删除"></i></a>'];
					retArr.push(aobj.join('<c:url value="/da/config/operations/delete/" />'+value));
				return retArr.join('&nbsp;&nbsp;&nbsp;&nbsp;');
			}
		}];

		var tbar = {
	        items:[]
	    };

		tbar.items.push({
	        xclass:'bar-item-button',
	        btnCls : 'button button-small',
	        text:'<i class="icon-plus"></i>新建手术编码',
	        handler : function(){
	        	var openurl = '<c:url value="/da/config/operations/add" />';

	        	top.topManager.openPage({
	        		id : 'newOperationPage',
	        		moduleId : 'sysorg',
	        		title : '新建手术编码',
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
		/*var store = new Store({
			url : '<c:url value="/da/config/operations" />',
	    	autoLoad : false, //自动加载数据
	    	params : { //配置初始请求的参数
	    	},
	    	pageSize : 10
		});*/

		var store = new Store({
			data: [],
			autoLoad : false,
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

		$.ajax({
			url: Com_Parameter.ContextPath + 'da/config/operations',
			type: 'GET',
			dataType: 'json',
			success: function (resp) {
				store.set('data', resp.operations);
				store.load();
			}
		});
		/*initHospitals();

		$("#hospitals").bind("change", changeHospital);

		function initHospitals () {
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

		function changeHospital () {
			var hospitalId = $("#hospitals").val();
			if (!hospitalId) {
				return;
			}
			$.ajax({
				url: Com_Parameter.ContextPath + 'da/config/doctors?hospitalId=' + hospitalId,
				type: 'GET',
				dataType: 'json',
				success: function (resp) {
					store.set('data', resp.doctors);
					store.load();
				}
			});
		}*/
	});


});
</script>
	<div class="container">
		<div class="well well-small" style="margin-left: 5px; margin-top: 5px">
		<span class="badge badge-info">提示</span>
		<p>
			在此你可以对<span class="label label-important"><strong>手术编码</strong></span>进行编辑!
		</p>
		</div>

		<div class="search-grid-container">
	      <div id="grid"></div>
	    </div>
<%@ include file="/resources/jsp/bui_edit_down.jsp"%>