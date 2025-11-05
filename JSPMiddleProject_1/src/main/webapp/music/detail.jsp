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
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td width=30% class="text-center" rowspan=8>
						<table class="table">
							<tr>
								<td colspan=7><img src="${vo.poster }"
									style="width: 420px; height: 400px" id="mainImg"></td>
							</tr>
						</table>
					</td>
					<td colspan=2><h3>${vo.title }&nbsp;<span
								style="color: orange">${vo.rank }</span>
						</h3></td>
				</tr>
				<tr>
					<td width="10%" style="color: gray">순위 변동</td>
					<td width=50%>
							<c:if test="${vo.state eq '유지'}">
								-
							</c:if>
							<c:if test="${vo.state eq '상승'}">
								<font color=red>▲ ${vo.idcrement} </font>
							</c:if>
							<c:if test="${vo.state eq '하강'}">
								<font color=blue>▼ ${vo.idcrement}</font>
							</c:if>
					</td>
				</tr>
				<tr>
					<td width="10%" style="color: gray">가수</td>
					<td width=50%>${vo.singer }</td>
				</tr>
				<tr>
					<td width="10%" style="color: gray">앨범</td>
					<td width=50%>${vo.album }</td>
				</tr>
				<tr>
					<td width="10%" style="color: gray">조회수</td>
					<td width=50%>${vo.hit }</td>
				</tr>
				<tr>
					<td width="10%" style="color: gray">좋아요 수</td>
					<td width=50%>${vo.likecount }</td>
				</tr>
			</table>
			<div style="margin-top:20px"></div>
			<table class="table">
				<tr>
					<td class="text-right">
						<a href="#" class="btn btn-danger">좋아요</a>
						<a href="javascript:history.back()" class="btn btn-primary">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>