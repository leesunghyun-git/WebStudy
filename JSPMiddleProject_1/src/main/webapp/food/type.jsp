<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin:0px auto;
	width:960px;
}
p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<a href="../food/type.do?type=한식" class="btn btn-sm btn-danger">한식</a>
			<a href="../food/type.do?type=양식" class="btn btn-sm btn-success">양식</a>
			<a href="../food/type.do?type=중식" class="btn btn-sm btn-primary">중식</a>
			<a href="../food/type.do?type=일식" class="btn btn-sm btn-warning">일식</a>
			<a href="../food/type.do?type=분식" class="btn btn-sm btn-info">분식</a>
		</div>
		<div style="height:20px"></div>
		<div class="row">
			<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="../food/detail.do?fno=${vo.fno }&page=${curpage}"> <img src="${vo.poster }"
						alt="Lights" style="width: 100%">
						<div class="caption">
							<p>${vo.name }</p>
						</div>
					</a>
				</div>
			</div>
			</c:forEach>
		</div>
		<div style="height:30px"></div>
		<div class="row text-center" style="margin-top:10px">
			<ul class="pagination">
				<c:if test="${startPage > 1}" >
				<li><a href="../food/type.do?type=${type }&page=${startPage-1 } ">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage}">
				<li ${i==curpage?"class=active":""}><a href="../food/type.do?type=${type }&page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage < totalPage }">
				<li><a href="../food/type.do?type=${type }&page=${endPage+1 }">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>