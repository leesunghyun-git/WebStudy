package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
public class FoodDAO {
	private static SqlSessionFactory ssf;
	static
	{
		// XML에 등록된 데이터를 읽어서 Map에 저장하는 과정
		// XML 파싱
		try
		{
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	public static List<FoodVO> foodListData(Map map)
	{
		List<FoodVO> list=new ArrayList<>();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("foodListData", map);	
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		
		
		return list;
	}
	public static int foodTotalPage()
	{
		int total=0;
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			total=session.selectOne("foodTotalPage");	
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
		return total;
	}
	public static FoodVO foodDetailData(int fno)
	{
			FoodVO vo =new FoodVO();
			SqlSession session=null;
			try
			{
				session=ssf.openSession();
				vo=session.selectOne("foodDetailData",fno);	
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				if(session!=null)
				{
					session.close();
				}
			}
			return vo;
		
	}
}
