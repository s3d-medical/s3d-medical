var ORG_TYPE_ORG = 0x1;															//机构
var ORG_TYPE_DEPT = 0x2;														//部门
var ORG_TYPE_POST = 0x4;													//岗位
var ORG_TYPE_PERSON = 0x8;														//个人
var ORG_TYPE_GROUP = 0x10;														//群组
var ORG_TYPE_ROLE = 0x20;		
var ORG_TYPE_ORGORDEPT = ORG_TYPE_ORG | ORG_TYPE_DEPT;							//机构或部门
var ORG_TYPE_POSTORPERSON = ORG_TYPE_POST | ORG_TYPE_PERSON;					//岗位或个人
var ORG_TYPE_ALLORG = ORG_TYPE_ORGORDEPT | ORG_TYPE_POSTORPERSON;				//所有组织架构类型
var ORG_TYPE_ALL = ORG_TYPE_ALLORG | ORG_TYPE_GROUP;							//所有组织架构类型+群组
var ORG_FLAG_AVAILABLEYES = 0x100;												//有效标记
var ORG_FLAG_AVAILABLENO = 0x200;												//无效标记
var ORG_FLAG_AVAILABLEALL = ORG_FLAG_AVAILABLEYES | ORG_FLAG_AVAILABLENO;		//包含有效和无效标记
var ORG_FLAG_BUSINESSYES = 0x400;												//业务标记
var ORG_FLAG_BUSINESSNO = 0x800;												//非业务标记
var ORG_FLAG_BUSINESSALL = ORG_FLAG_BUSINESSYES | ORG_FLAG_BUSINESSNO;			//包含业务和非业务标记
var __CurStyle = "default";
var $b=window.$b==null?
$.extend({},
{
	ContextPath : "",
	jspath : "resources/js",
	Style : __CurStyle,
	Lang: window.navigator.userLanguage||navigator.language,
	CurrentUserId:"",
	IE:$.browser.msie,
	event : {"submit":[],"confirm":[],"object":[]},
	Loaded : false
}
,((typeof Com_Parameter=='undefined')?{}:Com_Parameter)||{}):window.$b;
$.extend($b,{
	jsonDataBasePath : $b.ContextPath + "sys/common/datajson.jsp?s_bean=",
	CloseWindow:function(){
		if($b.CloseInfo!=null)
			if(!confirm($b.CloseInfo))
				return;
		try{
			var win = window;
			for(var frameWin = win.parent; frameWin!=null && frameWin!=win; frameWin=win.parent){
				if(frameWin["Frame_CloseWindow"]!=null){
					frameWin["Frame_CloseWindow"](win);
					return;
				}
				win = frameWin;
			}
		}catch(e){}
		try{
			top.opener = top;
			top.open("", "_self");
			top.close();
		}catch(e){}
	},
	SetWindowTitle:function(Title){
		try{
			document.title = Title;
		}catch(err){
		}
	},
	HtmlEscape:function(s){
		if(s==null || s=="")
			return "";
		var re = /&/g;
		s = s.replace(re, "&amp;");
		re = /\"/g;
		s = s.replace(re, "&quot;");
		re = /'/g;
		s = s.replace(re, '&#39;');
		re = /</g;
		s = s.replace(re, "&lt;");
		re = />/g;
		return s.replace(re, "&gt;");
	},
	CreateXmlDocument:function(){
		var doc=null;
		if(document.implementation&&document.implementation.createDocument){
			doc=document.implementation.createDocument('','',null);
		}else if(window.ActiveXObject){
			doc=new ActiveXObject('Microsoft.XMLDOM');
		}return doc;
	},
	IsNumeric:function(str){
		return str!=null&&(str.length==null||(str.length>0&&str.indexOf('0x')<0)&&str.indexOf('0X')<0)&&!isNaN(str);
	},
	GetFunctionName:function(f){
		var str=null;
		if(f!=null){
			if(f.name!=null){
				str=f.name;
			}else{
	 			var tmp=f.toString();
 				var idx1=9;
				while(tmp.charAt(idx1)==' '){
					idx1++;
				}
				var idx2=tmp.indexOf('(',idx1);
 				str=tmp.substring(idx1,idx2);
			} 
		}
		return str;
	},
	Submit:function(formObj,method, clearParameter){
		if (!bCancel){
			if(formObj.onsubmit!=null && !formObj.onsubmit()){
				return false;
			}
			var funct=function(o){
				var ret=true;
				for(var i=0; i<o.length; i++){				
					try{
						ret=o[i]();
					}catch(e){
						if(e.number== -2146823277)ret=true;
					}
					if(!ret)
						return false;
				}
				return ret;
			};
			if(!funct($b.event["submit"]) || !funct($b.event["confirm"]))
				return false;
		}
		
		var i;
		var url = $b.CopyParameter(formObj.action);
		if(clearParameter!=null){
			clearParameter = clearParameter.split(":");
			for(i=0; i<clearParameter.length; i++)
				url = $b.SetUrlParameter(url, clearParameter[i], null);
		}
		if(method!=null)
			url = $b.SetUrlParameter(url, "method", method);
		var seq = parseInt($b.GetUrlParameter(url, "s_seq"));
		seq = isNaN(seq)?1:seq+1;
		url = $b.SetUrlParameter(url, "s_seq", seq);
		formObj.action = url;
		var btns = document.getElementsByTagName("INPUT");
		for(i=0; i<btns.length; i++)
			if(btns[i].type=="button" || btns[i].type=="image")
				btns[i].disabled = true;
		btns = document.getElementsByTagName("A");
		for(i=0; i<btns.length; i++){
			btns[i].disabled = true;
			btns[i].removeAttribute("href");
			btns[i].onclick = null;
			for (var j=0; j<btns[i].childNodes.length; j++){
				if(btns[i].childNodes[j].nodeType == 1) {
					btns[i].childNodes[j].disabled = true;
				}
			}
		}
		formObj.submit();
		return true;
	},
	OpenWindow:function(url, target, winStyle, keepUrl){
		if(target!=null){
			if(typeof target=='string'){
				if(document.getElementById(target)!=null){
					var targetPanel=document.getElementById(target);
					if($(targetPanel).hasClass('easyui-tabs')){
						var tabName=$b.GetUrlParameter(url,"Path");
						return $b.mainPanelAddTab(targetPanel,tabName,url);/*mainPanelAddTab在业务模块中定义*/
					}
				}
			}
		}
		if(!keepUrl){
			if($b.IsAutoTransferPara)
				url = $b.CopyParameter(url, new Array("forward", "s_path"));
			if(!(url.indexOf("https://")==0 || url.indexOf("http://")==0)){
				url = $b.SetUrlParameter(url, "s_css", $b.Style);
			}
		}
		var eventObj = $b.GetEventObject();
		if(eventObj!=null && eventObj.shiftKey==true){
			target = "_blank";
			document.selection.empty();
		}
		if(target=="1" || target=="2" || target=="3" || target=="4")
			target = parseInt(target);
		if(target==null || target=="" || target==1 || target==2 || target==3 || target==4){
			var win = $b.RunMainFrameFunc("Frame_OpenWindow", url, target, winStyle);
			if(win==null) {
				target = $b.GetUrlParameter(location.href, "s_target");
				if(target==null)
					target = "_blank";
				win = window.open(url, target);
			}
			return win;
		}else{
			if(winStyle==null || winStyle=="")
				return window.open(url, target);
			else
				return window.open(url, target, winStyle);
		}
	},
	CopyParameter:function(url, except){
		if(location.search=="")
			return url;
		var paraList = location.search.substring(1).split("&");
		var i, j, k, para, value;
		copyParameterOutLoop:
		for(i=0; i<paraList.length; i++){
			j = paraList[i].indexOf("=");
			if(j==-1)
				continue;
			para = paraList[i].substring(0, j);
			if(except!=null){
				if(except[0]!=null){
					for(k=0; k<except.length; k++)
						if(para==except[k])
							continue copyParameterOutLoop;
				}else if(para==except){
					continue;
				}
			}
			value = $b.GetUrlParameter(url, para);
			if(value==null)
				url = $b.SetUrlParameter(url, para, decodeURIComponent(paraList[i].substring(j+1)));
		}
		return url;
	},
	GetUrlParameter:function(url, param){
		var re = new RegExp();
		re.compile("[\\?&]"+param+"=([^&]*)", "i");
		var arr = re.exec(url);
		if(arr==null)
			return null;
		else
			return decodeURIComponent(arr[1]);
	},
	SetUrlParameter:function(url, param, value){
		var re = new RegExp();
		re.compile("([\\?&]"+param+"=)[^&]*", "i");
		if(value==null){
			if(re.test(url)){
				url = url.replace(re, "");
			}
		}else{
			value = encodeURIComponent(value);
			if(re.test(url)){
				url = url.replace(re, "$1"+value);
			}else{
				url += (url.indexOf("?")==-1?"?":"&") + param + "=" + value;
			}
		}
		if(url.charAt(url.length-1)=="?")
			url = url.substring(0, url.length-1);
		return url;
	},
	SetOuterHTML:function(obj, htmlCode){
		if($b.IE){
			obj.outerHTML = htmlCode;
		}else{
			if(htmlCode==""){
				try{
					obj.parentNode.removeChild(obj);
				}catch(e){}
			}else{
				var r = obj.ownerDocument.createRange();
				r.setStartBefore(obj);
				var df = r.createContextualFragment(htmlCode);
				obj.parentNode.replaceChild(df, obj);
			}
		}
		return htmlCode;
	},
	GetEventObject:function(){
		if($b.IE) 
	 		return window.event;
	  	func=$b.GetEventObject.caller;
	    while(func!=null){
			var arg0=func.arguments[0];
			if(arg0){
				if(	(arg0.constructor == Event || arg0.constructor == MouseEvent || arg0.constructor == KeyboardEvent) 
					|| (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)
					){
					return arg0;
				}
			}
			func=func.caller;
		}
		return null;
	},
	GetEventSource:function(evt){
		return(evt.srcElement!=null)?evt.srcElement:evt.target;
	},
	ReplaceParameter:function(str, obj){
		var re = new RegExp("!\\{([^\(\)]+?)\\}");
		for(var arr=re.exec(str); arr!=null; arr=re.exec(str)){
			var value = eval("obj."+arr[1]);
			str = RegExp.leftContext+(value==null?"":encodeURIComponent(value))+RegExp.rightContext;
		}
		return str;
	},
	EventPreventDefault:function(event){
		var eventObj = event||$b.GetEventObject();
		if(eventObj!=null){
			if($b.IE)
				eventObj.returnValue = false;
			else
				eventObj.preventDefault();
		}
	},
	ConsumeEvent:function(evt,preventDefault){
		if(preventDefault==null||preventDefault){
			if(evt.preventDefault){
				evt.stopPropagation();
				evt.preventDefault();
			}else{
				evt.cancelBubble=true;
			} 
		}
		evt.isConsumed=true;
		evt.returnValue=false;
	},
	RunMainFrameFunc:function(funcName, arg1, arg2, arg3, arg4){
		try{
			var win = window;
			for(var frameWin = win.parent; frameWin!=null && frameWin!=win; frameWin=win.parent){
				if(frameWin[funcName]!=null)
					return frameWin[funcName](win, arg1, arg2, arg3, arg4);
				win = frameWin;
			}
		}catch(e){}
		return null;
	},
	AddEventListener:function(){
		var updateListenerList=function(element,eventName,funct){
			if(element.ListenerList==null){
				element.ListenerList=[];
				$b.event.object.push(element);
			}
			var entry={
				name:eventName,f:funct
			};
	 		element.ListenerList.push(entry);
		};
		if($b.IE){
			return function(element,eventName,funct){
				element.attachEvent("on"+eventName,funct);
 				updateListenerList(element,eventName,funct);
			};
		}else{
			return function(element,eventName,funct){
				element.addEventListener(eventName,funct,false);
				updateListenerList(element,eventName,funct);
			};
		} 
	}(),
	RemoveEventListener:function(){
		var updateListener=function(element,eventName,funct){
			if(element.ListenerList!=null){
				var listenerCount=element.ListenerList.length;
				for(var i=0;i<listenerCount;i++){
					var entry=element.ListenerList[i];
					if(entry.f==funct){
						element.ListenerList.splice(i,1);
						break;
					}
				}
				if(element.ListenerList.length==0)
		 			element.ListenerList=null;
			} 
		};
 		if($b.IE){
	 		return function(element,eventName,funct){
				element.detachEvent("on"+eventName,funct);
				updateListener(element,eventName,funct);
			};
		}else{
			return function(element,eventName,funct){
				element.removeEventListener(eventName,funct,false);
				updateListener(element,eventName,funct);
			};
		} 
	}(),
	RemoveAllListeners:function(element){
		var list=element.ListenerList;
 		if(list!=null){
			while(list.length>0){
				var entry=list[0];
				$b.RemoveEventListener(element,entry.name,entry.f);
			} 
		} 
	},
	ReleaseEvent:function(element){
		if(element!=null){
			$b.RemoveAllListeners(element);
			var children=element.childNodes;
			if(children!=null){
				var childCount=children.length;
				for(var i=0;i<childCount;i+=1)
					$b.ReleaseEvent(children[i]);
			} 
		} 
	},
	AddMouseWheelListener:function(funct){
		if(funct!=null){
			var wheelHandler=function(evt){
				if(evt==null){
					evt=window.event;
				}
				var delta=0;
 				if($b.IE){
					delta=evt.wheelDelta/120;
				}else{
					delta=-evt.detail/2;
				}
				if(delta!=0){
					funct(evt,delta>0);
				} 
			};
 			if($b.IE){
				$b.AddEventListener(document,'mousewheel',wheelHandler);
			}else{
				$b.AddEventListener(window,'DOMMouseScroll',wheelHandler);
			} 
		}		
	},
	DisableContextMenu:function(){
		if($b.IE){
			return function(element){
				$b.AddEventListener(element,'contextmenu',function(){
	 				return false;
				});
			};
		}else{
	 		return function(element){
	 			element.setAttribute('oncontextmenu','return false;');
			};
		}
	}(),
	LoadIframe:function(o){
		var iframe = o.getElementsByTagName("IFRAME")[0];
		if(iframe.src==""){
			iframe.src = iframe.fetch;
		}
	},
	getCurrentStyle:function(){
		if($b.IE){
			return function(element){
				return(element!=null)?element.currentStyle:null;
			};
		}else{
			return function(element){
				return(element!=null)?window.getComputedStyle(element,''):null;
			};
		} 
	},
	hasScrollbars:function(node){
		var style=$b.getCurrentStyle(node);
		return style!=null&&(style.overflow=='scroll'||style.overflow=='auto');
	},
	bind:function(scope,funct){
		return function(){
			return funct.apply(scope,arguments);
		};
	},
	eval:function(expr){
		var result=null;
		if(expr.indexOf('function')>=0){
			try{
				eval('var _myJavaScriptExpression='+expr);
				result=_myJavaScriptExpression;
				_myJavaScriptExpression=null;
			}catch(e){
			 alert(e.message+' while evaluating '+expr);
			} 
		}else{
			try{
				result=eval(expr);
			}catch(e){
				alert(e.message+' while evaluating '+expr);
			} 
		}
		return result;
	},
	dispose:function(){
		for(var i=0;i<$b.event["object"].length;i++){
			if($b.event["object"][i].ListenerList!=null){
				$b.RemoveAllListeners($b.event["object"][i]);
			}
		}
		$ = $b = null;
	}
});
$.extend($b,{
	ImportBasePath:'',
	fileinfo:function(data){
		data=data.replace(/^\s|\s$/g,"");
		var m;
		if(/\.\w+$/.test(data)){
			m=data.match(/([^\/\\]+)\.(\w+)$/);
			if(m){
				if(m[2]=='js'){
					return{filename:m[1],ext:m[2],tag:'script'};
				}else if(m[2]=='jsp'){
					return{filename:m[1],ext:m[2],tag:'script'};
				}else if(m[2]=='css'){
					return{filename:m[1],ext:m[2],tag:'link'};
				}else if(m[2]=='lang'){
					return{filename:m[1],ext:m[2],tag:'script'};
				}else	{
					return{filename:m[1],ext:m[2],tag:null};
				}
			}else{
				return{filename:null,ext:null};
			}
		}else{
			m=data.match(/([^\/\\]+)$/);
			if(m){
				return{filename:m[1],ext:null,tag:null};
			}else{
				return{filename:null,ext:null,tag:null};
			}
		}
	},
	fileExist:function(filename,filetype,attrCheck){
		var elementsArray=document.getElementsByTagName(filetype);
		for(var i=0;i<elementsArray.length;i++){
			if(elementsArray[i].getAttribute(attrCheck)==$b.ImportBasePath+filename){
				return true;
			}
		}
		return false;
	},
	createElement:function(filename,filetype){
		switch(filetype){
			case'script':
			if(!$b.fileExist(filename,filetype,'src')){
				var scriptTag=document.createElement(filetype);
				scriptTag.setAttribute('language','javascript');
				scriptTag.setAttribute('type','text/javascript');
				scriptTag.setAttribute('src',$b.ImportBasePath+filename);
				return scriptTag;
			}else{
				return false;
			}
			break;
			case'link':
			if(!$b.fileExist(filename,filetype,'href')){
				var styleTag=document.createElement(filetype);
				styleTag.setAttribute('type','text/css');
				styleTag.setAttribute('rel','stylesheet');
				styleTag.setAttribute('href',$b.ImportBasePath+filename);
				return styleTag;
			}else{
				return false;
			}break;
			default:
			return false;
			break;
		}
	},
	cssReady:function(index,callback){
		function check(){
			if(document.styleSheets[index]){
				if(typeof callback=='function'){
					callback();
				}
				window.clearInterval(checkInterval);
			}
		}
		var checkInterval=window.setInterval(check,200);
	},
	include:function(file,callback){
		var headerTag=document.getElementsByTagName('head')[0];
		var fileArray=[];
		if(typeof file=='string'){
			fileArray=file.split('|');
		}else{
			fileArray=file;
		}
		var fileAlength = fileArray.length;
		var calls=0;
		for(var i=0;i<fileAlength;i++){
			if(fileArray[i].indexOf('/')==-1){
				fileArray[i]=$b.ContextPath+$b.jspath+"/"+fileArray[i];
			}
			var elementTag=$b.fileinfo(fileArray[i]).tag;
			var el=[];
			if(elementTag!==null){
				if($.isFunction( callback )){
					el[i]=$b.createElement(fileArray[i],elementTag);
					if(el[i]){
						headerTag.appendChild(el[i]);
						if($.browser.msie){
							el[i].onreadystatechange=function(){
								if(this.readyState==='loaded'||this.readyState==='complete'){
									calls ++;
									if(calls==fileAlength){
										callback();
									}
								}
							};
						}else{
							if(elementTag=='link'){
								$b.cssReady(i,callback);
							}else{
								el[i].onload=function(){
									callback(); //todo for NOT ie..
								};
							}
						}
					}else{
						calls ++;
						if(calls==fileAlength){
							callback();
						}
					}
				}else{
					switch(elementTag){
						case "script":
							document.writeln("<script src="+fileArray[i]+"></script>");
							break;
						case "link":
							document.writeln("<link rel=stylesheet href="+fileArray[i]+">");
					}
				}	
			}else{
				return false;
			}
		}
	}
});
$(window).unload($b.dispose);
$b.AddEventListener(window, "load", function(){
	$b.Loaded = true;
});

$b.AddEventListener(document, "keydown", function(){
	var eventObj = $b.GetEventObject();
	if(eventObj.keyCode==8){
		var eleObj = eventObj.srcElement || eventObj.target;
		var tagName = eleObj.tagName;
		switch(tagName){
		case "INPUT":
		case "TEXTAREA":
			if (eleObj.readOnly)
				return false;
			break;
		default:
			return false;
		}
	}
	return true;
});
