<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%@ include file="../common_session.jsp" %>
<%
	MemberDao dao = new MemberDao();
	
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password = dao.encryptSHA256(password);
	String password2 = request.getParameter("t_password2");
	password2 = dao.encryptSHA256(password2);
		
	int count = dao.getCount(id,password);
	
	String msg = "탈퇴실패";
	if(count == 1){ 
		int result = dao.getDeleteMember(id);
		 msg = "탈퇴감사합니다";
	}
	
		
	

%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href="../login/member_logout.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>