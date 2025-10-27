<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sist.dao.*,com.sist.vo.*" %>
<%--


 --%>
<%
	int fno=Integer.parseInt(request.getParameter("fno"));
	FoodVO vo=FoodDAO.foodDetailData(fno);
	
	// 댓글처리
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
	width: 960px;
	margin: 0px auto;
} 
</style>
</head>
<body>
	<div class="containter">
		<div class="row">
			<h1 class="text-center"><%=vo.getNAME() %></h1>
			<table class="table">
				<tr>
					<td width=30% class="text-center" rowspan="9"><img src="<%=vo.getPOSTER() %>" style="width:100%">
			
					</td>
					<td colspan="2"><h2><%=vo.getNAME() %>&nbsp;<span style="color:orange;font-size:7;"><%=vo.getSCORE() %></span></h2>
					</td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">음식종류</td>
					<td width="55%"><%=vo.getTYPE() %></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">주소</td>
					<td width="55%"><%=vo.getADDRESS()%></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">가격</td>
					<td width="55%"><%=vo.getPRICE() %></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">영업시간</td>
					<td width="55%"><%=vo.getTIME() %></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">전화번호</td>
					<td width="55%"><%=vo.getPHONE() %></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">주차</td>
					<td width="55%"><%=vo.getPARKING() %></td>
				</tr>
				<tr>
					<td style="corlor:gray" width="15%">테마</td>
					<td width="55%"><%=vo.getTHEME() %></td>
				</tr>
			</table>
			<table class="table">
			<tr>
			<td colspan=2><%=vo.getCONTENT() %></td>
			</tr>
				<tr>
					<td class="text-right">
						<a href="food-list.jsp" class="btn btn-sm btn-primary">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>