<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,dto.*" %>
<%
		QnaDao dao = new QnaDao();
	

	 	String no = request.getParameter("t_no");
	
		dao.getHit(no);
		
		QnaDto preDto = dao.getPreView(no);
	
	
		QnaDto nextDto = dao.getNextView(no);
	
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
						<a href="gratings.jsp">질문답변</a>
						<a href="gratings.jsp">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
	<script>
	function goReply(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_reply.jsp";
		qna.submit();
	}
	function goView(no){
		qna.t_no.value = no;
		qna.method="post";
		qna.action="qna_view.jsp";
		qna.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="db_qna_delete.jsp";
		qna.submit();
		}
	}
	function goUpdateForm(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_update.jsp";
		qna.submit();
	}
	function goReplyUpdateForm(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_reply_update.jsp";
		qna.submit();
	}
	function goReplyDelete(no){
		if(confirm("정말 답변을 삭제하시겠습니까?")){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="db_qna_reply_delete.jsp";
		qna.submit();
		}
		
	}
	</script>
<form name="qna">
	<input type="hidden" name="t_no">
</form>
	<div class="container">
		<div class="board_view">
			<h2>[질문] <%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getName() %></span> | <%="질문등록일 : "+dto.getReg_date() %> |<% if(dto.getUpdate_date() != null) out.print("답변일 : "+dto.getUpdate_date()+"|");  %> <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_body">
				<textarea disabled><%=dto.getContent() %></textarea>
				<% if(dto.getAnswer() != null) { %>
					<p style="font-weight:bold">관리자 답변</p>																												
					<textarea disabled><%=dto.getAnswer() %></textarea>
				<% } else{%>
					<p style="font-weight:bold">관리자 답변</p>																												
					<textarea disabled>관리자의 답변을 기다려주세요.</textarea>
				<% } %>
			</div>								
			<div class="prev_next">
			<% if(preDto != null){
				   String preTitle = preDto.getTitle();
						if(preTitle.length() > 10){
							preTitle = preTitle.substring(0, 9)+"...";
						}			   	
			%>			
				<a href="javascript:goView('<%=preDto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preTitle %></span>
				</span>
				</a>
				<% } %>
				<div class="btn_3wrap">
					<a href="qna_list.jsp">목록</a>
					
					<% if(sessionId.equals(dto.getReg_id()) && dto.getAnswer() == null) { %>					
						<a href="javascript:goUpdateForm('<%=no%>')">수정</a>
					<% } %>
					<% if(sessionLevel.equals("top")) {	%>															 
							<a href="javascript:goDelete('<%=no%>')">삭제</a> 					 
					<% } else if(sessionId.equals(dto.getReg_id()) && dto.getAnswer() == null) {	%>											
							<a href="javascript:goDelete('<%=no%>')">삭제</a> 				 
					<%  }%>													
					<% if(sessionLevel.equals("top") && dto.getAnswer() == null) { %> 															
						<a href="javascript:goReply('<%=no%>')">답변</a>
					<% } else if(sessionLevel.equals("top") && dto.getAnswer() != null) { %>
						<a href="javascript:goReplyUpdateForm('<%=no%>')">답변수정</a>
						<a href="javascript:goReplyDelete('<%=no%>')">답변삭제</a>
					<% } %>	
					
					
				</div>
				<% if(nextDto != null) { 
						String nextTitle = nextDto.getTitle();
							if(nextTitle.length() > 10){
								nextTitle = nextTitle.substring(0, 9)+"...";
							}
				%>			
				<a href="javascript:goView('<%=nextDto.getNo() %>')" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span><%=nextTitle %></span>
				</span>			
				<i class="fa fa-angle-right"></i>
				</a>
				<% } %>
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
















    