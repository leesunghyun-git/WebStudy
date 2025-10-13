package com.sist.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"
				+ ";charset=UTF-8");
		// text/xml(XML) , text/plain(JSON)
		// 출력 => 메모리 출력 => 해당 브라우저에서 읽어 간다
		PrintWriter out=response.getWriter();
		BoardDAO dao=BoardDAO.newInstance();
		
		// 사용자가 보내준 값을 받는다 => request
		// BoardList?page=2
		/*
		 *  BoardList => null
		 *  BoardList?page=""
		 * 
		 */
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int total=dao.boardTotalPage();
		List<BoardDTO> list=dao.boardListData(curpage);
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		// 전송
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=\"css/table.css\">");
		out.println("<style type=text/css>");
		out.println("h1 {text-align:center}");
		out.println("table {margin:0px auto}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>자유게시판</h1>");
		out.println("<table id=table_content width=800>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<a href=\"BoardInsert\">새글</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table id=table_content width=800>");
		out.println("<tr>");
		out.println("<th width=10%>번호</th>");
		out.println("<th width=45%>제목</th>");
		out.println("<th width=15%>이름</th>");
		out.println("<th width=20%>작성일</th>");
		out.println("<th width=10%>조회수</th>");
		out.println("</tr>");
		for(BoardDTO dto:list)
		{	
			
			out.println("<tr class=dataTr>");
			out.println("<td width=10% align=center>"+dto.getNo()+"</td>");
			out.println("<td width=45%><a href=\"BoardDetail?no="+dto.getNo()+"\">"+dto.getSubject()+"</a>");
			if(today.equals(dto.getDbday()))
			{
				out.print("<sup><img src=images/new.gif></sup>");
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+dto.getName()+"</td>");
			out.println("<td width=20% align=center>"+dto.getDbday()+"</td>");
			out.println("<td width=10% align=center>"+dto.getHit()+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("<table id=table_content width=800>");
		out.println("<tr>");
		out.println("<td align=left>");
		out.println("<select name=fs>");
		out.println("<option value=name>이름</option>");
		out.println("<option value=subject>제목</option>");
		out.println("<option value=content>내용</option>");
		out.println("</select>");
		out.println("<input type=text name=ss size=25>");
		out.println("<input type=submit value=검색>");
		out.println("</td>");
		out.println("<td align=right>");
		out.println("<a href=\"BoardList?page="+(curpage>1?curpage-1:curpage)+"\">이전</a>&nbsp;");
		out.println(curpage+" page / "+total+"&nbsp;");
		out.println("<a href=\"BoardList?page="+(curpage<total?curpage+1:curpage)+"\">다음</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
