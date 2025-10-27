<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 1. 사용자 보내준 값을 받는다
String name = request.getParameter("name");
String sex = request.getParameter("sex");
String loc = request.getParameter("loc");
String content = request.getParameter("content");
String[] hobby = request.getParameterValues("hobby");
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
	width: 350px;
	margin: 0px auto;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>
	<div class=container>
		<div class=row>
			<table class="table table-hover">
				<tr>
					<th>이름</th>
					<td><%=name %></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><%=loc %></td>
				</tr>
								<tr>
					<th>지역</th>
					<td><%=loc %></td>
				</tr>
				<tr>
					<th>소개</th>
					<td><%=content %></td>
				</tr>	
				<tr>
					<th>취미</th>
					
					<td>
					<ul>
					<%
						try
					{
						for(String hy:hobby)
						{
					%>
							<li><%= hy %></li>
					<%
						}
						
					} catch(Exception ex)
					{
					%>	
						<li>선택된 취미가 없습니다.</li>
					<%
					}
					%></ul></td>
				</tr>
				<tr>
					<td colspan=2>
					서버IP:<%=request.getServerName() %><br>
					PORT:<%=request.getProtocol() %><br>
					URL:<%=request.getRequestURL() %><br>
					URI:<%=request.getRequestURI() %><br>
					ContextPath:<%=request.getContextPath() %><br>
					사용자IP:<%=request.getRemoteAddr() %><br>
					전송방식:<%=request.getMethod() %>
					
					</td>
				
				</tr>
			</table>
		</div>
	</div>
</body>
</html>