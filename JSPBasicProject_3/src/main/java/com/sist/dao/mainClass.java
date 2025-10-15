package com.sist.dao;

public class mainClass {
	public static void main(String[] args) {
		int total=FoodDAO.foodTotalpage("한식");
		System.out.println(total);
	}
}
