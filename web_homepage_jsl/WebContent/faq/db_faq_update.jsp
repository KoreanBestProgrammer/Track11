<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,common.*" %>
<%@ include file="../common_session.jsp" %>
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
	}else{	String no = request.getParameter("t_no");
			String title = request.getParameter("t_title");
			String content = request.getParameter("t_content");
			String update_date = CommonUtil.getTodayTime();
				
			FaqDto dto = new FaqDto(no,title,content,update_date);
		
			int result = dao.getUpdateFaq(dto);
			String msg="수정성공!";
			if(result != 1){
				msg="수정실패!!!!";
			}

%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="faq_list.jsp";
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% } %>