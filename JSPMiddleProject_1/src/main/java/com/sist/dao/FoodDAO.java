package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;

import oracle.net.ns.SessionAtts;
public class FoodDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<FoodVO> foodListData(Map map)
	{
		
		SqlSession session=ssf.openSession();
		List<FoodVO> list=session.selectList("foodListData",map);
		session.close();
		return list;
	}
	public static int foodTotalPage()
	{
		SqlSession session=ssf.openSession();
		int total=session.selectOne("foodTotalPage");
		session.close();
		return total;
	}
	public static void hitIncrement(int fno)
	{
		SqlSession session=ssf.openSession(true);
		session.update("hitIncrement",fno);
		session.close();
	}
	public static FoodVO foodDetailData(int fno)
	{
		SqlSession session=ssf.openSession();
		FoodVO vo=session.selectOne("foodDetailData",fno);
		session.close();
		return vo;
	}
	public static List<FoodVO> foodTypeListData(Map map)
	{
		List<FoodVO> list=null;
		try {
			SqlSession session=ssf.openSession();
			list=session.selectList("foodTypeListData",map);
			session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	public static int foodTypeTotalPage(String type)
	{
		int total=0;
		try
		{
			SqlSession session=ssf.openSession();
			total=session.selectOne("foodTypeTotalPage",type);
			session.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return total;
	}
	public static List<FoodVO> foodFindListData(Map map)
	{
		List<FoodVO> list=null;
		try {
			SqlSession session = ssf.openSession();
			list=session.selectList("foodFindListData",map);
			session.close();
			
		}catch(Exception ex)
		{
			
		}
		return list;
	}
	public static List<FoodVO> foodAjaxListData(String type)
	{
		List<FoodVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodAjaxListData",type);
			System.out.println(list.size());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return list;
	}
	
	
}
