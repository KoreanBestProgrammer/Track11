<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%@ include file="../common_session.jsp" %>
<%
	FaqDao dao = new FaqDao();
	if(!sessionLevel.equals("top")){
%>
	<script>
		alert("관리자 외 입장불가");
		location.href="../index.jsp";
	</script>

<% 
	}else{String no = request.getParameter("t_no");
	
		 int result = dao.getDeleteFaq(no);
		 String msg = "삭제성공!!!";
		 if(result != 1){
			 msg = "삭제실패!!!!!";
		 }

%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% } %>