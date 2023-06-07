<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%
	if(!sessionLevel.equals("top")) {

%>
	<script>
		alert("관리자 외 입장불가");
		location.href="../index.jsp"
	</script>
<%
	}else{
%>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>관리자 로그인</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="allclass.jsp">학과및모집안내</a>
						<a href="portfolio.jsp">포트폴리오</a>
						<a href="online.jsp">온라인접수</a>
						<a href="notice.jsp">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">관리자<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="../qna/qna_list.jsp">질문과답변</a>
						<a href="../faq/faq_list.jsp">FAQ</a>
						<a href="admin_login.jsp">관리자</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="bg_admim">
		<div class="container">
			<div class="grap">
				<form name="admin">
					<fieldset>
						<legend class="sr-only">관리자로그인</legend>
						<label for="id" class="sr-only">아이디입력</label><input type="text" name="t_id" placeholder="아이디를 입력하세요" onkeypress="idCheck()" autofocus id="id">
						<label for="pw" class="sr-only">패스워드입력</label><input type="password" name="t_password" placeholder="패스워드를 입력하세요" onkeypress="pwCheck()" id="pw">
						<a href="javascript:goLogin()" class="btn_admin">로그인</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- end contents -->
	<script type="text/javascript">
		function goLogin(){
			if(checkValue(admin.t_id,"아이디를 입력하세요")) return;
			if(checkValue(admin.t_password,"비밀번호를 입력하세요")) return;
			
			admin.method="post";
			admin.action="db_admin_login.jsp";
			admin.submit();
			
		}
		 function idCheck(){
         	var keyValue = event.keyCode;
         	if(keyValue == 13){
         		if(checkValue(admin.t_id,"id를 입력하시오")) return;
         		admin.t_password.focus();
         	}            	              	
         }
         
         function pwCheck(){
         	var keyValue = event.keyCode;
         	if(keyValue == 13){
         		if(checkValue(admin.t_password,"비밀번호를 입력하시오")) return;
         		goLogin();
         	}
         	
         }
		
		
	</script>

	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

	<?php
		include "footer.jsp";
	?>

 </body>
</html>
<% } %>








    