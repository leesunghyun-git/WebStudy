package com.sist.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@WebServlet("/FoodList")
public class FoodList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// 사용자가 보내준 데이터 받기
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		FoodDAO dao=new FoodDAO();
		List<FoodDTO> list=dao.foodListData(curpage);
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
		{
			endPage=totalpage;
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=\"text/css\">");
		out.println(".container{margin-top:50px;}");
		out.println(".row{margin:0px auto;width:960px");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<div class=row>");
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<th width=10% class=text-center>번호</th>");
		out.println("<th width=15% class=text-center></th>");
		out.println("<th width=30% class=text-center>업체명</th>");
		out.println("<th width=20% class=text-center>음식종류</th>");
		out.println("<th width=25% class=text-center>주소</th>");
		out.println("</tr>");
		// 데이터 루프 : 20개
		for(FoodDTO dto:list)
		{
			out.println("<tr>");
			out.println("<td width=10% class=text-center>"+dto.getFno()+"</td>");
			out.println("<td width=15%><img src="+dto.getPoster()+" width=35 height=35 class=img-circle></td>");
			out.println("<td width=30%>"+dto.getName()+"</td>");
			out.println("<td width=20%>"+dto.getType()+"</td>");
			out.println("<td width=25%>"+dto.getAddress()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div style=\"height:10px\"></div>");
		out.println("<div class=\"row text-center\">");
		out.println("<ul class=pagination>");	
		if(startPage>1)
		{
			out.println("<li><a href=FoodList?page="+(startPage-1)+">&laquo;</a></li>");
		}
		for(int i=startPage;i<=endPage;i++)
		{
			out.println("<li "+(curpage==i?"class=active":"")+"><a href=FoodList?page="+i+">"+i+"</a></li>");
		}
		
		if(endPage<totalpage)
		{
			out.println("<li><a href=FoodList?page="+(endPage+1)+">&raquo;</a></li>");
		}
		out.println("</ul>");
		out.println("</div>");
		out.println("</div>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	out.println("</body>");
	out.println("</html>");
	}

}
