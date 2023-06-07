<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%@ include file="../common_session.jsp" %>
<%@ include file = "../common_header.jsp"  %>
<%		
	if(!sessionLevel.equals("top")){
%>	
	<script>
		alert("관리자가 아닙니다.");
		location.href="../index.jsp"
	</script>	
<% 
	} else {    
		
	NewsDao dao = new NewsDao();

	String no = request.getParameter("t_no");
	
	NewsDto dto = dao.getNewsView(no);


%>

	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="gratings.html">DW인터뷰</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>	  
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
	  <form name="news">
	 	 <input type="hidden" name="t_no" value="<%=no%>">
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>						
				<colgroup>
					<col width="10%">
					<col width="25%">
					<col width="10%">
					<col width="25%">
					<col width="10%">
					<col width="25%">
				</colgroup>			
				<tbody>
					<tr class="first">
						<th>제목</th>
						<td colspan="5"><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>	
					<tr class="first">
						<th>글쓴이</th>
						<td><%=dto.getName() %></td>
						<th>등록일</th>
						<td><%=dto.getReg_date() %></td>
						<th>수정일</th>
						<% String updateDate = dto.getUpdate_date();
						   if(updateDate == null) {
							  	updateDate = "수정 이력 없음";
							}													
						%>
                        <td><%=updateDate %></td>					 
					</tr>	
				</tbody>				
			</table>
			</form>
			<div class="btn_wrap">
				<input type="button" value="수정저장" onclick="goUpdate()" class="btn_ok">&nbsp;&nbsp;				
				<input type="button" value="목록" class="btn_list" onClick="location.href='news_list.jsp';">
			</div>	
	  </div>
	  
	</div>
	<script>
	function goUpdate(){	
				
				if(news.t_title.value == ""){
					alert("제목을 입력하시오");
					news.t_title.focus();
				}
				if(news.t_content.value == ""){
					alert("내용을 입력하시오");
					news.t_content.focus();
				}
				
				news.method="post";
				news.action="db_news_update.jsp";
				news.submit();
			} 
</script>
	<!-- end contents -->
	<script>
	
		
 		

		function check() {
			if(notice.writer.value=="") {
				alert("글쓴이 입력");
				notice.writer.focus();
				return false;
			}
			if(notice.title.value=="") {
				alert("제목을 입력");
				notice.title.focus();
				return false;
			}
			if(notice.contents.value=="") {
				alert("내용을 입력");
				notice.contents.focus();
				return false;
			}
			return true;
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
	

<footer class="footer">
		<div class="container clearfix">
			<address class="address">
				<p class="title">본사</p>
				(우)12345 대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층,6층/고객센터: 042-242-4412 	사업자등록번호: 305-86-06709
			</address>
			<p class="copyright">Copyright &copy JSL 인재개발원주식회사. All rights reserved.</p>
		</div>
</footer>	

 </body>
</html>
<% } %>








