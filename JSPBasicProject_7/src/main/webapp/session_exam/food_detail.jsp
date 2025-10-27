<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sist.vo.*,com.sist.dao.*,java.util.*"%>
<%
//1. 사용자 보내준 데이터 받기
String fno = request.getParameter("fno");
FoodVO vo = FoodDAO.foodDetailData(Integer.parseInt(fno));
String id = (String) session.getAttribute("id");
// 댓글
List<ReplyVO> list=ReplyDAO.replyListData(Integer.parseInt(fno));


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
	<div class="container">
		<div class="row">
			<jsp:include page="login.jsp"></jsp:include>
		</div>
		<div style="height: 20px"></div>
		<div class="row">
			<table class="table">
				<tr>
					<td rowspan=8 width=30% class="text-center"><img
						src="<%=vo.getPOSTER()%>" style="width: 240px; height: 350px"></td>
					<td colspan=2>
						<h3><%=vo.getNAME()%>&nbsp;<span style="color: orange;"><%=vo.getSCORE()%></span>
						</h3>
					</td>
				</tr>
				<tr>
					<td width=20% style="color: gray">주소</td>
					<td width=50%><%=vo.getADDRESS()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">전화</td>
					<td width=50%><%=vo.getPHONE()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">음식종류</td>
					<td width=50%><%=vo.getTYPE()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">영업시간</td>
					<td width=50%><%=vo.getTIME()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">가격대</td>
					<td width=50%><%=vo.getPRICE()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">주차</td>
					<td width=50%><%=vo.getPARKING()%></td>
				</tr>
				<tr>
					<td width=20% style="color: gray">테마</td>
					<td width=50%><%=vo.getTHEME()%></td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td><%=vo.getCONTENT()%></td>
				</tr>
				<tr>
					<td class="text-right"><a href="food_list.jsp"
						class="btn-sm btn-primary">목록</a></td>
				</tr>
			</table>
		</div>
		<div style="height: 30px"></div>
		<div class="row">
			<h3>댓글</h3>
			<hr width="800">
			<table class="table">
				<tr>
					<td>
					<%
						for(ReplyVO rvo:list)
						{
					%>
						<table class="table">
							<tr>
								<td class="text-left"><%=rvo.getName() %>&nbsp;<%=rvo.getDbday() %></td>
								<td class="text-right">
								<%
									if(rvo.getId().equals(id))
									{
								%>
									<a href="reply_update.jsp?rno=<%=rvo.getRno() %>&fno=<%=fno %>" class="btn btn-xs btn-danger">수정</a>
									<a href="reply_delete.jsp?rno=<%=rvo.getRno() %>&fno=<%=fno %>" class="btn btn-xs btn-success">삭제</a>
								<%
									}
								%>
								</td>
							</tr>
							<tr>
								<td colspan=2><pre
										style="white-space: pre-wrap; border: none; background-color: white"><%=rvo.getMsg() %></pre>
								</td>
							</tr>
						</table>
					<%
						}
					%>
					</td>
				</tr>
			</table>
			<%
			if (id != null) {
			%>
			<table class="table">
				<tr>
					<td>
						<form action="reply_insert.jsp" method="post">
							<textarea rows="6" cols="122" name="msg"
								style="float: left; resize: none"></textarea>
							<input type="hidden" name="fno" value="<%=vo.getFNO()%>">
							<input type="submit" value="댓글쓰기" class="btn-info"
								style="float: left; height: 126px;">
						</form>
					</td>
				</tr>
			</table>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>