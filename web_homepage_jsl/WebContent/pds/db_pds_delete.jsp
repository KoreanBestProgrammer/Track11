<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,common.*,java.io.*" %>
<%
	PdsDao dao = new PdsDao();
	request.setCharacterEncoding("utf-8");	

	if(!sessionLevel.equals("top")){
%>
	<script>
		alert("관리자 외 입장불가");
		location.href="../index.jsp";
	</script>
<%

	}else{
			String no = request.getParameter("t_no");
			String attach = request.getParameter("t_attach");
			String pdsDir = CommonUtil.getFile_dir_pds();
			
			
			int result = dao.getDeletePds(no);
			
			if(result == 1){
				if(!attach.equals("")){
					File file = new File(pdsDir,attach);
					boolean tf = file.delete();
					if(!tf) System.out.print("파일삭제오류");
					//if(file.exists()) file.delete();
				}
			}
			
			String msg = "삭제성공";
			if(result != 1){
				msg="삭제실패";
			}


%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="pds_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% } %>