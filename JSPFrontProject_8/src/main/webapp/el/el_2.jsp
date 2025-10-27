<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		EL => 내장 객체
		EL => VO 출력
		------------
		param		==> request.getParameter
		paramValue  ==> request.getParameterValues()
		requestScope => request.getAttribute()
		sessionScope => session.getAttribute()
		applicationScope => application.getAttribute()
		-----------
		전체 공유
		${일반변수(X)}
		EL => VO출력
 --%>
<!DOCTYPE html>
<%
	String name="홍길동";
	request.setAttribute("name1", "홍길동");
	// 한개의 파일에서 직접
	session.setAttribute("name2","심청이");
	// id비교
	application.setAttribute("name3","박문수");
	// 전체에서 공유
	
	/*
		${key이름}
		=> Scope가 생략이 가능
			request = session = application
	*/
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:${name1}<br>
	이름:${name2}<br>
	이름:${name3}<br>
</body>
</html>