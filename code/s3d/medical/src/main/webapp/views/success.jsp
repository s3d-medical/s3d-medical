<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/buihead.jsp"%>
<script type="text/javascript">
function refreshParent(){
	try{
		if(window.opener!=null){
			window.opener.location.reload();
			return;
		}
		if(window.parent.topManager!=null){
			var topManager=window.parent.topManager;
			topManager.reloadPage();
		}
	}catch(e){}
}
var time = 0;
var intvalId =null;
function timeInteval(){
	var _timeArea = document.getElementById("_timeArea");
	if(time==2){
		var topManager=window.parent.topManager;
		if(topManager)
			topManager.closePage();
		else
			$b.CloseWindow();
		return;
	}
	_timeArea.innerHTML = 2 - time+" 秒后自动关闭";
	time =time+1;
	intvalId=setTimeout("timeInteval()",1000);
}
</script>
</head>
<BODY style="margin-left:20px">
<br>
<hr>
<div class="row">
   <div class="span10">
       <div class="tips tips-large tips-success">
         <span class="x-icon x-icon-success"><i class="icon icon-white icon-ok"></i></span>
         <div class="tips-content">
           <h2><bean:message key="return.title"/></h2>
           	${message}
           <p class="auxiliary-text">
             <font style="font-size: 14px;color:purple;font-weight:bolder;" id="_timeArea"></font>&nbsp;
           </p>
           <p>
             
           </p>
         </div>
       </div>
   </div> 
  </div>
 <script>
 <c:if test="${ false !=SUCCESS_PAGE_RELOAD_OPENER}">
 	$b.AddEventListener(window,"load",refreshParent);
 </c:if> 
 <c:if test="${ false !=SUCCESS_PAGE_AUTO_CLOSE}">
	$b.AddEventListener(window,"load",timeInteval);
</c:if>
</script>
</BODY>
</html>