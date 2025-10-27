<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%@ page import="com.sist.vo.*" %>
<%
	// 사용자가 보내준 값 받기
	String strno = request.getParameter("no");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String pwd = request.getParameter("pwd");
	int no = Integer.parseInt(strno);
	
	BoardVO vo = new BoardVO();
	vo.setNo(no);
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	boolean bcheck=BoardDAO.boardUpdate(vo);
	if(bcheck)
	{
		response.sendRedirect("detail.jsp?no="+no);
		
	}
	else
	{
		out.println("<script>");
	    out.println("alert(\"비밀번호가 틀립니다\");");
	    out.println("history.back();");
	    out.println("</script>");
	}

%>