<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("utf-8");

	QnaDao dao = new QnaDao();
	
	String no = request.getParameter("t_no");
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	
	int result = dao.getQnaUpdate(no,title,content);
	String msg="질문수정성공!";
	if(result != 1){
		msg="질문수정실패!";
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