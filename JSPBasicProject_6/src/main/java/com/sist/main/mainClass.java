package com.sist.main;
import java.util.*;
public class mainClass {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("name", "홍길동");
		System.out.println(map.get("name"));
		map.put("name", "심청이");
		System.out.println(map.get("name"));
	}
}
