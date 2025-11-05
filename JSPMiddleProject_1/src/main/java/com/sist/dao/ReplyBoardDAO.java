package com.sist.dao;
import com.sist.commons.*;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
public class ReplyBoardDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	 * 	<select id="boardListData" resultType="ReplyBoardVO" parameterType="int">
		SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab
		FROM replyboard
		ORDER BY group_id DESC , group_step asc
		OFFSET #{start} ROWS NEXT 10 ROWS ONLY
	</select>
	<select id="boardTotalPage" resultType="int">
		SELECT CEIL(COUNT(*)/10.0)
		FROM replyboard
	</select>
	 * 
	 */
	public static List<ReplyBoardVO> boardListData(int start)
	{
		List<ReplyBoardVO> list=null;
		try {
			SqlSession session=ssf.openSession();
			list=session.selectList("boardListData",start);
			session.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	public static int boardTotalPage()
	{
		int totalPage=0;
		try {
			SqlSession session=ssf.openSession();
			totalPage=session.selectOne("boardTotalPage");
			session.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return totalPage;
	}
	public static void boardInsert(ReplyBoardVO vo)
	{
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("boardInsert",vo);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		{
			session.close();
		}
	}
	public static int boardNewdetail()
	{
		SqlSession session=null;
		int newno=0;
		try {
			session=ssf.openSession();
			newno=session.selectOne("boardNewdetail");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		{
			session.close();
		}
		return newno;
	}
	public static ReplyBoardVO boardDetail(int no)
	{
		ReplyBoardVO vo=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			boardHitIncrement(no);
			vo=session.selectOne("boardDetail",no);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return vo;
	}
	public static void boardHitIncrement(int no) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("boardHitIncrement",no);
			session.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	public static ReplyBoardVO boardUpdateData(int no) {
		SqlSession session=null;
		ReplyBoardVO vo=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("boardUpdateData",no);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			
		}
		return vo;
	}
	public static boolean boardPwdCheck(String pwd,int no) {
		SqlSession session=null;
		Boolean check=false;
		try {
			session=ssf.openSession();
			String dbpwd=session.selectOne("boardPwdCheck",no);
			if(dbpwd.equals(pwd))
				check=true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return check;
	}
	public static String boardUpdate(ReplyBoardVO vo)
	{
		String res="no";
		SqlSession session=ssf.openSession();
		Boolean check=boardPwdCheck(vo.getPwd(),vo.getNo());
		if(check)
		{
			res="yes";
			session.update("boardUpdate",vo);
			session.commit();
			
		}
		session.close();
		return res;
	}
	public static void boardReplyInsert(int pno,ReplyBoardVO vo)
	{
		/*
		 * 	 <select id="boardParentInfoData" resultType="ReplyBoardVO" parameterType="int">
	 	SELECT group_id, group_step, group_tab
	 	FROM replyboard
	 	WHERE no=#{pno}
	 </select>
	 <!-- 
	 		UPDATE 설정
	 		
	 		AAAAAAA
	 		   => BBBBBB
	 		     => CCCCCC
	  -->
	  <update id="boardGroupStepIncrement" parameterType="ReplyBoardVO">
	  	UPDATE replyboard SET
	  	group_step=group_step+1
	  	WHERE group_id=#{group_id} AND group_step>#{group_step}  
	  
	  </update>
	  <!-- 
	  		INSERT
	   -->
	   <insert id="boardReplyInsert" parameterType="ReplyBoardVO">
	   	INSERT INTO replyboard(no,name,subject,content,pwd,group_id,group_step,group_tab,root,depth)
	   	VALUES(rb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{group_id},#{group_step},#{group_tab},#{root},0)
	   </insert>
	   <!-- 
	   		UPDATE	
	    -->
	    <update id="boardDepthIncrement" parameterType="int">
	    	UPDATE replyboard SET
	    	depth = depth+1
	    	WHERE no=#{no}
	    </update>
		 */
		// 트랜잭션
		SqlSession session=null;
		try {
			session=ssf.openSession();
			ReplyBoardVO pvo=session.selectOne("boardParentInfoData",pno);
			session.update("boardGroupStepIncrement",pvo);
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			session.insert("boardReplyInsert",vo);
			session.update("boardDepthIncrement",pno);
			session.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			
		}
	}
	/*
	 * 	<select id="boardDeleteInfoData" resultType="ReplyBoardVO" parameterType="int">
		SELECT pwd,depth,root
		FROM replyboard
		WHERE no=#{no}
	
	</select>
	<update id="boardSCData" parameterType="int">
		UPDATE replybaord SET
		subject='관리자가 삭제한 게시물입니다.' , content=#{관리자가 삭제한 게시물입니다.}
		WHERE no=#{no}
	</update>
	<delete id="boardDelete" parameterType="int">
		DELETE FROM replyboard
		WHERE no=#{no}
	</delete>
	<update id="boardDepthDecrement" parameterType="int">
		UPDATE replyboard SET
		depth=depth-1
		WHERE no=#{no}
	 * 
	 * 
	 */
	public static String boardDelete(int no,String pwd)
	{
		String res="no";
		SqlSession session=ssf.openSession();
		ReplyBoardVO vo=session.selectOne("boardDeleteInfoData",no);
		if(pwd.equals(vo.getPwd()))
		{
			res="yes";
			if(vo.getDepth()==0)
			{
				session.delete("boardDelete",no);
			}
			else {
				session.update("boardSCData",no);
				
			}
			session.update("boardDepthDecrement",vo.getRoot());
		}
		session.commit();
		session.close();
		return res;
		
	}
	
}
