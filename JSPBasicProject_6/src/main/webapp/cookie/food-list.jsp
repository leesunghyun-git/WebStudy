<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sist.vo.*,com.sist.dao.*"%>
<%--
	Cookie : 내장 객체가 아니다 => 필요시에 생성
	1. 생성
	   Cookie cookie = new Cookie("키","값")
	   							  ---  ----
	   							  	     | 문자열
	   							  | 중복없이 => 중복되는 경우 덮어쓴다
	2. 기간 설정
		cookie.setMaxAge(초단위)
				=> 60*60*24
	3. 브라우저로 전송
		response.addCookie(cookie)
	---------------------------------------
	1. 쿠키 읽기
		Cookie[] cookies=request.getCookies()
	2. 소멸
		cookie.setMaxAge(0)

 --%>
<%
// 1. 사용자가 보낸 데이터를 받는다 => 페이지 요청
// food_list.jsp?page=2
String strPage = request.getParameter("page");
// 첫페이지 문제 => 페이지 지정이 어렵다 => default
if (strPage == null)
	strPage = "1";
// 1-1 현재페이지를 저장
// 2. 데이터베이스 값을 읽어 온다
int curpage = Integer.parseInt(strPage);
int rowSize = 12;
int start = (rowSize * curpage) - (rowSize - 1); // 1, 13, 25
int end = rowSize * curpage;
Map<String, Integer> map = new HashMap<>();
map.put("start", start);
map.put("end", end);

List<FoodVO> list = FoodDAO.foodListData(map);
int totalPage = FoodDAO.foodTotalPage();

// 블록별 처리
final int BLOCK = 10;
int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
if (endPage>totalPage)
{
	endPage=totalPage;
}

	Cookie[] cookies=request.getCookies();
	List<FoodVO> cList=new ArrayList<FoodVO>();
	if(cookies!=null)
	{
		// 최신순
		for(int i=cookies.length-1;i>=0;i--)
		{
			// food_ 시작하는 키만 가지고 온다
			if(cookies[i].getName().startsWith("food_"))
			{
				// 값을 읽기
				FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(cookies[i].getValue()));
				cList.add(vo);
				
			}
			
			if(cList.size()>=10)
			{
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/cookie.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
	</script>
<script type="text/javascript">
$(function(){
	// mounted() = VueJS , window.onload=function(){}
	$
})

</script>
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
		<div class="row">
		<% 
			for(FoodVO vo:list)
			{
		%>
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="food_detail_before.jsp?fno=<%=vo.getFNO()%>"> <img src="<%=vo.getPOSTER() %>"
						alt="Lights" style="width: 230px;height:150px">
						<div class="caption">
							<p><%=vo.getNAME() %></p>
							<p><%=vo.getADDRESS() %></p>
						</div>
					</a>
				</div>
			</div>
		<%
			}
		%>
		</div>
		<div style="height: 10px"></div>
		<div class="row text-center">
			<ul class="pagination">
			<% 
				if(startPage>1)
				{
			%>
					<li><a href="food-list.jsp?page=<%=startPage-1%>">&lt;</a></li>
			<%	
				}
			%>
				
				<%
					for(int i=startPage;i<=endPage;i++)
					{
				%>
					<li <%=curpage==i?"class=active":"" %>><a href="food-list.jsp?page=<%=i%>"><%=i %></a></li>
				<%		
					}
					if(endPage<totalPage){
				%>
				<li><a href="food-list.jsp?page=<%=endPage+1 %>">&gt;</a></li>	
				<%
					}
				%>	
			</ul>
		</div>
	</div>
	<div style="height:10px">
	</div>
	<div class="row">
		<div class="recent-container">
			<h3>최근 방문한 맛집</h3>
			<a href="cookie_all_view.jsp" class="btn btn-sm btn-info">전체 보기</a>
			<a href="cookie_all_remove.jsp" class="btn btn-sm btn-warning">전체 삭제</a>
			<div class="recent-list">
			<% 
				int i=0;
				for(FoodVO vo:cList)
				{
					if(i>9) break;
			%>
				<a class="recent-card" href="food_detail_before.jsp?fno=<%= vo.getFNO() %>" %>
					<div class="thumb">
						<img src="<%=vo.getPOSTER()%>">
					</div>
					<div class="meta">
						<div class="title"><%= vo.getNAME() %></div>
					</div>
					</a>
					
					
				
			<% 
					i++;
					
				}
			%>
			</div>
		</div>
	</div>
</body>
</html>