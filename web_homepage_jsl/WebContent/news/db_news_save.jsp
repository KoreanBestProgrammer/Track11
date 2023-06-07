<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao = new NewsDao();
	
	if(!sessionLevel.equals("top")) {
%>
 	<script>	
 		alert("관리자만 가능");
 		location.href="../index.jsp";
 	</script>
<% 
	}else {	

	String no = dao.getMaxNo();
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_id = sessionId;
	String reg_date = CommonUtil.getTodayTime();
	
	NewsDto dto = new NewsDto(no,title,content,reg_id,reg_date);
	
	int result = dao.getNewsSave(dto);
	String msg = "등록 성공";
	if(result != 1){
		msg = "등록 실패";
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>
</body>
</html>
<% } %>
