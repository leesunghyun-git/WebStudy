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


@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 화면 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. HTML을 전송 => 브라우저에 알려준다
		response.setContentType("text/html;charset=UTF-8");
		//2. 어떤 브라우저에 HTML을 전송할지 확인
		PrintWriter out=response.getWriter();
		BoardDAO dao=BoardDAO.newInstance();
		String no=request.getParameter("no");
		int curno=Integer.parseInt(no);
		BoardDTO dto=dao.boardUpdateDetail(curno);
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=\"css/table.css\">");
		out.println("<style type=text/css>");
		out.println("h1 {text-align:center}");
		out.println("table {margin:0px auto}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>수정하기</h1>");
		out.println("<form method=post action=BoardUpdate>");
		out.println("<input type=hidden name=no value="+curno+">");
		out.println("<table id=table_content width=800>");
		out.println("<tr>");
		out.println("<th width=20%>이름</th>");
		out.println("<td width=80%>");
		out.println("<input type=text size=20 name=name value="+dto.getName()+" required>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20%>제목</th>");
		out.println("<td width=80%>");
		out.println("<input type=text size=80 name=subject value="+dto.getSubject()+" required>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20%>내용</th>");
		out.println("<td width=80%>");
		out.println("<textarea rows=10 cols=80 name=content required>"+dto.getContent());
		out.println("</textarea>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20%>비밀번호</th>");
		out.println("<td width=80%>");
		out.println("<input type=password size=20 name=pwd required>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=80% colspan=2 align=center>");
		out.println("<input type=submit value=수정>");
		out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");		
		out.println("</td>");
		out.println("</tr>");
		
		
		out.println("</table>");
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	// 데이터베이스 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// => BoardList로 이동
		// 사용자가 보낸 값을 받는다
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		String no=request.getParameter("no");
		int curno=Integer.parseInt(no);
		BoardDTO dto= new BoardDTO();
		dto.setNo(curno);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setPwd(pwd);
		dto.setContent(content);
		BoardDAO dao=BoardDAO.newInstance();
		dao.boardUpdate(dto);
		response.sendRedirect("BoardList");
	}

}
