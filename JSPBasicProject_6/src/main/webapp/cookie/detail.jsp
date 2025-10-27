<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sist.dao.*,com.sist.vo.*" %>
<%
	int fno=Integer.parseInt(request.getParameter("fno"));
	FoodVO vo=FoodDAO.foodDetailData(fno);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/cookie.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	width: 960px;
	margin: 0px auto;
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="containter">
		<div class="row">
			<h1><%=vo.getNAME() %></h1>
			<table class="table">
				<tr>
					<td rowspan=""></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>