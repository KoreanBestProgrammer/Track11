<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	
	MemberDao dao = new MemberDao();
	
	String id       = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password        = dao.encryptSHA256(password);//암호화
		
		String name     = request.getParameter("t_name");
		String job      = request.getParameter("t_job");
		String tell_1   = request.getParameter("t_tell_1");
		String tell_2   = request.getParameter("t_tell_2");
		String tell_3   = request.getParameter("t_tell_3");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String mobile   = mobile_1+mobile_2+mobile_3;
		String email    = request.getParameter("t_email");
		
		int count = dao.getCheckPassword(id,password);
		
		String msg = "개인정보 수정성공";
		String url = "../index.jsp";
		if(count == 1){
			MemberDto dto = new MemberDto(id,name,password,job,tell_1,tell_2,tell_3,mobile,email,"");
			int result = dao.updateMember(dto);
			if(result != 1){
				msg = "개인정보 수정오류~관리자 문의 바람.";
				url = "../index.jsp";
			}
		}else{
			msg = "비밀번호가 정확하지않습니다.";
			url = "member_update.jsp";
		}	
		
		
	
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>