package com.sist.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.sist.vo.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	// 변경 사항이 없다
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	/*
	 * 	jdbc:업체명:@IP:port:데이터베이스명
	 *  jdbc:mysql:@localhost:3306:mydb
	 * 
	 */
	// 각 user 당 1개의 DAO를 사용이 가능 => 싱글턴 
	public static BoardDAO dao;
	// 드라이버 등록
	public BoardDAO()
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ojdbc11 => oracle.jdbc.OracleDriver
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 싱글턴 => Spring : 등록한 모든 클래스 (싱글턴)
	
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao = new BoardDAO();
		return dao;
	}
	
	public void getConnection()
	{
		try {
			
		conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close(); // 송수신
			if(conn!=null) conn.close(); // 전화
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// 기능
	// 목록 => 페이징
	public List<BoardDTO> boardListData(int page)
	{
		List<BoardDTO> list=new ArrayList<>();
		try
		{
			// 1. 연결
			getConnection();
			// 2. SQL문장
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit "
					+ "FROM web_board "
					+ "ORDER BY no DESC "
					+ "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
			int rowSize=10;
			int start=(rowSize*page)-rowSize;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BoardDTO vo=new BoardDTO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
			// LIMIT 1,10
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		return list;
	}
	// 총페이지
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(count(*)/10.0) FROM web_board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		return total;
	}
	// 새글 => INSERT 
	public int boardInsert(BoardDTO dto) {
		int result=0;
		try
		{
		getConnection();
		String sql="INSERT INTO web_board(no,name,subject,content,pwd)"
				+ " VALUES(wb_no_seq.nextval,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getSubject());
		ps.setString(3, dto.getContent());
		ps.setString(4, dto.getPwd());
		result=ps.executeUpdate();
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
		return result;
	}
	// 상세보기 => 조회수 증가
	public BoardDTO boardDetail(int no)
	{
		BoardDTO dto=new BoardDTO();
		try
		{
			getConnection();
			String sql="UPDATE web_board SET hit=hit+1 WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			sql="SELECT no,TO_CHAR(regdate,'YYYY-MM-DD'),name,hit,subject,content"
					+ " FROM web_board"
					+ " WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs= ps.executeQuery();
			rs.next();
			dto.setNo(rs.getInt(1));
			dto.setDbday(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setHit(rs.getInt(4));
			dto.setSubject(rs.getString(5));
			dto.setContent(rs.getString(6));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		
		return dto;
	}
	// 수정 => hidden 비밀번호 검색
	public BoardDTO boardUpdateDetail(int no)
	{
		BoardDTO dto=new BoardDTO();
		try
		{
			getConnection();
			String sql="SELECT no,name,subject,content"
					+ " FROM web_board"
					+ " WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs= ps.executeQuery();
			rs.next();
			dto.setNo(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setSubject(rs.getString(3));
			dto.setContent(rs.getString(4));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		
		return dto;
	}
	public void boardUpdate(BoardDTO dto)
	{
		try
		{
			getConnection();
			String sql ="UPDATE web_board SET name=?, subject=?,content=?,pwd=? WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSubject());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPwd());
			ps.setInt(5, dto.getNo());
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
	
	// 삭제 => hidden
	// 검색 => 이름 / 제목 / 내용
}
