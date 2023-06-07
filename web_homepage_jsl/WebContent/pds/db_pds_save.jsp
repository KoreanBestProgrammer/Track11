<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,dto.*,common.*,java.io.*" %>
<%




	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	
	if(!sessionLevel.equals("top")) {
	
%>	
	<script>
		alert("관리자 외 입장금지");
		location.href="../index.jps";
	</script>
<% 

	}else{
			String pdsDir = CommonUtil.getFile_dir_pds();
			int maxSize = CommonUtil.getMaxSize();	
			MultipartRequest mpr = new MultipartRequest(request,pdsDir,maxSize,"utf-8",new DefaultFileRenamePolicy() );
			
			String no = dao.getMaxNo();
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			String reg_id = sessionId;	
			String reg_date = CommonUtil.getTodayTime();
			
			PdsDto dto = new PdsDto(no,title,content,attach,reg_id,reg_date);
			int result = dao.getSavePds(dto);
			String msg = "등록되었습니다.";
			if(result != 1){
				msg = "등록실패";
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