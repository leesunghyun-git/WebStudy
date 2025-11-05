package com.sist.dao;
import com.sist.commons.*;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MusicDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<MusicVO> musicListData(Map<String,Integer> map)
	{
		SqlSession session=ssf.openSession();
		List<MusicVO> list=session.selectList("musicListData",map);
		session.close();
		return list;
	}
	public static int musictotalpage(int cno)
	{
		SqlSession session=ssf.openSession();
		int total=session.selectOne("musictotalpage",cno);
		session.close();
		return total;
	}
	public static MusicVO musicDetailData(int no)
	{
		SqlSession session=ssf.openSession();
		hitIncrese(no);
		MusicVO vo=session.selectOne("musicDetailData",no);
		session.close();
		return vo;
	}
	public static void hitIncrese(int no)
	{
		SqlSession session=ssf.openSession(true);
		session.update("hitIncrese",no);
		session.close();
	}
	public static void likeIncrese(int no)
	{
		SqlSession session=ssf.openSession(true);
		session.update("likeIncrese",no);
		session.close();
	}
	public static List<MusicVO> musicFindData(Map map)
	{
		List<MusicVO> list=null;
		try {
			SqlSession session=ssf.openSession();
			list=session.selectList("musicFindData",map);
			session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
}
