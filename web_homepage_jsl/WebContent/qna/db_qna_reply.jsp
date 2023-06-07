<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();
	
	String no = request.getParameter("t_no");
	String answer = request.getParameter("t_answer");
	String answerId = sessionId;
	String update_date = CommonUtil.getTodayTime();
	
	QnaDto dto = new QnaDto(no,update_date,answer,answerId);
	int result = dao.getQnaReply(dto);
	String msg="답변등록성공!";
	if(result != 1){
		msg="답변등록실패!";
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