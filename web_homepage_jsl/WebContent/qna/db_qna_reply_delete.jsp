<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	QnaDao dao = new QnaDao();

	String no = request.getParameter("t_no");
	
	int result = dao.getDeleteReply(no);
	String msg="답변삭제성공";
	if(result != 1){
		msg="답변삭제실패";
	}

%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href="qna_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>