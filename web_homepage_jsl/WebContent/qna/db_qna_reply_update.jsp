<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	
	QnaDao dao = new QnaDao();
	
	String no = request.getParameter("t_no");
	String answer = request.getParameter("t_answer");
	
	int result = dao.getQnaReplyUpdate(no,answer);
	String msg = "답변수정성공!";
	if(result != 1){
		msg = "답변수정실패!!!!!";
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