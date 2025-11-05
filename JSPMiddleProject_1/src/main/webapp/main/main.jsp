<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8ba7c1bf5703be19d075b1df1555ef2f&libraries=services"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%--
			${main_jsp} => <%=request.getAttribute("main_jsp")%>
				  | session.setAttribute()
			request.setAttribute("main_jsp","파일명")
	 --%>
	<jsp:include page="${main_jsp }"></jsp:include>
</body>
</html>