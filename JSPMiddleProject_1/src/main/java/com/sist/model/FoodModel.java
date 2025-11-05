package com.sist.model;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import com.sist.vo.*;

import java.io.Console;
import java.io.PrintWriter;
import java.util.*;
@Controller
public class FoodModel {
	
	@RequestMapping("food/detail.do")
	public String food_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String fno=request.getParameter("fno");
		String page=request.getParameter("page");
		
		FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("main_jsp", "../food/detail.jsp");
		return "../main/main.jsp";
	}
	// Ajax 
	@RequestMapping("food/type.do")
	public String food_type(HttpServletRequest request, HttpServletResponse response)
	{
		String type=request.getParameter("type");
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		if(type==null)
		{
			type="한식";
		}
		int curpage=Integer.parseInt(page);
		Map map=new HashMap<>();
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize; // OFFSET  => 0
											 // INlineView => 1  
		map.put("start", start);
		map.put("type", type);
		List<FoodVO> list=FoodDAO.foodTypeListData(map);
		int total=FoodDAO.foodTypeTotalPage(type);
		// 블록별 페이지 나누기
		/*
		 * 	1. 현재페이지 (curpage)
		 * 		1~10 ====> 1유지
		 * 	    11~20  ===> 11 dbwl
		 * 
		 *  ------------------------
		 *  	1~10 ==> 유지
		 *      11~20 ==> 20 유지
		 * 
		 */
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>total)
		{
			endPage=total;
		}
		request.setAttribute("list", list);
		request.setAttribute("totalPage", total);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("type", type);
		request.setAttribute("curpage", curpage);
		// JSP에 출력할 데이터를 전송 requset.setAttribute
		// 목록 : list / 페이지 : curPage/totalpage/startPage/endPage
		request.setAttribute("main_jsp", "../food/type.jsp");
		return "../main/main.jsp";
 	}
	
    // Ajax
	@RequestMapping("food/find.do")
	public String food_find(HttpServletRequest request, HttpServletResponse response)
	{
		String column = request.getParameter("column");
		String ss = request.getParameter("ss");
		if(column==null)
		{
			column="address";
			if(ss==null)
				ss="마포";
		}
		else
		{
			if(ss==null)
				ss="서울";
		}
		Map<String,String> map=new HashMap<>();
		map.put("column", column);
		map.put("ss", ss);
		
		List<FoodVO> list=FoodDAO.foodFindListData(map);
		
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../food/find.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("food/food_list.do")
	public void food_ajax_list(HttpServletRequest request, HttpServletResponse response)
	{
		String type=request.getParameter("type");
		if(type==null)
		{
			type="한식";
		}
		List<FoodVO> list=FoodDAO.foodAjaxListData(type);
		// List => Array
		JSONArray arr=new JSONArray();
		// vo = Object
		for (FoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("poster", vo.getPoster());
			obj.put("name", vo.getName());
			arr.add(obj);
		}
		
		try {
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(arr.toJSONString());
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	@RequestMapping(value="food/food_vue.do")
	public void food_vue_list(HttpServletRequest request, HttpServletResponse response)
	{
		String type=request.getParameter("type");
		if(type==null)
		{
			type="한식";
		}
		List<FoodVO> list=FoodDAO.foodAjaxListData(type);
		// List => Array
		JSONArray arr=new JSONArray();
		// vo = Object
		for (FoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("poster", vo.getPoster());
			obj.put("name", vo.getName());
			arr.add(obj);
		}
		
		try {
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(arr.toJSONString());
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
