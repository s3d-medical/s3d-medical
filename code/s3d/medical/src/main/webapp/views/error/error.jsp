<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/buihead.jsp"%>
</head>
<BODY style="margin-left:20px">
<br>
<hr>
<div class="row">
   <div class="span10">
       <div class="tips tips-large tips-warning">
         <span class="x-icon x-icon-error">×</span>
         <div class="tips-content">
           <h2><bean:message key="return.title"/></h2>
           	错误
           <p class="auxiliary-text">
             ${message}
           </p>
           <p>
             <%
             	Exception e = (Exception) request.getAttribute("exception");
				if(e!=null){
					out.println("<br><br>"+e);
					out.println("<pre>");
					e.printStackTrace( new java.io.PrintWriter( out ) );
					out.println("</pre>");
				}
			%>
           </p>
         </div>
       </div>
   </div> 
  </div>
</BODY>
</html>