package com.sist.model;


import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class MusicModel {
	@RequestMapping("music/list.do")
	public String music_list(HttpServletRequest request,HttpServletResponse response)
	{
		String strpage=request.getParameter("page");
		if(strpage==null)
			strpage="1";
		String strcno=request.getParameter("cno");
		if(strcno==null)
			strcno="1";
		int page=Integer.parseInt(strpage);
		int cno=Integer.parseInt(strcno);
		int total=MusicDAO.musictotalpage(cno);
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		Map<String,Integer> map=new HashMap<>();
		map.put("cno", cno);
		map.put("start", start);
		map.put("end", end);
		List<MusicVO> list=MusicDAO.musicListData(map);
		request.setAttribute("page", page);
		request.setAttribute("cno", cno);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("list", list);
		
		int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>total)
		{
			endPage=total;
		}
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("main_jsp", "../music/list.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("music/detail.do")
	public String music_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String strno=request.getParameter("no");
		String strpage=request.getParameter("page");
		String strcno=request.getParameter("cno");
		if(strpage==null)
		{
			strpage="1";
		}
		if(strcno==null)
		{
			strcno="1";
		}
		int no=Integer.parseInt(strno);
		int page=Integer.parseInt(strpage);
		int cno=Integer.parseInt(strcno);
		MusicVO vo=MusicDAO.musicDetailData(no);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("cno", cno);
		request.setAttribute("main_jsp", "../music/detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("music/find.do")
	public String music_find(HttpServletRequest request,HttpServletResponse response)
	{
		String column=request.getParameter("column");
		String fd=request.getParameter("fd");
		if(column==null)
		{
			column="title";
			if(fd==null)
			{
				fd="golden";
			}
		}
		else {
			if(fd==null)
			{
				fd="golden";
			}
		}
		Map<String,String> map=new HashMap<>();
		map.put("column", column);
		map.put("fd", fd);
		List<MusicVO> list=MusicDAO.musicFindData(map);
		System.out.println(list.size());
		request.setAttribute("column	", column);
		request.setAttribute("fd", fd);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../music/find.jsp");
		return "../main/main.jsp";
	}
}
