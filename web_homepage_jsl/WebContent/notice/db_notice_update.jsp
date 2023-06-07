<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="dao.*,dto.*,common.*,java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");

	NoticeDao dao = new NoticeDao();
	
	String noticeDir = CommonUtil.getFile_dir_notice();
	int maxSize = CommonUtil.getMaxSize(); 
	MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
	
	
	
	String no = mpr.getParameter("t_no");
	String title = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String attach = mpr.getFilesystemName("t_attach");
	if(attach == null) attach ="";
	
	String deleteAttach = mpr.getParameter("t_deleteFile");
	String oriAttach = mpr.getParameter("t_ori_attach");
	String saveAttachName = "";
	if(deleteAttach != null){
		File file = new File(noticeDir,deleteAttach);
		boolean tf = file.delete();
		if(!tf){
			System.out.print("공지사항 첨부파일삭제 실패 : "+tf);
		}
	}else{
		saveAttachName = oriAttach;
	}
	
	//새로운 첨부파일 등록하면(attach가 공백이냐 아니냐로 판단)
	if(!attach.equals("")) {
		if(oriAttach != null){
			File file = new File(noticeDir,oriAttach);
			boolean tf = file.delete();
		}
		saveAttachName = attach;
	}
	
	
	
	NoticeDto dto = new NoticeDto(no,title,content,saveAttachName);
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