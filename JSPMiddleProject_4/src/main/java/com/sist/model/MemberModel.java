package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MemberModel {
	@RequestMapping("member/post.do")
	public String member_post(HttpServletRequest request,HttpServletResponse response)
	{
		String dong = request.getParameter("dong");
		List<ZipcodeVO> list=MemberDAO.postFindData(dong);
		
		request.setAttribute("list", list);
		return "../member/post.jsp";
 	}
}
