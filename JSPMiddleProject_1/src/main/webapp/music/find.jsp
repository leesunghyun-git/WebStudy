<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<form method="post" action="../music/find.do">
				<select name="column" class="input-lg">
					<option value="title">곡명</option>
					<option value="singer">가수명</option>
					<option value="album">앨범</option>
				</select> <input type="text" size=30 class="input-lg" name="fd"> <input
					type="submit" value="검색" class="btn-lg btn-primary">
			</form>
		</div>
		<div class="row" style="margin-top: 20px">
		<table class="table">
				<thead>
				<tr>
					<th width=30%></th>
					<th width=30%>Title</th>
					<th width=20%>가수</th>
					<th width=20%>앨범</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="vo" items="${list }">
					<tr onclick="location.href='../music/detail.do?no=${vo.no}'" style="cursor:pointer">
						<th width=20%><img src="${vo.poster }"></th>
						<th width=30%>${vo.title }</th>
						<th width=20%>${vo.singer }</th>
						<th width=20%>${vo.album }</th>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>