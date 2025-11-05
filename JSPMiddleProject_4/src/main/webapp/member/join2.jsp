<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#postBtn').click(function(){
		window.open('post.jsp',"postfind","width=500,height=350,scrollbars=yes resizable=no")
	
	})


})

</script>
<title>Insert title here</title>
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin: 0px auto;
	width:800px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">회원 가입</h1>
			<form name="frm">
			<table class="table">
			<tr>
				<th width=20%>
				
				</th>
				<th width=80%>
				<input type="text" size=7 name="post1" readonly class="input-sm">-
				<input type="text" size=7 name="post2" readonly class="input-sm">
				<input type="button" value="우편번호 검색" id="postBtn" class="btn-sm btn-danger">
				</th>
			</tr>
			<tr>
				<th width=20%>주소</th>
				<th width=80%><input type=text name=addr size=50 readonly class="input-sm"></th>
			</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>