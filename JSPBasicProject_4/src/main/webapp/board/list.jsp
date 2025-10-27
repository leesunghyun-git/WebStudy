<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.sist.vo.*,com.sist.dao.*,java.util.*" %>
<%
	// 1. 사용자 요청 정보 => 페이즈를 받는다
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	int curpage=Integer.parseInt(strPage);
	int rowSize=10;
	int start=(rowSize*curpage)-(rowSize-1);
	int end=(rowSize*curpage);
	Map<String,Integer> map=new HashMap<>();
	map.put("start",start);
	map.put("end",end);
	List<BoardVO> list=BoardDAO.boardListData(map);
	int totalpage=BoardDAO.boardTotalPage();
	//2. 데이터 베이스 연결
	//3. 읽어온 데이터를 화면 출력
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
			<h1>자유 게시판</h1>
			<table class="table">
				<tr>
					<td>
						<a href="insert.jsp" class="btn btn-sm btn-danger">새글</a>
					</td>
				</tr>
			</table>
			<table class="table table-striped">
				<thead>
					<tr>
						<th width=10% class="text-center">번호</th>
						<th width=55% class="text-center">제목</th>
						<th width=10% class="text-center">이름</th>
						<th width=15% class="text-center">작성일</th>
						<th width=10% class="text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(BoardVO vo:list)
						{
					%>
							<tr onclick="location.href='detail.jsp?no=<%=vo.getNo()%>'" style="cursor:pointer">
								<td width=10% class="text-center"><%=vo.getNo() %></td>
								<td width=55%><%=vo.getSubject() %></td>
								<td width=10% class="text-center"><%=vo.getName() %></td>
								<td width=15% class="text-center"><%=vo.getDbday() %></td>
								<td width=10% class="text-center"><%=vo.getHit() %></td>
							</tr>
					<%
							
						}
					%>
					<tr>
						<td colspan="5" class="text-center">
						<a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-danger">이전</a>
						<%=curpage %> page / <%=totalpage %> pages
						<a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-primary">다음</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>