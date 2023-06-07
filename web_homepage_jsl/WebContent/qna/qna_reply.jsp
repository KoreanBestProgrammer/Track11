<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();
	
	String no = request.getParameter("t_no");
	
	QnaDto dto = dao.getQnaView(no);

%>    
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>질문답변</h2>
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
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="gratings.jsp">질문과답변</a>
						<a href="gratings.jsp">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
 	function goReply(){
 		if(checkValue(qna.t_answer,"답변을 입력해주세요")) return;
 		
		qna.method="post";
		qna.action="db_qna_reply.jsp";
		qna.submit();
 	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
	  <form name="qna">
	  	<input type="hidden" name="t_no" value="<%=no %>">
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td><%=dto.getName()%></td>
						<th>질문등록일</th>
						<td><%=dto.getReg_date()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=dto.getTitle() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea disabled><%=dto.getContent() %></textarea></td>
					</tr>				
					<tr>
						<th>답변</th>
						<td colspan="3"><textarea name="t_answer"></textarea></td>
					</tr>
					<tr>			
						<th>답변자</th>
						<td><%=sessionName %></td>						
					</tr>
				</tbody>
			</table>
			</form>
			<div class="btn_wrap">
				<input type="button" onclick="goReply()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='qna_list.jsp';">
			</div>
		
	  </div>
	  
	</div>
	<!-- end contents -->
	
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









    