<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		JSP 액션 태그
		  => 데이터 관리 
		  	<jsp:setProperty>
		  	<jsp:getProperty>
		  	bean (자바빈)
		  	=> 데이터를 모아서 한번에 전송 / 관리
		  	=> BoardBean
		  		  |
		  	   BoardDTO
		  	      |
		  	   BoadrVO
		  	   : 캡슐화 => 데이터 보호
		  	   	=> 데이터를 감춘다 (은닉화) => private
		  	   	=> 메소드를 통해서 외부와 연결 => public
		  	   	=> getter / setter
		  	   	   private int age;
		  	   	   public int getAge(){}
		  	   	   public void setAge(int age){}
		  	   	   private boolean bash;
		  	   	   =>(X) public void setDash(boolean bash){}
		  	   	   =>(O) public void isDash(boolean bash){}
		  => 메모리 할당 
		  	<jsp:useBean>
		  	
		  => 화면 이동
		  	<jsp:forward>
		  => 화면 포함
		  	<jsp:include>
		  => 데이터 전송
		  	<jsp:param>
		----------------
		prefix => jsp : <jsp:태그명>
 --%>
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
	width: 350px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="contaiter">
		<div class="row">
			<h1>회원 정보</h1>
			<form method="post" action="action_ok.jsp">
			<table class="table">
				<tr>
					<td width=20% class="text-center">이름</td>
					<td width=80%>
					<input type=text name=name size=15 class="input-sm">
					</td>
				</tr>
				<tr>
					<td width=20% class="text-center">성별</td>
					<td width=80%>
					<input type=radio name=sex value=남자 checked>남자
					<input type=radio name=sex value=여자>여자
					</td>
				</tr>
				<tr>
					<td width=20% class="text-center">주소</td>
					<td width=80%>
					<input type=text name=address size=15 class="input-sm">
					</td>
				</tr>
				<tr>
					<td width=20% class="text-center">전화</td>
					<td width=80%>
					<input type=text name=phone size=15 class="input-sm">
					</td>
				</tr>
				<tr>
					<td width=20% class="text-center">관리자</td>
					<td width=80%>
					<input type="checkbox" name="admin" value="true">관리자
					</td>
				</tr>
				<tr>
					<td colspan=2 class="text-center">
					<button class="btn-sm btn-danger">전송</button>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>