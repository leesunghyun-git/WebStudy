<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*,java.util.*"%>
<!DOCTYPE html>
<%
	List<EmpVO> list=EmpDAO.empdeptJoinData();
	
%>
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
			<h1>사원 목록</h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="text-center success">사번</th>
						<th class="text-center success">이름</th>
						<th class="text-center success">직위</th>
						<th class="text-center success">입사일</th>
						<th class="text-center success">급여</th>
						<th class="text-center success">부서명</th>
						<th class="text-center success">근무지역</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(EmpVO vo:list)
						{
					%>
						<tr>
							<td class="text-center"><%=vo.getEmpno() %></td>
							<td class="text-center"><%=vo.getEname() %></td>
							<td class="text-center"><%=vo.getJob() %></td>
							<td class="text-center"><%=vo.getDbday() %></td>
							<td class="text-center"><%=vo.getSal() %></td>
							<td class="text-center"><%=vo.getDvo().getDname() %></td>
							<td class="text-center"><%=vo.getDvo().getLoc() %></td>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>