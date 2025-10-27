<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	width: 800px;
	margin: 0px auto;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="containter">
		<div class="row">
			<h1>삭제하기</h1>
			<form method="post" action="delete_ok.jsp">
				<table class="table">
					<tr>
						<td class="text-center">
						<input type="hidden" name="no" value=<%=no %>>
						비밀번호:<input type="password" name=pwd
							size=15 class="input-sm">
						</td>
					</tr>
					<tr>
						<td class="text-center"><input type=submit value="삭제"
							class="btn btn-danger"> <input type=button value="취소"
							class="btn btn-primary" onclick="javascript:history.back()">
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>