<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%@ include file="../common_header.jsp" %> 
<%
	String id = request.getParameter("t_id");
%>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>비밀번호 확인</h2>
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
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
			<div class="member_boxL">
                <h2>개인회원</h2>
                <div class="login_form">
                <script>
                
                
                function fn_login(){
                	if(checkValue(mem.t_password,"비밀번호를 입력하시오")) return;
					if(checkValue(mem.t_password2,"비밀번호를 확인하시오")) return;  
					if(mem.t_password.value != mem.t_password2.value){
						alert("비밀번호가 일치하지 않습니다.");
						return;
					}
						mem.method="post";
                		mem.action="db_member_delete.jsp";
                		mem.submit();
                	
                }
                
                
                function pwCheck(){
                	var keyValue = event.keyCode;
                	if(keyValue == 13){
                		if(checkValue(mem.t_password,"비밀번호를 입력하시오")) return;
                		fn_login();
                	}
                	
                }
                </script>
                    <form name="mem">
                    	<input type="hidden" name="t_id" value="<%=id %>">
                    	<div class="fl_clear"><label for="mbrId">비밀번호</label><input type="text" name="t_password"> </div>
                    	<div class="fl_clear"><label for="scrtNo">비밀번호 확인</label><input name="t_password2" onkeypress="pwCheck()" id="scrtNo" type="password"></div>                  	
                    </form>
                    <a class="btn_login btn_Blue" href="javascript:fn_login();">회원탈퇴</a>
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
	

	<%@ include file="../common_footer.jsp" %>

 </body>
</html>









    