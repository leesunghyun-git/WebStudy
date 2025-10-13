package com.sist.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardDTO;
/*
 * 	Spring
 *  	@RequestMapping
 *  	@GetMapping
 *  	@PostMapping
 * 
 * 
 */

@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		BoardDAO dao=BoardDAO.newInstance();
		String no=request.getParameter("no");
		int curno=Integer.parseInt(no);
		BoardDTO dto=dao.boardDetail(curno);
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=\"css/table.css\">");
		out.println("<style type=text/css>");
		out.println("h1 {text-align:center}");
		out.println("table {margin:0px auto}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>내용보기</h1>");
		out.println("<table id=table_content width=800>");
		
		out.println("<tr>");
		out.println("<th width=20%>번호</th>");
		out.println("<td width=30%>"+dto.getNo()+"</td>");
		out.println("<th width=20%>작성일</th>");
		out.println("<td width=30%>"+dto.getDbday()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20%>이름</th>");
		out.println("<td width=30%>"+dto.getName()+"</td>");
		out.println("<th width=20%>조회수</th>");
		out.println("<td width=30%>"+dto.getHit()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20%>제목</th>");
		out.println("<td colspan=3>"+dto.getSubject()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 height=200 valign=top align=left>"+dto.getContent()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=4 align=right>");
		out.println("<a href=\"BoardUpdate?no="+dto.getNo()+"\">수정</a>&nbsp;");
		out.println("<a href=\"#\">삭제</a>&nbsp;");
		out.println("<a href=\"BoardList\">목록</a>");
		
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}

}
