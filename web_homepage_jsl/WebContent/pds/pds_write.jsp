<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*" %>
<%@ include file="../common_session.jsp" %>
<%@ include file="../common_header.jsp" %>	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자료실</h2>
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
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="gratings.jsp">DW인터뷰</a>
						<a href="gratings.jsp">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">자료실 글쓰기</h2>
	
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
	    <form name="pds" enctype="multipart/form-data">
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
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"></textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td colspan="3"><input type="file" name="t_attach"></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><%=sessionName%></td>
						<th>등록일자</th>
						<td><%=CommonUtil.getToday()%></td>
					</tr>
				</tbody>
			</table>
			</form>
			<div class="btn_wrap">
				<input type="button" onclick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='pds.jsp';">
			</div>
		
	  </div>
	
	</div>
	  <script>
	  	function goSave(){
	  		if(checkValue(pds.t_title,"제목을 입력하세요")) return;
	  		if(checkValue(pds.t_content,"내용을 입력하세요")) return;
	  		
	  		
			/***  첨부파일 검사 ***/
			// 1.확장자 검사
			var fileName = pds.t_attach.value;
			if(fileName != ""){ //  C:\fakepath\img_1.png
				var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
				var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
				//파일명.확장자
//				if(extension != "jpg" && extension != "gif" && extension != "png"){
				if(extension != "pdf" && extension != "hwp" && extension != "jpg"){
					alert(extension +" 형식 파일은 업로드 안됩니다. 한글, PDF, jpg 파일만 가능!");
					return;
				}		
			}
			
			// 2.첨부 용량 체크	
			var file = pds.t_attach;
			var fileMaxSize  = 10; // 첨부 최대 용량 설정
			if(file.value !=""){
				// 사이즈체크
				var maxSize  = 1024 * 1024 * fileMaxSize;  
				var fileSize = 0;
				// 브라우저 확인
				var browser=navigator.appName;
				// 익스플로러일 경우
				if (browser=="Microsoft Internet Explorer"){
					var oas = new ActiveXObject("Scripting.FileSystemObject");
					fileSize = oas.getFile(file.value).size;
				}else {
				// 익스플로러가 아닐경우
					fileSize = file.files[0].size;
				}

				if(fileSize > maxSize){
					alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
					return;
				}	
			}
	  			  		  		  			  		
	  		pds.method="post";
	  		pds.action="db_pds_save.jsp";
	  		pds.submit();
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









    