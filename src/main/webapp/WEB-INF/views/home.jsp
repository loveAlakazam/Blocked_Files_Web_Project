<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<title>파일확장자 차단</title>
</head>
<link rel="stylesheet" href="resources/css/home.css">

<body>
<div class="container">
	<div class="table-wrapper">
		<h1>파일 확장자 차단</h1>
		<table class="table">
			<tr class="trow">
				<td class="tlabel">고정 확장자</td>
				<td colspan="3">
					<div class="content">
					
						<label>
							<input name="bat" class="file-type" type="checkbox">
							bat
						</label>
						
						<label>
							<input name="cmd" class="file-type" type="checkbox">
							cmd
						</label>
						
						<label>
							<input name="com" class="file-type" type="checkbox">
							com
						</label>
						
						<label>
							<input name="exe" class="file-type" type="checkbox">
							exe
						</label>
						
						<label>
							<input name="scr" class="file-type" type="checkbox">
							scr
						</label>
						
						<label>
							<input name="js" class="file-type" type="checkbox">
							js
						</label>
					</div>
				</td>		
			</tr>
			
			<tr class="trow">
				<td class="tlabel" rowspan="2">커스텀확장자</td>
				<td colspan="3">
					<div class="content">
						<input type="text" name="fileName" id="fileName" placeholder="확장자 입력(영소문자 및 숫자 조합만 가능)">
						
						<c:if test="${customCnt<=200 }">
							<input type="submit" value="+추가" id="addFile">
						</c:if>
						
						<!-- 200개가 넘으면 disable시킨다. -->
						<c:if test="${customCnt>200 }">
							<input type="submit" value="+추가" id="addFile" disabled>
						</c:if>
					</div>
				</td>
			</tr>
				
			<tr class="trow">
				<td colspan="3">
					<div class="content">
						<div class="blocked-file-list">
							<!-- 저장된 파일개수 -->
							<div><span id="cnt">${customCnt }</span>/200</div>
							
							<!-- 커스톰파일들을 저장하는 컨테이너 -->
							<div class="blocked-files">
								<c:if test="${customList !=null}">
									<c:forEach var="custom" items="${customList}">
										<!-- 차단 파일 한개 -->
										<div class="blocked-file">
											<span class="file-name">${custom.name }</span>
											<span class="delete-btn">X</span>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</td>
			</tr>

		</table>
	</div>
</div>
</body>
<script>

$(function(){
	//추가 버튼을 눌렀을 때 동작하는 함수.
	$(document).on('click', '#addFile', function(){
		//입력한 파일  확장자
		let customFileName= $('#fileName').val();
		console.log(customFileName);
		
		//정규표현식(영어 소문자, 숫자만 가능하게한다.)
		//특수문자도 허용하지 않음.
		let regExpress= /^[a-z][a-z0-9+]{1,20}$/; //영소문자+숫자 만 가능
		let testResult= regExpress.test(customFileName);
		
		if(!testResult){
			alert('올바르지 않은 확장자 표기법입니다!');
		}else{
			$.ajax({
				url:'insertBlockedFile.fi',
				data:{ name:customFileName},
				type:'post',
				success:function(response){
					alert(response);
				}
			});
			window.location.reload();
		}
	});
	
	//삭제버튼을 눌렀을 때 동작하는 함수
	//가장 가까이 있는 .blocked-file을 삭제.
	$(document).on('click', '.delete-btn', function(){
		//$(this): 현재 선택된 X버튼
		//console.log($(this));
		
		//_selectedFile: 선택된 파일 확장자명
		let _selectedFile= $(this).closest('.blocked-file').find('.file-name').text();
		console.log(_selectedFile); 
		
		$.ajax({
			url:'deleteBlockedFile.fi',
			data:{name: _selectedFile},
			type:'post',
			success:function(response){
				alert(response);
			}
		});
		window.location.reload();
	});

});


</script>

</html>