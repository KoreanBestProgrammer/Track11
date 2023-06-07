<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>    
<%@ include file="../common_session.jsp" %>
<%@ include file="../common_header.jsp" %>
<%@ page import="dto.*,dao.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();	
	
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	
	if(gubun == null){
		gubun = "q.title";
		search = "";
	}
	
	
	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(gubun,search);
	int list_setup_count = 5;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
	String nowPage = request.getParameter("t_nowPage");
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	/* paging 설정 end*/	
	
	//ArrayList<QnaDto> arr = dao.getListQna(gubun,search);
	ArrayList<QnaDto> arr = dao.getListQnaPage(gubun,search,start,end);

%>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>질문과답변</h2>
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
					<a href="">질문과답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="qna_list.jsp">질문과답변</a>
						<a href="../faq/faq_list.jsp">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
	function goList(){
		qna.method="post";
		qna.action="qna_list.jsp";
		qna.submit();
	}
	function goView(no){
		view.t_no.value = no;
		view.method="post";
		view.action="qna_view.jsp";
		view.submit();
	}
	function goPage(nowPage){
		page.t_nowPage.value=nowPage;
		page.method="post";
		page.action="qna_list.jsp";
		page.submit();
	}
</script>
<form name="view">
	<input type="hidden" name="t_no">
</form> 
<form name="page">
	<input type="hidden" name="t_nowPage">
</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount%></span>건</p>
		</div>
		<div class="search_group">
			<form name="qna">
				<select name="t_gubun" class="select">
					<option value="q.title" <%if(gubun.equals("q.title")) out.print("selected"); %>>제목</option>
					<option value="q.content" <%if(gubun.equals("q.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button type="button" onclick="goList()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,답변상태, 작성자, 작성일, 조회수로 구성되어 있습니다">
			<caption class="sr-only">질문과 답변 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>답변상태</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<% for(int k = 0 ; k < arr.size() ; k++){ %>
				<tr>
					<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
					<td class="title"><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getTitle() %></a></td>
					<% if(arr.get(k).getAnswer() != null){ %>
						<td><span class="complet">답변완료</span></td>
					<% } else{%>
						<td><span class="waiting">답변대기</span></td>
					<% } %>	
					<td><%=arr.get(k).getName() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%=arr.get(k).getHit() %></td>
				</tr>
			<% } %>	
			</tbody>
		</table>
		<div class="paging">
		<%
			String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
			out.print(paging);						
		%>
		
		<!-- 
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
		 -->	
			<% if(sessionLevel.equals("member")) {%>
				<a href="qna_write.jsp" class="btn_write">글쓰기</a>
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









    