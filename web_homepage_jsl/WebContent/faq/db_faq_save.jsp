<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file = "../common_session.jsp" %>
<%	
	request.setCharacterEncoding("utf-8");

	FaqDao dao = new FaqDao();
	if(!sessionLevel.equals("top")){
%>	
		<script>
			alert("관리자 외 입장불가");
			location.href="../index.jsp";
		</script>
<%
	}else{	String no = dao.getMaxNo();
			String title = request.getParameter("t_title");
			String content = request.getParameter("t_content");
			String reg_id = sessionId;
			String reg_date = CommonUtil.getTodayTime();
				
			FaqDto dto = new FaqDto(no,title,content,reg_id,reg_date);
			int result = dao.getSaveFaq(dto);
			String msg = "등록성공!";
			if(result != 1){
				msg="등록실패!";
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