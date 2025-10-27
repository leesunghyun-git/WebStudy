<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*"%>
<%
String strno = request.getParameter("no");
int no = Integer.parseInt(strno);
BoardVO vo = BoardDAO.boardDetail(no);

String content = vo.getContent();
content = content.replaceAll("(https?://[\\S]+(\\.png|\\.jpg|\\.jpeg|\\.gif))", "<img src='$1' style='max-width:300px;'>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=vo.getSubject()%>></title>
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
pre {
	font-family:"맑은 고딕";
	background-color: white;border:none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>상세 보기</h1>
			<table class="table">
				<tr>
					<th width=20% class="text-center success">글번호</th>
					<td width=30% class="text-center"><%=vo.getNo()%></td>
					<th width=20% class="text-center success">작성일</th>
					<td width=30% class="text-center"><%=vo.getDbday()%></td>
				</tr>
				<tr>
					<th width=20% class="text-center success">이름</th>
					<td width=30% class="text-center"><%=vo.getName()%></td>
					<th width=20% class="text-center success">조회수</th>
					<td width=30% class="text-center"><%=vo.getHit()%></td>
				</tr>
				<tr>
					<th width=20% class="text-center success">제목</th>
					<td colspan=3><%=vo.getSubject()%></td>
				</tr>
				<tr>
					<th width=20% class="text-center success">내용</th>
					<th colspan=3 class="success"></th>
				</tr>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="400" style="border:1px"><pre>&nbsp; <%= content %></pre></td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.jsp?no=<%=vo.getNo() %>" class="btn btn-sm btn-primary">수정</a>
						<a href="delete.jsp?no=<%=vo.getNo() %>" class="btn btn-sm btn-danger">삭제</a>
						<a href="list.jsp"class="btn btn-sm btn-info">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>