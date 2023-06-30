<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')">Join</a></li>
				
			</ul>
		</div>
		<script>
			
			
			function memberPassword(){
				
				if(checkValue(mem.t_id,"id를 입력하세요")) return;
				if(checkValue(mem.t_mobile_1,"전화번호를 입력하세요")) return;
				if(checkValue(mem.t_mobile_2,"전화번호를 입력하세요")) return;
				if(checkValue(mem.t_mobile_3,"전화번호를 입력하세요")) return;
				if(checkValue(mem.t_email,"이메일을 입력하세요")) return;
 				
				mem.t_gubun.value="memberPasswordSend"
				mem.method="post";
				mem.action="Member"
				mem.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER PASSWORD FIND
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>PASSWORD FIND</h2>
					<div class="login_form">
						<form name="mem">
						<input type="hidden" name="t_gubun">
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" class="t_id" type="text" autofocus onkeypress="if( event.keyCode==13 ){goPw()}"></div>
							<div class="fl_clear"><label for="scrtNo">전화번호</label><input name="t_mobile_1" id="scrtNo" type="text" class="t_mobile">-<input name="t_mobile_2" id="scrtNo" type="text" class="t_mobile" >-<input name="t_mobile_3" id="scrtNo" type="text" class="t_mobile" ></div>
							<div class="fl_clear"><label for="mbrId">이메일</label><input name="t_email" id="mbrId" class="t_id" type="text" autofocus onkeypress="if( event.keyCode==13 ){goPw()}"></div>
							<a href="javascript:memberPassword()" class="btn_login btn_Blue" >비밀번호찾기</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    