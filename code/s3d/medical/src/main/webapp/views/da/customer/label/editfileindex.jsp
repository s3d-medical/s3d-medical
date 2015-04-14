<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie,com.s3d.webapps.util.*"%>
<%@ include file="/resources/jsp/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
<title>数字首页录入</title>
<script type="text/javascript">
<%String WEBAPPS_Parameter_Style = request.getParameter("s_css");
if (WEBAPPS_Parameter_Style == null
		|| WEBAPPS_Parameter_Style.equals("")) {
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0)
		for (int i = 0; i < cookies.length; i++)
			if ("WEBAPPS_Style".equals(cookies[i].getName())) {
				WEBAPPS_Parameter_Style = cookies[i].getValue();
				break;
			}
}
if (WEBAPPS_Parameter_Style == null
		|| WEBAPPS_Parameter_Style.equals(""))
	WEBAPPS_Parameter_Style = "default";

if (WEBAPPS_Parameter_Style.toLowerCase().indexOf("script") > 0) {
	WEBAPPS_Parameter_Style = "default";
}
request.setAttribute("WEBAPPS_Parameter_Style",WEBAPPS_Parameter_Style);
String WEBAPPS_Parameter_ContextPath = request.getContextPath()+ "/";
request.setAttribute("WEBAPPS_Parameter_ContextPath", WEBAPPS_Parameter_ContextPath);
String WEBAPPS_Parameter_ResPath = WEBAPPS_Parameter_ContextPath + "resources/";
request.setAttribute("WEBAPPS_Parameter_ResPath",
		WEBAPPS_Parameter_ResPath);
String WEBAPPS_Parameter_StylePath = WEBAPPS_Parameter_ResPath
		+ "style/" + WEBAPPS_Parameter_Style + "/";
request.setAttribute("WEBAPPS_Parameter_StylePath",
		WEBAPPS_Parameter_StylePath);
request.setAttribute("WEBAPPS_Parameter_CurrentUserId", UserUtil
		.getUser().getFdId());%>
var Com_Parameter = {
	ContextPath:"${WEBAPPS_Parameter_ContextPath}",
	ResPath:"${WEBAPPS_Parameter_ResPath}",
	Style:"${WEBAPPS_Parameter_Style}",
	StylePath:"${WEBAPPS_Parameter_StylePath}",
	Lang:"<%=request.getLocale().toString().toLowerCase().replace('_', '-')%>",
	CurrentUserId:"${WEBAPPS_Parameter_CurrentUserId}"
};
</script>
<link rel="shortcut icon" href="${WEBAPPS_Parameter_ContextPath}favicon.ico">
<link href="${WEBAPPS_Parameter_ResPath}bui/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="${WEBAPPS_Parameter_ResPath}bui/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="${WEBAPPS_Parameter_ResPath}imageview/index.css" rel="stylesheet" type="text/css" />
<link href="${WEBAPPS_Parameter_ResPath}css/fm.selectator.jquery.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/base.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}bui/bui.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/seed.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/keymaster.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.ba-resize.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.cookie.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/screenfull.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}imageview/config.js"></script>
<script type="text/javascript" src="${WEBAPPS_Parameter_ResPath}js/fm.selectator.jquery.js"></script>
 <style>
    .bui-stdmod-body{
      overflow-x : hidden;
      overflow-y : auto;
    }
  </style>
</head>

<body onselectstart="return false">

  <div id="J_Layout">
    <div class="north top-container">
      <div class="top-content clearfix">
        <div class="top-left-content pull-left clearfix">
          <!-- <input type="text" name="" id="search1" class="top-search ui-autocomplete-input" autocomplete="off"><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span> -->
          <div class="tab-container clearfix">
            <div class="btn-group btn-cmd-group">
              <a hideFocus="true" title="自动大小(c)" href="#" data-cmd="fitToggle" class="btn-group-item btn-group-left">&#xf0005;</a>
              <a hideFocus="true" title="放大(w)" href="#" data-cmd="zoom" class="btn-group-item btn-group-center">&#xf01b9;</a>
              <a hideFocus="true" title="缩小(s)" href="#" data-cmd="micrify" class="btn-group-item btn-group-center">&#xf01b8;</a>
              <a hideFocus="true" title="上一张(a)" href="#" data-cmd="_paintPrev" class="btn-group-item btn-group-center">&#xf016e;</a>
              <a hideFocus="true" title="下一张(d)" href="#" data-cmd="_paintNext" class="btn-group-item btn-group-center">&#xf016d;</a>
              <a hideFocus="true" title="左旋(q)" href="#" data-cmd="leftHand" class="btn-group-item btn-group-center">&#xf013a;</a>
              <a hideFocus="true" title="右旋(e)" href="#" data-cmd="rightHand" class="btn-group-item btn-group-right">&#xf013b;</a>
            </div>
             <div class="btn-group btn-cmd-group">
              <a hideFocus="true" title="输入病案号(空格)" href="#"  class="btn-group-item btn-group-left">&#xf00be;</a>
              
              <a hideFocus="true" title="确认并进入下一张(回车)" href="#"  class="btn-group-item btn-group-right">&#xf00b2;</a>
            </div>
            
          </div>
        </div>
        <!-- <div class="top-right-content pull-right clearfix">
            <input type="text" name="" id="search1" class="top-search">
        </div> -->
      </div>
    </div>
    <div class="east">
		<!-- <div class="preview-list-wrap" id="preview-list-wrap">
    	</div>  -->
    	<hr/>
    	<div class="row">
	      <div class="span16 doc-content">
	        <form id="J_Form" action="<c:url value="/da/customer/label/editcategory" />" method="post" class="form-horizontal">
	          <div class="row">
	            <div class="control-group span6">
	              <input type="hidden" name="fdId" value="${model.fdId}">
	              	<label class="control-label">盘号：</label>
					<div class="controls">
		          		<input name="fdLabelName" value="${model.fdName}" type="text" class="input-small">
		        	</div>
	            </div>
	            <div class="control-group span6">
	              	<label class="control-label">病案号：</label>
					<div class="controls">
		          		<input name="fdFileNo" type="text" class="input-small">
		        	</div>
	            </div>
	            <div class="form-actions span4">
	            	<button type="button" onclick="reloadStore();" class="button button-primary">查询首页</button>
	          	</div>
	          </div>
	        </form>
	      </div>
	    </div>
	    <hr/>	
     	 <div>
    	 	<table border="0">
    	 	<tr>
    	 	<td width="65%">
    	 		<div id=piclist>
    	 		</div>
    	 	</td>
    	 	<td width="35%">
    	 		<div id="categorylist">
    	 		</div>
    	 	</td>
    	 	</tr>
    	 	</table>
    	 </div>
    </div>
    <div class="center">
      <div id="imgview-wrap">
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-1" id="imgview-content-1"></div>
        </div>
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-2" id="imgview-content-2"></div>
        </div>
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-3" id="imgview-content-3"></div>
        </div>
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-4" id="imgview-content-4"></div>
        </div>
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-5" id="imgview-content-5"></div>
        </div>
        <div class="imgview-content">
          <div class="imgview-content-inner imgview-content-6" id="imgview-content-6"></div>
        </div>
      </div>
      
    </div>
  </div>

  <script>
    BUI.use('js/main',function(Main){
      var cfg = {
        cookieReg: "${WEBAPPS_Parameter_CurrentUserId}FinderCookie", // 替换userName，这样不同帐号会有不同的cookie命名控件
        eastWidth: 800, //右边的宽度
        previewListHeight: 120, // 底下的预览小图的容器高度

        previewTrigger: "hover", //底下预览的触发事件,默认为click
        hoverDelay: 100, //hover的触发delay事件,默认为0

        // 无须修改的配置，为了兼容IE的执行顺序，必须写在页面上初始化。
        tabs: $(".btn-group .btn-tabs"),
        autoInit: true
      }

      // 初始化cookie信息。
      function initCookieInfo(key, defaultValue){
        var cookieKey = key + cfg.cookieReg,
          cookieVal = jQuery.cookie(cookieKey);

        if (cookieVal === null || cookieVal === undefined) {
          var returnValue = defaultValue || 0;
          return returnValue;
        } else {
          if (typeof defaultValue === "number") {
            return Number(cookieVal);
          } else if (typeof defaultValue === "object") {
            return jQuery.parseJSON(cookieVal);
          } else {
            return cookieVal;
          }
        }
      }
      var defaultImg = "<c:url value="/resources/images/hello.png" />";
      function initCookie(){
        cfg.wrapModel = 0;
        cfg.defaultImg = defaultImg;
        cfg.activeImgView = 0;
        cfg.selected = initCookieInfo("selected", 0);
        cfg.imgSrc0 = initCookieInfo("imgSrc0", defaultImg);
        cfg.imgSrc1 = initCookieInfo("imgSrc1", defaultImg);
        cfg.imgSrc2 = initCookieInfo("imgSrc2", defaultImg);
        cfg.imgSrc3 = initCookieInfo("imgSrc3", defaultImg);
        cfg.imgSrc4 = initCookieInfo("imgSrc4", defaultImg);
        cfg.imgSrc5 = initCookieInfo("imgSrc5", defaultImg);
        cfg.imgList = initCookieInfo("imgList", [{src: defaultImg,miniSrc: defaultImg}])
      }
      initCookie();

      // 初始化
      window.mainPicBrowser = new Main(cfg);

      window.mainPicBrowser._paintPrev = function(){
			var results = window.mainPicStore.getResult();
			var result = results[window.mainPicGridIndex-1];
			if(result){
				window.mainPicGridIndex--;
				window.mainPicGridOffsetFunc();
			}else{
				//pre page
				var pagingbar = window.mainPicGrid.get('bbar').get('children')[0];
				if(pagingbar.get('curPage')>1){
					pagingbar.jumpToPage(pagingbar.get('curPage') - 1);
					window.mainPicGridIndex = pagingbar.get('pageSize') - 1;
				}
			}
		};
		window.mainPicBrowser._paintNext = function(e,o,offset){
			var results = window.mainPicStore.getResult();
			var pressed = o.key; 
			if(pressed=='enter'){
				var grid = window.mainPicGrid;
				if(grid.getSelection().length==1){
					var item = grid.getSelection()[0];
					var changed = false;
					if(! item.fdFileNo){
						if(window.lastInputedfdFileNo!=null){
							item.fdFileNo = window.lastInputedfdFileNo
							item.needSave = true;
							changed =  true;
						}
					}
					if(changed) grid.updateItem(item);		
				}
			}
			offset = offset || 1;
			var result = results[window.mainPicGridIndex+offset];
			if(result){
				window.mainPicGridIndex+=offset;
				window.mainPicGridOffsetFunc();
			}else{
				var pagingbar = window.mainPicGrid.get('bbar').get('children')[0];
				if(pagingbar.get('totalPage')>pagingbar.get('curPage')){
					pagingbar.jumpToPage(pagingbar.get('curPage') + 1);
					window.mainPicGridIndex = 0;
				}
			}
		};
		initGirdAndCategory();
    })
  </script>
  
  <script type="text/javascript">
  function reloadStore(){	  
		var store = window.mainPicStore;
		var params = store.get('params');
		params.fdLabelName  = $('input[name=fdLabelName]').val();
		params.fdFileNo = $('input[name=fdFileNo]').val();
		params.start = 0;
		params.pageIndex = 0;
		store.load(params);
  }
  function initGirdAndCategory(){
	  	BUI.use(['bui/grid','bui/data','bui/overlay','bui/mask'],function(Grid,Data,Overlay){
	  		var editing = new Grid.Plugins.CellEditing({
				triggerSelected : true
			});
			editing.on('accept',function(){
				if(!!arguments[0].record.fdFileNo){
					//check fdFileNo
					arguments[0].record.needSave = true;
					window.lastInputedfdFileNo = arguments[0].record.fdFileNo;
					return true;
				}
				return false;
			})
			var Grid = Grid.Grid,
			Store = Data.Store;

			var columns = [{
			  title : '盘号',
			  width : 40,
			  dataIndex :'fdLabelName'          
			},{
			  title : '光点号',
			  width : 60,
			  dataIndex :'fdPicName'
			},{
			  title : '病案分类',
			  width : 100,
			  dataIndex :'fdCategoryName'          
			},{
			  title : '病案号',
			  width : 100,
			  dataIndex :'fdFileNo',
			  editor : {xtype : 'text'}      
			}];

			var store = new Store({
				url : '<c:url value="/da/customer/picture/listjson?isshouyeonly=1" />',
		    	autoLoad : true, //自动加载数据
		    	params : { //配置初始请求的参数
					fdLabelName : $('input[name=fdLabelName]').val(),
					fdFrom : $('input[name=fdFrom]').val(),
					fdTo : $('input[name=fdTo]').val(),
					fdFileNo : $('input[name=fdFileNo]').val(),
		    	},
		    	pageSize : 10
			});
			window.mainPicGridIndex = 0;
			store.on('load',function(e) {
				window.mainPicGridOffsetFunc();
			});
			window.mainPicStore = store;
			
			var grid = new Grid({
				width:'100%',
				render:'#piclist',
			    columns : columns,
			    loadMask: true, //加载数据时显示屏蔽层
			    store: store,
			    plugins : [editing],
			    bbar:{
			        pagingBar:true
			    }
			});
			window.mainPicGrid = grid;
			window.mainPicGridOffsetFunc = function(storeResults){
				storeResults = storeResults || window.mainPicStore.getResult();
				var wrapModel = window.mainPicBrowser.get('wrapModel');
				var imgList = [];
				var max = wrapModel==2?6:2;
				window.mainPicGrid.setSelected(storeResults[window.mainPicGridIndex]);
				for(var i= window.mainPicGridIndex ,n=0;(i<storeResults.length && n<max);i++,n++){
					imgList.push({
						src: '<c:url value="/da/customer/picture/getpicture/" />'+storeResults[i].fdId,
						miniSrc: '<c:url value="/da/customer/picture/getthumb/" />'+storeResults[i].fdId,
						name : storeResults[i].fdPicName
					});
				}
				window.mainPicBrowser.set('imgList', imgList);
			};
			grid.render();
			grid.on('itemsshow',function(ev){
				var results = this.get('store').getResult();
				grid.setSelected(results[window.mainPicGridIndex]);
			});
			grid.on('cellclick',function(ev){
				var record = ev.record;
				var results = this.get('store').getResult();
				var index = results.indexOf(record);
				window.mainPicGridIndex = index;
				window.mainPicGridOffsetFunc(results);
			});
			grid.on('categoryMatched',function(category){
				if(grid.getSelection().length==1){
					var item = grid.getSelection()[0];
					item.fdCategoryId = category.fdId;
					item.fdCategoryName = category.fdName;
					item.needSave = true;
					grid.updateItem(item);
				}
			});
			
			window.key('space',"pic",function(e,o){
		    	window.mainPicGrid.fire('fillIndexPage');
			});
						
			window.key.setScope('pic');
			var dialog = new Overlay.Dialog({
				title:'数字首页录入',
				width:800,
				height:600,
				left: 600,
				align :{
					node: 'div.east'	,
					points: ['cc','cc']	,
					offset: [0, 200]
				},
				buttons:[{
					text:'保存',
					elCls : 'button button-primary',
					handler : function(){
						var frm = $(".bui-stdmod-body form")[0];
						var dataPara = $(frm).serialize();
						var $dialog=this;
					    $.ajax({
					        url: frm.action,
					        type: frm.method,
					        data: dataPara,
					        success: function(){
					        	//
					    		$dialog.close();
					        }
					    });
						
					}
				},{
					text:'关闭',
					elCls : 'button',
					handler : function(){
						this.close();
					}
				}],
				loader : {
					url : '<c:url value="/da/customer/shouye/gethtml" />',
					autoLoad : false, 
					params : {id : ''},
					lazyLoad : false
				},
				mask:false
			});

			grid.on('fillIndexPage',function(ev){
				if(grid.getSelection().length==1){
					var item = grid.getSelection()[0];
					dialog.show();
					window.key.setScope('fill');
				    dialog.get('loader').load({id : item.fdId});
				}
			});
			window.key('escape',"fill",function(e,o){
				dialog.hide();
				window.key.setScope('pic');
			});
			dialog.on('closed',function(){
				window.key.setScope('pic');
			});
		});
	}

  </script>
  <script type="text/javascript">
      BUI.use('bui/form',function(Form){
      	new Form.Form({
        	srcNode : '#J_Form'
    	  }).render();      
	  });  
	</script>
</body>

</html>