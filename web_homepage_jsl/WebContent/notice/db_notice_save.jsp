<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file="../common_session.jsp" %>
<%

	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	
	if(!sessionLevel.equals("top")){
%>
	<script>
		alert("로그인 정보가 만료되었거나 관리자가 아닙니다.");
		location.href = "notice_list.jsp";
	</script>	
<%		
		
	}else {
	//cos파일 있어야 첨부가능!
	//첨부방법 : 경로지정-용량지정-multipartrequest사용(매개변수 순서:request,첨부파일 경로,첨부파일 최대 사이즈,utf-8,newDefaultFileRenamePolicy())
	
		String noticeDir = CommonUtil.getFile_dir_notice();
		int maxSize = 1024 * 1024 * 10;  //10메가바이트
		MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
		
		
		
	String no = dao.getMaxNo();
	String title = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String attach = mpr.getFilesystemName("t_attach");
	if(attach == null) attach = ""; //만약 첨부를 안하면 db에 문자열null로 뜨기때문에 null일 때 공백으로 바꿈.
	String reg_id = sessionId;	
	String reg_date = CommonUtil.getTodayTime();
	
	NoticeDto dto = new NoticeDto(no,title,content,attach,reg_id,reg_date);
	
	int result = dao.noticeSave(dto);
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
 	location.href="notice_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>
<% }%>