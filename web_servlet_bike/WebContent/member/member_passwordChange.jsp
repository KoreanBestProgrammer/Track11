<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>    	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href=""><span class="fnt"><i class="fas fa-apple-alt"></i></span>MEMBER</a></li>
			</ul>
		</div>
		<script>
			function goPw(){
				login.t_change_pw1.focus();	
			}
			function goPw_2(){
				login.t_change_pw2.focus();	
			}
			
			function passwordChange(){
				if(checkValue(login.t_now_pw,"현재 비밀번호를 입력하세요")) return;
				if(checkValue(login.t_change_pw1,"새 비밀번호를 입력하세요")) return;
				if(checkValue(login.t_change_pw2,"새 비밀번호 확인을 입력하세요")) return;
 				
				if(login.t_change_pw1.value != login.t_change_pw2.value){
					alert("비밀번호가 같지 않습니다");
					login.t_change_pw2.focus();
					return;
				}
				
				login.method="post";
				login.action="Member";
				login.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				MEMBER CHANGE PASSWORD
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>PASSWORD CHANGE</h2>
					<div class="login_form">
						<form name="login">
							<input type="hidden" name="t_gubun" value="memberPasswordUpdate">
							<div class="fl_clear"><label for="mbrId" class="pw_label">현재 비밀번호</label><input name="t_now_pw" id="mbrId" type="text" autofocus onkeypress="if( event.keyCode==13 ){goPw()}"></div>
							<div class="fl_clear"><label for="scrtNo" class="pw_label">새 비밀번호</label><input name="t_change_pw1" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){goPw_2()}"></div>
							<div class="fl_clear"><label for="scrtNo" class="pw_label">새 비밀번호 확인</label><input name="t_change_pw2" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){passwordChange()}"></div>
							<a href="javascript:passwordChange()" class="btn_login btn_Blue pw_button" >비밀번호변경</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
	<%@ include file = "../common_footer.jsp" %>
</body>
</html>






    