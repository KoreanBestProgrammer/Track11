<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')"><span class="fnt"><i class="fas fa-apple-alt"></i></span>LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href="javascript:goWork('memberJoin')">Join</a></li>
				
			</ul>
		</div>
		<script>
			function goPw(){
				login.t_password.focus();	
			}
			
			function memberLogin(){
				if(checkValue(login.t_id,"id를 입력하세요")) return;
				if(checkValue(login.t_password,"비밀번호를 입력하세요")) return;
 				
				login.method="post";
				login.action="Member";
				login.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="login">
							<input type="hidden" name="t_gubun" value="login">
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" type="text" autofocus onkeypress="if( event.keyCode==13 ){goPw()}"></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_password" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){memberLogin()}"></div>
							<a href="javascript:memberLogin()" class="btn_login btn_Blue" >로그인</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    