<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	MemberDao dao = new MemberDao();
	AdminDao adm = new AdminDao(); 
	String id = request.getParameter("t_id");
	MemberDto dto = adm.getAdminView(id);
	String password = request.getParameter("t_password");
	password = dao.encryptSHA256(password);
	
	String name = dao.checkLogin(id,password);
	
	String msg = "";
	String url = "";
	if(name.equals("") || dto.getTal().equals("0")){
		msg = "id나 비밀번호를 확인하세요!";
		url = "member_login.jsp";
	} else{
		msg = name+"님 환영합니다!";
		url = "../index.jsp";
		
		session.setAttribute("sessionId", id);
		session.setAttribute("sessionName", name); //sessionName이라는 변수 안에 name을 넣음.
		
		if(id.equals("manager")){
			session.setAttribute("sessionLevel", "top");
		} else {
			session.setAttribute("sessionLevel", "member");
		}
		
		session.setMaxInactiveInterval(60*60);
		
		adm.getLastLogin(id);
	}
	
	

%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>