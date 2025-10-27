package com.sist.dao;

import java.io.Reader;

/*
   1. 목록 --------
              | sendRedirect
   2. 글쓰기 ------
   3. 상세보기---
            |
   4. 수정 ------
   5. 삭제-------------- 목록
*/

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.BoardVO;
public class BoardDAO {
   private static SqlSessionFactory ssf;
   
   static 
   {
      // XML을 파싱 -> wjwkdehls epdlxj dlfrrl
      try {
         // XML 파일 읽기
         Reader reader = Resources.getResourceAsReader("Config.xml");
         ssf = new SqlSessionFactoryBuilder().build(reader);
         // map에 저장 -> key=id value=SQL
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   // 목록 출력
   /*
      <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
         SELECT no, subject, name, TO_CHAR(regdate,'YYYY-MM-DD') as dbday, hit, num
         FROM (SELECT no, subject, name, regdate, hit, rownum as num
         FROM (SELECT no, subject, name, regdate, hit
         FROM jspBoard ORDER BY no DESC))
         WHERE num BETWEEN #{start} AND #{end}
      </select>
   */
   public static List<BoardVO> boardListData(Map map)
   {
      SqlSession session = ssf.openSession();
      //getConnection()
      List<BoardVO> list = session.selectList("boardListData",map);
      session.close();
      return list;
   }
   /*
      <select id="boardTotalPage" resultType="int">
         SELECT CEIL(COUNT(*) / 10.0) FROM jspBoard
      </select>
   */
   public static int boardTotalPage()
   {
      SqlSession session = ssf.openSession();
      int total = session.selectOne("boardTotalPage");
      session.close();
      return total;
   }
   /*
      <insert id="boardInsert" parameterType="BoardVO">
         <selectKey keyProperty="no" resultType="int" order="BEFORE">
            SELECT NVL(MAX(no)+1,1) as no FROM jspBoard
         </selectKey>
            INSERT INTO jspBoard(no, name, subject, content, pwd)
            VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd})
      </insert>
   */
   public static void boardInsert(BoardVO vo)
   {
      SqlSession session = ssf.openSession(true);
      session.insert("boardInsert",vo);
      //session.commit();
      session.close();
   }
   public static BoardVO boardDetail(int no)
   {
	   SqlSession session = ssf.openSession();
	   session.update("hitIncrement",no);
	   session.commit();
	   BoardVO vo=session.selectOne("boardDetailPage",no);
	   session.close();
	   return vo;
   }
   public static BoardVO boardUpdateData(int no)
   {
	   SqlSession session = ssf.openSession();
	   BoardVO vo=session.selectOne("boardUpdateData",no);
	   session.close();
	   return vo;
   }
   public static String boardGetPassword(int no)
   {
	   SqlSession session = ssf.openSession();
	   String pwd =session.selectOne("boardGetPassword",no);
	   session.close();
	   return pwd;
   }
   public static boolean boardUpdate(BoardVO vo)
   {
	   SqlSession session = ssf.openSession();
	   boolean bcheck=vo.getPwd().equals(boardGetPassword(vo.getNo()));
	   if(bcheck) {
		   session.update("boardUpdate", vo);
		   session.commit();
		   session.close(); 
	   }
	   return bcheck;
   }
   public static boolean boardcheck(String pwd,int no)
   {
	   return pwd.equals(boardGetPassword(no));
   }
   public static void boardDelete(int no)
   {
	   SqlSession session = ssf.openSession();
	   session.delete("boardDelete",no);
	   session.commit();
	   session.close();
   }
}
