<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>    
<%@ include file="../common_header.jsp" %>
<%@ include file="../common_session.jsp" %>
<%@ page import="dao.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
		
	FaqDao dao = new FaqDao();
	
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	
	if(gubun == null){
		gubun = "f.title";
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
	
	
	
	
	
	
	//ArrayList<FaqDto> arr = dao.getFaqList(gubun,search);
	ArrayList<FaqDto> arr = dao.getFaqList(gubun,search,start,end);

%>	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
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
					<a href="">자주하는질문<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="../qna/qna_list.jsp">질문과답변</a>
						<a href="faq_list.jsp">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
	function goList(){
				faq.method="post";
				faq.action="faq_list.jsp";
				faq.submit();
			 }	
	function goUpdateForm(no){		
		faqUp.t_no.value=no;
		faqUp.method="post";
		faqUp.action="faq_update.jsp";
		faqUp.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제하시겠습니까?")){
			faqUp.t_no.value=no;
			faqUp.method="post";
			faqUp.action="db_faq_delete.jsp";
			faqUp.submit();
		}
	}
	function goPage(nowPage){
		page.t_nowPage.value=nowPage;
		page.method="post";
		page.action="faq_list.jsp";
		page.submit();
	}
</script>
	<div class="container">
	<form name="faqUp">
		<input type="hidden" name="t_no">
	</form>
	<form name="page">
		<input type="hidden" name="t_nowPage">
	</form>
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글  : <span><%=totalCount %></span>건</p>
		</div>
		<div class="search_group">
			<form name="faq">
				<select name="t_gubun" class="select">
					<option value="f.title" <% if(gubun.equals("f.title")) out.print("selected"); %>>제목</option>
					<option value="f.content" <% if(gubun.equals("f.content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button type="button" onclick="goList()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		
		<div class="faq-group">
				  
			<% for(int k=0;k<arr.size();k++){ %>
				<div class="accordion">
					<table class="table">
						<colgroup>
							<col width="10%">
							<col width="50%">
							<col width="10%">
							<col width="10%">						
							<col width="10%">
						</colgroup>		
						<tr>
							<td><%=arr.get(k).getNo() %></td>																	
							<td><%=arr.get(k).getTitle() %></td>
							<td><%=arr.get(k).getName() %></td>
							<td><%=arr.get(k).getReg_date() %></td>												 							  
							<td><%if(sessionLevel.equals("top")) 
									if(arr.get(k).getUpdate_date() != null) out.print(arr.get(k).getUpdate_date()); %></td>						
						</tr>				
					</table>	
				</div>
				<div class="panel">
					<textarea disabled><%=arr.get(k).getContent() %></textarea>
								<% if(sessionLevel.equals("top")){ %>
									<button type="button" onclick="goUpdateForm('<%=arr.get(k).getNo() %>')">수정</button>
						   	 		<button type="button" onclick="goDelete('<%=arr.get(k).getNo() %>')">삭제</button>
                                <% } %>
				</div>
			<% } %>
		</div>

		<script>
			$(function() {
/*			
				$( '.accordion' ).click( function() {
				//$(".accordion").on("click",function() {	
					//$(".panel").slideUp();
					//$(this).next().slideToggle();
					//$(this).next().slideDown();
					$(".panel").not($(this).next().slideToggle()).slideUp();
					//$(this).next().slideDown();
					

				} );
		*/			
			
				$(".accordion").on("click",function() {
					$(".panel").not($(this).next().slideToggle()).slideUp();
					$(".accordion").not($(this)).removeClass("active");
					$(this).toggleClass("active");
				});
		
			});
		</script>

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
			<% if(sessionLevel.equals("top")){ %>
				<a href="faq_write.jsp" class="btn_write">글쓰기</a>
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









    