<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
	let sawon=[]
	let detail={}
	window.onload=async ()=>{
		//지역변수
		await axios.get('../emp/list.do')
		.then(response=>{
			console.log(response.data)
			sawon=response.data
		})
	
	let html='';
	// sawon.map(sa=>{})
	// sawon.forEach(sa=>{})
	for(let sa of sawon)
	{
	html+='<tr>'
		+'<td>'+sa.empno+'</td>'
		+'<td>'+sa.ename+'</td>'
		+'<td>'+sa.job+'</td>'
		+'<td>'+sa.dbday+'</td>'
		+'<td>'+sa.deptno+'</td>'
		+'</tr>'
	}
	document.querySelector('tbody').innerHTML=html;

}
	
</script>
</head>
<body>
	<div class="container">
		<h1 class="text-center">사원 목록</h1>
		<div class="col-sm-8">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">사번</th>
						<th class="text-center">이름</th>
						<th class="text-center">직위</th>
						<th class="text-center">입사일</th>
						<th class="text-center">부서번호</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
		<div class="col-sm-4">
			<table class="table">
				<tr >
					<th width=30%>사번
					</th>
					<td width=70% id="empno">
					</td>
				</tr>
				<tr >
					<th width=30%>이름
					</th>
					<td width=70% id="ename">
					</td>
				</tr>
				<tr >
					<th width=30%>직위
					</th>
					<td width=70% id="job">
					</td>
				</tr>
				<tr >
					<th width=30%>사수
					</th>
					<td width=70% id="mgr">
					</td>
				</tr>
				<tr >
					<th width=30%>입사일
					</th>
					<td width=70% id="hiredate"> 
 					</td>
				</tr>
				<tr >
					<th width=30%>급여
					</th>
					<td width=70% id="sal">
					</td>
				</tr>
				<tr >
					<th width=30%>성과급
					</th>
					<td width=70% id="comm">
					</td>
				</tr>
				<tr >
					<th width=30%>부서
					</th>
					<td width=70% id="deptno">
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>