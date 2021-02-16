<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<title>파일확장자 차단</title>
</head>
<style>
html, body{
	margin:0;
	padding:0;
}

.container{
	width: 100%;
	position: relative;
}

.table-wrapper{
	width: 50%;
	margin: 100px auto;
	position: relative;
}

.table{
	border: 1px solid;
	
}

.trow{
	border: 1px solid;
}

.tlabel,
.content{
	padding: 15px;
}

#fileName{
	width: 250px;
}

.blocked-file-list{
	width: 500px;
	/* height: 100px;*/
	overflow:auto;
}

#addFile{
	background-color: gray;
	color: #fff;
	cursor:pointer;
}

#addFile:hover{
	background-color: #555c57;
	font-weight: bolder;
}

#fileName,
#addFile,
.blocked-file-list{
	padding:5px;
	border-radius: 5px;
	border: 1px solid gray;
}

.blocked-files{
	margin: 10px 0;
	display:flex;
	flex-direction: row;
	flex-wrap:wrap;
}


/*커스텀확장자 차단파일 1개*/
.blocked-file{
	padding: 5px;
	border-radius: 5px;
	border: 1px solid gray;
	display:inline-block;
	margin: 5px;
}

.file-name{
	padding: 0 10px;
}

.delete-btn{
	color: black;
	font-weight: bolder;
	cursor:pointer;
}

.delete-btn:hover{
	color: #bf2011;
}

</style>

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
						<input type="text" name="fileName" id="fileName">
						<input type="submit" value="+추가" id="addFile">
					</div>
				</td>
			</tr>
				
			<tr class="trow">
				<td colspan="3">
					<div class="content">
						<div class="blocked-file-list">
							<div><span id="cnt">0</span>/200</div>
							<div class="blocked-files">
							
								<!-- 차단 파일 한개 -->
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
								<div class="blocked-file">
									<span class="file-name">sh</span>
									<span class="delete-btn">X</span>
								</div>
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
$.(ajax)

</script>

</html>