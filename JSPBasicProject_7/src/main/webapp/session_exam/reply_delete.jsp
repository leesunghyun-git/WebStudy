<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	String rno=request.getParameter("rno");
	String fno=request.getParameter("fno");
	
	try
	{
		ReplyDAO.replyDelete(Integer.parseInt(rno));
		
%>
	<script>
		alert("삭제되었습니다.");	
		location.href="food_detail.jsp?fno=<%=fno%>"
	</script>
<%

	}catch(Exception ex)
	{
%>
	<script>
		alert("오류가 발생했습니다.");
		history.back();
	</script>
<%
	}

%>