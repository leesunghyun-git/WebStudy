<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	width: 1200px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-right">
					<a href="../music/list.do?cno=1" ${cno eq 1?"class='btn btn-warning disabled'":"class='btn btn-info'" }>종합순위</a> 
					<a href="../music/list.do?cno=2" ${cno eq 2?"class='btn btn-warning disabled'":"class='btn btn-info'" }>가요</a> 
					<a href="../music/list.do?cno=3" ${cno eq 3?"class='btn btn-warning disabled'":"class='btn btn-info'" }>POP</a> 
					<a href="../music/list.do?cno=4" ${cno eq 4?"class='btn btn-warning disabled'":"class='btn btn-info'" }>OST</a>
					<a href="../music/list.do?cno=5" ${cno eq 5?"class='btn btn-warning disabled'":"class='btn btn-info'" }>트롯</a> 
					<a href="../music/list.do?cno=6" ${cno eq 6?"class='btn btn-warning disabled'":"class='btn btn-info'" }>JAZZ</a>
					<a href="../music/list.do?cno=7" ${cno eq 7?"class='btn btn-warning disabled'":"class='btn btn-info'" }>CLASSIC</a></td>
				</tr>
			</table>
			<table class="table">
				<thead>
				<tr>
					<th width=20%></th>
					<th width=5%>증감</th>
					<th width=5%>랭킹</th>
					<th width=30%>Title</th>
					<th width=20%>가수</th>
					<th width=20%>앨범</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="vo" items="${list }">
					<tr onclick="location.href='../music/detail.do?no=${vo.no}&cno=${cno }&page=${page }'" style="cursor:pointer">
						<th width=20%><img src="${vo.poster }"></th>
						<th width=5%>
							<c:if test="${vo.state eq '유지'}">
								-
							</c:if>
							<c:if test="${vo.state eq '상승'}">
								<font color=red>▲ ${vo.idcrement} </font>
							</c:if>
							<c:if test="${vo.state eq '하강'}">
								<font color=blue>▼ ${vo.idcrement}</font>
							</c:if>
						</th>
						<th width=5%>${vo.rank }</th>
						<th width=30%>${vo.title }</th>
						<th width=20%>${vo.singer }</th>
						<th width=20%>${vo.album }</th>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row text-center" style="margin-top:10px">
			<ul class="pagination">
				<c:if test="${startPage > 1}" >
				<li><a href="../music/list.do?cno=${cno }&page=${startPage-1 } ">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage}">
				<li ${i==page?"class=active":""}><a href="../music/list.do?cno=${cno }&page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage < totalpage }">
				<li><a href="../music/list.do?cno=${cno }&page=${endPage+1 }">&gt;</a></li>
				</c:if>
			</ul>
		</div>
		</div>
	</div>
</body>
</html>