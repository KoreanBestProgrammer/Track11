<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	
	if(!sessionLevel.equals("member")) {					
%>
	<script>
		alert("일반회원 외 입장불가");
		location.href="qna_list.jsp";	
	</script>
<% 	
	} else{
	QnaDao dao = new QnaDao();
	
	String no = dao.getMaxNO();
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String state = request.getParameter("t_state");
	String reg_id = sessionId;
	String reg_date = CommonUtil.getTodayTime();
	
	QnaDto dto = new QnaDto(no,title,reg_id,content,state,reg_date);
	int result = dao.getSaveQna(dto);
	String msg = "등록성공";
	if(result != 1){
		msg = "등록실패";
	}

%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="qna_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% }%>