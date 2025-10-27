package com.sist.temp;

import com.sist.controller.RequestMapping;

public class Member {
	@RequestMapping("member_join.do")
	public void MemberJoin()
	{
		System.out.println("Member:MemberJoin() Call..");
	}
	@RequestMapping("member_delete.do")
	public void MemeberDelete()
	{
		System.out.println("Member:MemberDelete() Call..");
	}
	@RequestMapping("member_update.do")
	public void MemeberUpdate()
	{
		System.out.println("Member:MemberUpdate() Call..");
	}
}
