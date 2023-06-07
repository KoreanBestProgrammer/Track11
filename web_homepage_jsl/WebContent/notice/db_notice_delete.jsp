<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,java.io.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%
	if(!sessionLevel.equals("top")) {
%>
		<script>
			alert("관리자가 아닙니다.");
			location.href="../index.jsp";	
		</script>

<%
	} else{		
	request.setCharacterEncoding("utf-8");	
		
	NoticeDao dao = new NoticeDao();
	String no = request.getParameter("t_no");
	String attach = request.getParameter("t_attach"); 		
	String noticeDir = CommonUtil.getFile_dir_notice();
	
	int result = dao.noticeDelete(no);
	
	if(result == 1){
		if(!attach.equals("")){
			File file = new File(noticeDir,attach);
			boolean tf = file.delete();
			if(!tf) System.out.print("첨부파일 삭제 오류!");
		}
	}
	
	String msg = "삭제성공";
	if(result != 1){
		msg = "삭제실패";
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
	alert("<%=msg%>")
	location.href="notice_list.jsp";
</script>
</body>
</html>
<% }%>