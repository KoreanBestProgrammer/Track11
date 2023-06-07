<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	MemberDao dao = new MemberDao();
	
	if(!sessionLevel.equals("top")) {
%>
	<script>
		alert("관리자 외 입장불가");
		location.href="../index.jsp"
	</script>
<%
	}else{
		  String id = request.getParameter("t_id");
		  String password = request.getParameter("t_password");
		  password = dao.encryptSHA256(password);
		  
		  String name = dao.checkLogin(id, password);
		  String msg= "";
		  String url = "";
		  if(name.equals("")){
			  msg="id또는 비밀번호를 확인하세요";
			  url="../index.jsp";
		  }else{
			  msg=name+"님 환영합니다.";
			  url="admin_list.jsp";
		  }
				  
%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% }%>