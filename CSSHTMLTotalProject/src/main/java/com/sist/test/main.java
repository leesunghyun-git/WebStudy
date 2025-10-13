package com.sist.test;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		System.out.println("페이지 입력");
		int pages=scan.nextInt();
		int start=(pages*12)-12;
		// 0 => 12 24...
		List<FoodVO> list=FoodDAO.foodListData(start);
		for(FoodVO vo:list)
		{
			System.out.println(vo.getFno()+"."+vo.getName());
		}
	}

}
