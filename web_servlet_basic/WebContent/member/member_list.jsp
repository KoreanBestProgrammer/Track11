<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,java.util.*" %>    
<%
	

    ArrayList<Member_dto> arr = (ArrayList<Member_dto>)request.getAttribute("t_arr");
    
    String select = (String)request.getAttribute("t_select");
    String search = (String)request.getAttribute("t_search");
    
%>
<!DOCTYPE html>
<html> 
<head>
<script>
	function goSearch(){
			member.method="post";
//			member.action="MemberList";
			member.action="Member";
			member.submit();
	}
	function goView(no){
		view.t_id.value=no;
		view.t_gubun.value="memberView";
		view.method="post";
		//view.action="MemberView";
		view.action="Member";
		view.submit();
	}
	function goWriteForm(){
		view.t_gubun.value="writeForm";
		view.method="post";
		view.action="Member";
		view.submit();
	}
</script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="/web_servlet_basic/css/common.css" rel="stylesheet">
	<link href="/web_servlet_basic/css/layout.css" rel="stylesheet" >	
</head>
<body>
	<div class="container">
	
	<form name="view">
		<input type="hidden" name="t_gubun">
		<input type="hidden" name="t_id">
	</form>
	<form name="member">
		<div class="leftmargin">
			<img src="/web_servlet_basic/images/jsl_logo.png"><h1>TRACK11 홍길동 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=arr.size() %></span>건</p>
			</div>
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="id" <% if(select.equals("id")) out.print("selected"); %>>ID</option>
					<option value="name" <% if(select.equals("name")) out.print("selected"); %>>성명</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>				
		</div>
		</form>	
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
					<th>나이</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
			<% for(Member_dto dto : arr) { %>
				<tr>
					<td><a href="MemberView?t_id=<%=dto.getId() %>"><%=dto.getId() %></a></td>
					<td><a href="javascript:goView('<%=dto.getId() %>')"><%=dto.getName() %></a></td>
					<td><%=dto.getAge() %></td>
					<td><%=dto.getReg_date() %></td>
				</tr>	
		    <% } %>	
			</tbody>
		</table>
		<div class="paging">
<!-- 		<a href="MemberWrite" class="write">회원등록</a>      -->
			<a href="javascript:goWriteForm()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







    