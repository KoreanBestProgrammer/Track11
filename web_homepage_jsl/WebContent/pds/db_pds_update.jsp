<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*,java.io.*" %>
<%@ include file="../common_session.jsp" %>
<%
	
	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	
	if(!sessionLevel.equals("top")) {
%>
	<script>
		alert("관리자 외 입장불가");
		location.href="../index.jsp";
	</script>

<%	
	}else{
			String pdsDir = CommonUtil.getFile_dir_pds();
			int maxSize = CommonUtil.getMaxSize();
			MultipartRequest mpr = new MultipartRequest(request,pdsDir,maxSize,"utf-8");
			
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach == null) attach="";
			String deleteFile = mpr.getParameter("t_deleteFile");
			String oriAttach = mpr.getParameter("t_ori_attach");
			if(oriAttach == null) oriAttach ="";
			String update_date = CommonUtil.getTodayTime();
			String saveAttachName = "";		
			if(deleteFile != null){
				File file = new File(pdsDir,deleteFile);
				boolean tf = file.delete();
				if(!tf){
					System.out.print("파일삭제오류");
				}
			}else{
				saveAttachName = oriAttach;
			}
			
			
			if(!attach.equals("")){
				if(!oriAttach.equals("")){
					File file = new File(pdsDir,oriAttach);
					boolean tf = file.delete();
					if(!tf){
						System.out.print("파일삭제오류");
					}
				}
				saveAttachName = attach;
			}
			
			PdsDto dto = new PdsDto(no,title,content,update_date,saveAttachName);
			int result = dao.getUpdatePds(dto);
			
			String msg = "수정성공";
			if(result != 1){
				msg="수정실패";
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