package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.vo.*;
import javax.sql.*; // DataSource => 데이터베이스 정보
import javax.naming.*; // Context => jdbc/oracle
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	// 미리 연결된 Connection 객체 열기
	// -- 톰캣
	public void getConnection()
	{
		try
		{
			Context init=new InitialContext();
			// 탐색기 => 탐색기 열기
			Context c=(Context)init.lookup("java://comp//env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void disConnetion()
	{
		try {
			if(ps!=null) ps.close(); if(conn!=null) conn.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 기능
	public List<FoodDTO> foodListData(int page)
	{
		List<FoodDTO> list = new ArrayList<>();
		try
		{
			getConnection();
			String sql="SELECT fno,poster,name,address,type "
					+ "FROM menupan_food "
					+ "ORDER BY fno ASC "
					+ "OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (page*20)-20);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodDTO dto=new FoodDTO();
				dto.setFno(rs.getInt(1));
				dto.setPoster(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setType(rs.getString(5));
				list.add(dto);
			}
			rs.close();
					
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
		}
		
		
		return list;
	}
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) "
					+ "FROM menupan_food";
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
			disConnetion();
		}
		return total;
	}
	
	
}
