<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*"%>
<%
	String msg=request.getParameter("msg");
	String fno=request.getParameter("fno");
	String name=(String)session.getAttribute("name");
	String id=(String)session.getAttribute("id");
	// session에 저장 => 모든 JSP 에서 사용이 가능
	ReplyVO vo=new ReplyVO();
	vo.setId(id);
	vo.setName(name);
	vo.setFno(Integer.parseInt(fno));
	vo.setMsg(msg);
	
	try{
	ReplyDAO.replyInsert(vo);
%>
	<script>
	alert("댓글이 등록되었습니다.");
	location.href="food_detail.jsp?fno=<%=fno%>";
	</script>
<%
	}catch(Exception ex)
	{
%>
		<script>
		alert("잘못된 입력입니다.");
		history.back();
		</script>
<%
	}
%>