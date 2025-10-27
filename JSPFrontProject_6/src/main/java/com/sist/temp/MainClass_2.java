package com.sist.temp;

import java.lang.reflect.Method;
import java.util.*;
import com.sist.controller.*;

public class MainClass_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("URL주소 입력:");
		String url = scan.next();
		List<String> list = new ArrayList<>();
		list.add("com.sist.temp.Board");
		list.add("com.sist.temp.Member");
		for (String name : list) {
			try {

				Class clsName = Class.forName(name);
				Object obj = clsName.getDeclaredConstructor().newInstance();

				// 모든 메소드 읽기
				Method[] methods = clsName.getDeclaredMethods();
				for (Method m : methods) {
					RequestMapping rm = m.getAnnotation(RequestMapping.class);
					if (url.equals(rm.value())) {
						m.invoke(obj, null);
					}
				}

			} catch (Exception ex) {

			}
		}
	}
}
