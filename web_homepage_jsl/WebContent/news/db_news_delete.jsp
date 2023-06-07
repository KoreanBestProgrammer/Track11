<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ include file="../common_session.jsp" %>
<%
	
	if(!sessionLevel.equals("top")) {
%>
	<script>
		alert("관리자가 아닙니다");
		location.href="../index.jsp";
	</script>
<% 	
	}else{
		NewsDao dao = new NewsDao();
		
		String no = request.getParameter("t_no");
	
		int result = dao.getNewsDelete(no);
		String msg = "삭제성공";
		if(result != 1){
			msg="삭제실패";
		}
%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% } %>