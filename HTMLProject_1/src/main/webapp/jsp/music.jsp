<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="com.sist.dao.*" %>
<%
	String cno=request.getParameter("cno");
	// main에서 코딩
	if(cno==null)
	{
		cno="1";
	}
	MusicDAO dao=MusicDAO.newInstance();
	List<String> list=dao.MusicListData(cno);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 지니뮤직 TOP 100</h1>
<a href="music.jsp?cno=1">TOP 100</A>
<a href="music.jsp?cno=2">가요</A>
<a href="music.jsp?cno=3">트롯</A>
<a href="music.jsp?cno=4">OST</A>
<a href="music.jsp?cno=5">OST</A>
<a href="music.jsp?cno=6">OST</A>
<a href="music.jsp?cno=7">OST</A><p>
	<% 
	    int i=1;
		for(String title : list)
		{
	%>	
			<%=i %>.<%=title %><br>
	<%		
			if(i==50)
			{
	%>			<hr>
	<%
			}
			i++;	
		}
		
	%>
</body>
</html>