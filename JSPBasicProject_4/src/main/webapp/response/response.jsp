<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	response : HttpServletResponse
		=> 전송방식
		   response.setContentType("text/html;charset=UTF-8")
		   = 쿠키 전송
		     response.addCookie(쿠키명)
		     한번에 하나씩밖에 못보냄 => html 따로 쿠키 따로 보내야함
		   = JSP한개파일에서 1개만 전송
		=> 다른 파일 이동
		   response.sendRedirect("파일명") => get방식만 사용이 가능
		=> 헤더 설정
		   다운로드시에 사용
		   setHeader()
		   

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>