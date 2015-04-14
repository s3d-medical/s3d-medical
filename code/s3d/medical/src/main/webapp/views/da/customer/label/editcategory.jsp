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
<title>人工分拣图片</title>
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

</head>

<body oncontextmenu="self.event.returnValue=false" onselectstart="return false">

  <div id="J_Layout">
    <div class="north top-container">
      <div class="top-content clearfix">
        <div class="top-left-content pull-left clearfix">
          <!-- <input type="text" name="" id="search1" class="top-search ui-autocomplete-input" autocomplete="off"><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span> -->
          <div class="tab-container clearfix">
            <div class="btn-group">
              <a hideFocus="true" title="单列展示(1)" href="#" class="btn-tabs btn-tabs-1 btn-group-item btn-group-left"><i></i></a>
              <a hideFocus="true" title="双列对比(2)" href="#" class="btn-tabs btn-tabs-2 btn-group-item btn-group-center"><i></i></a>
              <a hideFocus="true" title="三列对比(3)" href="#" class="btn-tabs btn-tabs-3 btn-group-item btn-group-right"><i></i></a>
            </div>
            <div class="btn-group btn-cmd-group">
              <a hideFocus="true" title="自动大小(c)" href="#" data-cmd="fitToggle" class="btn-group-item btn-group-left">&#xf0005;</a>
              <a hideFocus="true" title="放大(w)" href="#" data-cmd="zoom" class="btn-group-item btn-group-center">&#xf01b9;</a>
              <a hideFocus="true" title="缩小(s)" href="#" data-cmd="micrify" class="btn-group-item btn-group-center">&#xf01b8;</a>
              <a hideFocus="true" title="上一张(a)" href="#" data-cmd="_paintPrev" class="btn-group-item btn-group-center">&#xf016e;</a>
              <a hideFocus="true" title="下一张(d)" href="#" data-cmd="_paintNext" class="btn-group-item btn-group-center">&#xf016d;</a>
              <a hideFocus="true" title="下一批(f)" href="#" class="btn-group-item btn-group-center">&#xf0114;</a>
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
    	<form id="J_Form" action="<c:url value="/da/customer/label/editcategory" />" method="post" class="form-horizontal">
	    	<div>
	    		<input type="hidden" name="fdId" value="${model.fdId}">
	    		<br>
				<div class="control-group">
		        	<label class="control-label">盘号：</label>
					<div class="controls">
		          		<input name="fdLabelName" value="${model.fdName}" type="text" class="input-small">
		        	</div>
		      	</div>
		      	<div class="control-group">
		        	<label class="control-label">光点号：</label>
		        		<div class="controls">
		          			<input name="fdFrom" type="text" class="input-small"> - <input name="fdTo" type="text" class="input-small"> 
		        		</div>
		      	</div>
		      	<div class="control-group">
		        	<label class="control-label">病案号：</label>
					<div class="controls">
		          		<input name="fdFileNo" type="text" class="input-small">
		        	</div>
		      	</div>
		      	<div class="row actions-bar">       
	          	<div class="form-actions span13 offset1">
	            	<button type="button" onclick="reloadStore();" class="button button-primary">查询建档信息</button>
	          	</div>
	      		</div>
			</div>
    	</form>
		
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
        eastWidth: 600, //右边的宽度
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
        cfg.wrapModel = initCookieInfo("wrapModel", 2);
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
    	  	window.categoryShortCutObject.reset();
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
			window.categoryShortCutObject.reset();
			var results = window.mainPicStore.getResult();
			var pressed = o.key; 
			if(pressed=='enter'){
				var grid = window.mainPicGrid;
				if(grid.getSelection().length==1){
					var item = grid.getSelection()[0];
					var changed = false;
					if(! item.fdCategoryId){
						if(window.categoryShortCutObject.lastMatchedCategory!=null){
							item.fdCategoryId = window.categoryShortCutObject.lastMatchedCategory.fdId;
							item.fdCategoryName = window.categoryShortCutObject.lastMatchedCategory.fdName;
							item.needSave = true;
							changed =  true;
						}
					}
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
		params.fdFrom = $('input[name=fdFrom]').val();
		params.fdTo = $('input[name=fdTo]').val();
		params.fdFileNo = $('input[name=fdFileNo]').val();
		params.start = 0;
		params.pageIndex = 0;
		store.load(params);
  }
  function initGirdAndCategory(){
	  	BUI.use(['bui/grid','bui/data'],function(Grid,Data){
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
				url : '<c:url value="/da/customer/picture/listjson" />',
		    	autoLoad : true, //自动加载数据
		    	params : { //配置初始请求的参数
					fdLabelName : $('input[name=fdLabelName]').val(),
					fdFrom : $('input[name=fdFrom]').val(),
					fdTo : $('input[name=fdTo]').val(),
					fdFileNo : $('input[name=fdFileNo]').val()
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
			    tbar: {
					items:[{
	                    xclass:'bar-item-button',
	                    btnCls : 'button button-small button-success',
	                    text:'保存当前页',
	                    handler:function(){
	                    	grid.fire('savegriddata');
						}
	                }]
				},
			    bbar:{
			        pagingBar:true
			    }
			});
			window.mainPicGrid = grid;
			window.mainPicGridOffsetFunc = function(storeResults){
				window.categoryShortCutObject.reset();
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
			grid.on('typeingFileNo',function(ev){
				if(grid.getSelection().length==1){
					var item = grid.getSelection()[0];
					var ele = grid.findElement(item);
					window.setTimeout(function(){
						$('td[data-column-field=fdFileNo]',ele).click();
					},0);
				}
			});
						
			var savegriddata = function(){
				var results = grid.get('store').getResult();
				var needsave = false;
				for(var i=0;i<results.length;i++){
					if(!!results[i].needSave){
						needsave = true;
						break;
					}
				}
				if(needsave){
					var savelist = [];
					for(var i=0;i<results.length;i++){
						if(!!results[i].needSave){
							savelist.push(results[i]);
						}
					}
					$.ajax({
						url: '<c:url value="/da/customer/picture/savejson/" />',
						type:'post',
						dataType : 'json',
						data : { "json" : JSON.stringify(savelist) },
						success:function(data){
							if(data.statusCode=="200"){
								BUI.Message.Show({
							          msg : '已自动保存当前页',
							          icon : 'success',
							          buttons : [],
							          autoHide : true,
							          autoHideDelay : 1000
							        });
							}
						}
					});
				}
			};
			grid.on('savegriddata',savegriddata);
			var pagingbar = grid.get('bbar').get('children')[0];
			pagingbar.on('beforepagechange',function(){
				grid.fire('savegriddata');
			});
		});
		BUI.use(['bui/grid','bui/data'],function(Grid,Data){
			var Grid = Grid.Grid,
			Store = Data.Store;

			var columns = [{
			  title : '快捷键',
			  width : 40,
			  dataIndex :'fdShortcut'          
			},{
			  title : '病案分类',
			  width : 100,
			  dataIndex :'fdName'
			},{
			  title : '分类编码',
			  width : 60,
			  dataIndex :'fdCode'          
			}];

			var store = new Store({
				url : '<c:url value="/da/config/category/listjson" />',
		    	autoLoad : true, //自动加载数据
		    	params : { //配置初始请求的参数
		    	},
		    	pageSize : 100
			});
			
			window.categoryShortCutObject = {
				categories : [],
				keyIndex : 0 ,
				maxPressed : 1,
				minPressed : 1,
				setPictureCategoryByShortcut : function(e,o){
					var pressed = o.key; 
					console.log(pressed + ' pressed! and now KeyIndex is:' + this.keyIndex);
					for(var i=0;i<this.categories.length;i++){
						var hitthis = false;
						if(this.categories[i].fdShortcut.toLowerCase().indexOf(pressed)==(this.keyIndex)){
							if(this.keyIndex>0){
								if(window.categoryGrid.isItemSelected(this.categories[i])){
									window.categoryGrid.setSelected(this.categories[i]);
									hitthis = true;
								}
							}else{
								window.categoryGrid.setSelected(this.categories[i]);
								hitthis = true;
							}
						}
						if(!hitthis){
							window.categoryGrid.clearSelected(this.categories[i]);
						}
					}
					this.keyIndex++;
					if(this.keyIndex>=this.minPressed){
						if(window.categoryGrid.getSelection().length==1){
							this.matched(window.categoryGrid.getSelection()[0]);
						}
					}
					if(this.keyIndex>=this.maxPressed){
						this.reset();
					}
				},
				lastMatchedCategory : null,
				matched : function(category){
					window.mainPicGrid.fire('categoryMatched', this.lastMatchedCategory = category);
				},
				reset : function(){
					this.keyIndex = 0;
					//window.categoryGrid.clearSelection();
				}
			};
			store.on('load',function(ev){
				var results = this.getResult();
				window.categoryShortCutObject.categories=results;
				var arr = [];
				for(var i=0;i<results.length;i++){
					var t = results[i].fdShortcut.toLowerCase().split('');
					if(t.length > window.categoryShortCutObject.maxPressed)window.categoryShortCutObject.maxPressed=t.length;
					arr = arr.concat(t);
				}
				var n={},arr2=[];
				for(var i=0;i<arr.length;i++){
					if(!n[arr[i]]){
						n[arr[i]] = true;
						arr2.push(arr[i]);
					}
				}
				window.key(arr2.join(','), "pic",function(e,o){
					window.categoryShortCutObject.setPictureCategoryByShortcut(e,o);
			    });
			    window.key('space',"pic",function(e,o){
			    	window.mainPicGrid.fire('typeingFileNo');
				});
			    window.key.setScope('pic');
			});
			var grid = new Grid({
				width:'100%',
				render:'#categorylist',
			    columns : columns,
			    multipleSelect : true,
			    loadMask: true, //加载数据时显示屏蔽层
			    store: store
			});
			window.categoryGrid = grid;
			grid.render();
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