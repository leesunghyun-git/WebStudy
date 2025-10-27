package com.sist.temp;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("URL주소 입력:");
		String url=scan.next();
		Board board=new Board();
		if(url.equals("select.do"))
		{
			board.select();
		}

		else if(url.equals("insert.do"))
		{
			board.insert();
		}

		else if(url.equals("update.do"))
		{
			board.update();
		}

		else if(url.equals("delete.do"))
		{
			board.delete();
		}

		else if(url.equals("find.do"))
		{
			board.find();
		}
		
	}
}
