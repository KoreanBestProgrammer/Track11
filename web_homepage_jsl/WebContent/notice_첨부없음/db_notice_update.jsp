<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");

	NoticeDao dao = new NoticeDao();		
	
	String no = request.getParameter("t_no");
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	
	NoticeDto dto = new NoticeDto(no,title,content);
	int result = dao.noticeUpdate(dto);
	
	String msg = "수정성공!";
	if(result != 1){
		msg = "수정실패~";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
 	alert("<%=msg%>");
 	location.href="notice_list.jsp";
</script>
</body>
</html>