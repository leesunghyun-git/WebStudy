<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sist.vo.*" %>
<%
	MemberVO mem=new MemberVO();
	mem.setMno(1);
	mem.setName("홍길동");
	mem.setAddress("서울");
	mem.setPhone("010-1111-1111");
	
	request.setAttribute("vo",mem);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫번째 출력</h1>
	번호:${vo.getMno()}<br>
	이름:${vo.getName()}<br>
	주소:${vo.getAddress()}<br>
	전화번호:${vo.getPhone()}<br>
	<h1>두번째 출력</h1>
	번호:${vo.mno}<br>
	이름:${vo.name}<br>
	주소:${vo.address}<br>
	전화번호:${vo.phone}<br>
</body>
</html>