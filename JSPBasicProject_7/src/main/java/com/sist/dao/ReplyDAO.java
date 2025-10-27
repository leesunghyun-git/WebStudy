package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class ReplyDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	public static void replyInsert(ReplyVO vo)
	{
		SqlSession session=ssf.openSession(true);
		session.insert("replyInsert",vo);
		//session.commit();
		session.close();
	}
	public static List<ReplyVO> replyListData(int fno)
	{
		SqlSession session=ssf.openSession();
		List<ReplyVO> list=session.selectList("replyListData",fno);
		session.close();
		return list;
	}
	public static void replyDelete(int fno)
	{
		SqlSession session=ssf.openSession(true);
		session.delete("replyDelete", fno);
		session.close();
	}
}
