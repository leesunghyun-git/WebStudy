package com.sist.main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

/**
 * Servlet implementation class FoodDetail
 */
@WebServlet("/FoodDetail")
public class FoodDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String fno = request.getParameter("fno");
		// request: 사용자 정보 (IP, PORT)
		// 사용자가 보내준 데이터를 가지고 있다
		// Map방식 ==> ?fno=1 => map.put("fno",)
		// DB연동
		int curfno=Integer.parseInt(fno);
		FoodVO vo=FoodDAO.foodDetailData(curfno);
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
	    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		out.println(".container{margin-top:50px;}");
		out.println(".row{width:800px;margin:0px auto;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>"); 
		out.println("<div class=row>");
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<td width=30% class=text-center rowspan=8>");
		out.println("<img src="+vo.getPoster()+" style=\"width:100%\">");
		out.println("</td>");
		out.println("<td culspan=2><h2>"+vo.getName()+"&nbsp;<span style=\"color:orange\">"+vo.getScore()+"</span></h2>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">주소</td>");
		out.println("<td width=55%>"+vo.getAddress()+"</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">전화</td>");
		out.println("<td width=55%>"+vo.getPhone()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">음식종류</td>");
		out.println("<td width=55%>"+vo.getType()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">영업시간</td>");
		out.println("<td width=55%>"+vo.getTime()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">주차</td>");
		out.println("<td width=55%>"+vo.getParking()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">가격태</td>");
		out.println("<td width=55%>"+vo.getPrice()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=15% style=\"color:green\">테마</td>");
		out.println("<td width=55%>"+vo.getTheme()+"</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<td>");
		out.println(vo.getContent());
		out.println("</tr>");
		out.println("</td>");
		out.println("<tr>");
		out.println("<td class=text-right>");
		out.println("<button class=\"btn-sm btn-danger\" onclick=\"javascript:history.back()\">목록</button>");
		out.println("</tr>");
		out.println("</td>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
	}

}
