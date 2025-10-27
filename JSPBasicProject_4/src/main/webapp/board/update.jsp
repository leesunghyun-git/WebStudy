<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*"%>
<%
	String strno=request.getParameter("no");
	int no = Integer.parseInt(strno);
	BoardVO vo = BoardDAO.boardUpdateData(no);

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
	<div class="container">
		<div class="row">
			<h1>수정</h1>
			<form method="post" action="update_ok.jsp">
			<input type="hidden" name="no" value="<%=vo.getNo() %>">
				<table class="table">
					<tr>
						<td width=15%>이름</td>
						<td width=85%><input type=text name=name size=20
							class="input-sm" value="<%=vo.getName() %>"required></td>
					</tr>
					<tr>
						<td width=15%>제목</td>
						<td width=85%><input type=text name=subject size=100
							class="input-sm" value="<%=vo.getSubject()%>" required></td>
					</tr>
					<tr>
						<td width=15%>내용</td>
						<td width=85%><textarea rows="10" cols=100 name="content" required><%=vo.getContent() %></textarea>
						</td>
					</tr>
					<tr>
						<td width=15%>비밀번호</td>
						<td width=85%><input type=password name=pwd size=20
							class="input-sm" required></td>
					</tr>
					<tr>
						<td class="text-center" colspan="2"><input type=submit
							value="수정" class="btn-sm btn-info"> <input type=button
							value="취소" class="btn-sm btn-info"
							onclick="javascript:history.back()"></td>
					</tr>
				</table>
			</form>

		</div>


	</div>
</body>
</html>