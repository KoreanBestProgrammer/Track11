<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>

	<c:if test="${sessionLevel ne 'admin'}">
    	<script>
    		alert("관리자만 입장가능!");
    		location.href="Index";
    	</script>
    </c:if>

		<div id="b_left">
			<%@ include file="../common_menu_admin.jsp" %>
		</div>
		<script>
			function goSave(){
				
				if(checkValue(save.t_name,"제품명을 입력하세요")) return;
				if(checkValue(save.t_explain,"제품설명을 입력하세요")) return;
				if(checkValue(save.t_rank,"제품순위을 입력하세요")) return;
				if(checkValue(save.t_price,"제품가격을 입력하세요")) return;
				if(checkValue(save.t_size,"제품크기를 입력하세요")) return;
				if(checkValue(save.t_attach,"제품사진를 첨부하세요")) return;
				
				/***  첨부파일 검사 ***/
				// 1.확장자 검사
				var fileName = save.t_attach.value;
				if(fileName != ""){ //  C:\fakepath\img_1.png
					var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
					var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
					//파일명.확장자
					if(extension != "jpg" && extension != "gif" && extension != "png"){
						alert(extension +" 형식 파일은 업로드 안됩니다. jpg, gif, png 파일만 가능!");
						return;
					}		
				}
				
				// 2.첨부 용량 체크	
				var file = save.t_attach;
				var fileMaxSize  = 5; // 첨부 최대 용량 설정
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
				
				save.method="post";
				save.action="Product?t_gubun=save"
				save.submit();
			}
		</script>
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="save" enctype="multipart/form-data">
			<input type="hidden" name="t_gubun">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제품명</th>
						<td colspan="3"><input type="text" name="t_name" class="input600"></td>
					</tr>	
					<tr>
						<th>설명</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_explain"></textarea></td>
					</tr>	
					<tr>
						<th>가격</th>
						<td colspan="3"><input type="text" name="t_price" class="input600"></td>
					</tr>	
					<tr>
						<th>순위</th>
						<td colspan="3">
							<select type="text" name="t_rank" class="input600">
						        <option selected ></option>
								<option value="1" >1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
								<option value="4" >4</option>
							</select>
								
						</td>
					</tr>	
					<tr>
						<th>사이즈</th>
						<td colspan="3"><input type="text" name="t_size" class="input600"></td>
					</tr>
		<script type="text/javascript">
		$(function(){					
			function readImage(input) {
			    // 인풋 태그에 파일이 있는 경우
			    if(input.files && input.files[0]) {
			        // 이미지 파일인지 검사 (생략)
			        // FileReader 인스턴스 생성
			        const reader = new FileReader()
			        // 이미지가 로드가 된 경우
			        reader.onload = e => {
			            const previewImage = document.getElementById("preview-image")
			            previewImage.src = e.target.result;
			        }
			        // reader가 이미지 읽도록 하기
			        reader.readAsDataURL(input.files[0])
			    } else {
			    	// 이미지 안올렸으면
					$("#preview-image").attr('src','');
					$("#preview-image").css("display","none");
			    }
			}
			// input file에 change 이벤트 부여
			const inputImage = document.getElementById("input-image");
			inputImage.addEventListener("change", e => {
				$("#preview-image").css("display","block");
			    readImage(e.target)
			})	
		});	
	</script>	
	<style>
		#preview-image{
			border:1px solid gray;
			width:500px;
			height:300px;
			margin-left:50px;
			margin-bottom:10px;
			display:none;
		}
	</style>									
					<tr>
						<th>사진첨부</th>	
						<td colspan="3">
						*이미지 첨부 필수 500px * 300px 권장<br><br>
						<img id="preview-image">
							<input type="file" name="t_attach" class="input600" id="input-image">
						</td>
					</tr>
					<tr>
						<th>등록자</th>
						<td>${sessionName}</td>
						<th>등록일</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
	</div>
	<%@ include file="../common_footer.jsp" %>
</body>
</html>







