package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Food_listModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		String strPage=request.getParameter("page");
		if(strPage==null)
		{
			strPage="1";
		}
		int curpage=Integer.parseInt(strPage);
		Map<String,Integer> map =new HashMap<>();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=FoodDAO.foodListData(map);
		int totalPage=FoodDAO.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalPage)
		{
			endPage=totalPage;
		}
		// 결과값 전송
		JSONArray arr=new JSONArray(); // List 매칭
		// [] => [{},{},{},{}...]
		int i=0;
		for (FoodVO vo :list)
		{
			JSONObject obj=new JSONObject();
			obj.put("fno", vo.getFNO());
			obj.put("name", vo.getNAME());
			obj.put("poster", vo.getPOSTER());
			if(i==0)
			{
				obj.put("curpage", curpage);
				obj.put("totalPage", totalPage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
			}
			arr.add(obj);
			i++;
		}
		request.setAttribute("json", arr.toJSONString());
//		System.out.println(arr.toJSONString());
		return "list.jsp";
	}
	
}
