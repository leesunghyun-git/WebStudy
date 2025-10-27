<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*"%>
    <%@ page import="java.util.*,java.io.*" %>
<%
	//1. 사용자 요청값을 받는다 => page
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	// 2. 현제페이지 지정
	int curpage=Integer.parseInt(strPage);
	// 3. curpage에 해당되는 데이터를 오라클로부터 가지고 온다
	Map map=new HashMap();
	int rowSize=12;
	int start=(rowSize*curpage)-(rowSize-1);
	int end=(rowSize*curpage);
	map.put("start", start);
	map.put("end", end);
	List<FoodVO> list=FoodDAO.foodListData(map);
	int totalpage=FoodDAO.foodTotalPage();
	// 블록별 페이지 나누기
	final int BLOCK=10;
	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage)
		endPage=totalpage;
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

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>	
	<div class="container">
	<%--
		pageContext.include() => 태그형으로 제작
		=> JSP안에 특정부분에 다른 JSP를 추가
		=> 데이터를 공유한다.
		=> Spring
	 --%>
		<jsp:include page="login.jsp"></jsp:include>
		<div style="height:20px"></div>
		<div class="row">
			<%
				for(FoodVO vo:list)
				{
			%>
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="food_detail.jsp?fno=<%=vo.getFNO()%>"> <img src="<%=vo.getPOSTER() %>"
						alt="Lights" style="width: 230px;height:150px">
						<div class="caption">
							<p><%=vo.getNAME() %></p>
						</div>
					</a>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<div style="height:20px"></div>	
		<div class="row text-center">
			<ul class="pagination">
			<%
				if(startPage>1)
				{
			%>
				<li> <a href="food_list.jsp?page=<%=startPage-1%>">&lt;</a>
			<%
				}
				for(int i=startPage;i<=endPage;i++)
				{
			%>
				<li <%=curpage==i?"class=active":"" %>> <a href="food_list.jsp?page=<%=i %>" ><%=i%></a>
			<%
				}
				if(endPage<totalpage)
				{
			%>
				<li> <a href="food_list.jsp?page=<%=endPage+1 %>">&gt;</a>
			<%
				}
			%>
			</ul>
		</div>
	</div>
</body>
</html>