package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sun.net.httpserver.Authenticator.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ReplyBoardModel {
	@RequestMapping("board/list.do")
	public String reply_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		//HttpServletRequest request 사용하지 않는다
		// 스프링 reply_list(int page)
		// 스프링 reply_insert(BoardVO vo)
		int curpage=Integer.parseInt(page);
		List<ReplyBoardVO> list=ReplyBoardDAO.boardListData((curpage-1)*10);
		int count=ReplyBoardDAO.boardTotalPage();
		int totalPage=(int)(Math.ceil(count/10.0));
		
		count=count-((curpage*10)-10);
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("curPage", curpage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("msg", "관리자가 삭제한 게시물입니다.");		
		request.setAttribute("main_jsp", "../replyboard/list.jsp");
		return "../main/main.jsp";
		
	}
	@RequestMapping("board/insert.do")
	public String reply_insert(HttpServletRequest request,HttpServletResponse response)
	{	
		request.setAttribute("main_jsp", "../replyboard/insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/insert_ok.do")
	public String reply_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		// 처리
		// 1. 사용자가 보낸 데이터 받기 name, subject, content, pwd
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		ReplyBoardVO vo=new ReplyBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		// vo => DAO : 오라클 저장
		// 화면 이동
		// sendRedirect() => 화면 이동 (request를 초기화)
		// 재호출 => list.do 다시 호출
		ReplyBoardDAO.boardInsert(vo);
		return "redirect:../board/detail.do?no="+ReplyBoardDAO.boardNewdetail();
		
	}
	@RequestMapping("board/detail.do")
	public String reply_detail(HttpServletRequest request,HttpServletResponse response)
	{
		// 사용자 전송 데이터 받기
		String strno =request.getParameter("no");
		int no= Integer.parseInt(strno);
		
		// 요청 처리
		ReplyBoardVO vo=ReplyBoardDAO.boardDetail(no);
		// 처리된 결과값 => 해당 JSP 전송
		request.setAttribute("vo", vo);
		// 화면 출력
	
		request.setAttribute("main_jsp", "../replyboard/detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/update.do")
	public String reply_update(HttpServletRequest request,HttpServletResponse response)
	{
		String strno=request.getParameter("no");
		int no = Integer.parseInt(strno);
		ReplyBoardVO vo=ReplyBoardDAO.boardUpdateData(no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../replyboard/update.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/reply.do")
	public String reply_reply(HttpServletRequest request,HttpServletResponse response)
	{
		String strno=request.getParameter("no");
		int no = Integer.parseInt(strno);
		 
		request.setAttribute("no", no);
		request.setAttribute("main_jsp", "../replyboard/reply.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/update_ok.do")
	public void reply_update_ok(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String no = request.getParameter("no");
		ReplyBoardVO vo=new ReplyBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setNo(Integer.parseInt(no));
		
		String res=ReplyBoardDAO.boardUpdate(vo);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(res);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	@RequestMapping("board/reply_ok.do")
	public String reply_reply_ok(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String no = request.getParameter("pno");
		int pno=Integer.parseInt(no);
		ReplyBoardVO vo=new ReplyBoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		ReplyBoardDAO.boardReplyInsert(pno, vo);
		// db연동
		return "redirect:../board/list.do";
	}
	@RequestMapping("board/delete.do")
	public void reply_delete(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		String res=ReplyBoardDAO.boardDelete(Integer.parseInt(no), pwd);
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(res);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
