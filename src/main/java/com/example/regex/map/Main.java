package com.example.regex.map;

public class Main {
	
	public static void main(String[] args) {
		RegExHashMap<String, String> rhm = new RegExHashMap<>();
		rhm.put("/lifecoach/expenses", "280");
		rhm.put("/lifecoach/expenses/(.*)", "2000");
		rhm.put("/lifecoach/(.*)", "270");
		
		System.out.println("/lifecoach/11 : " + rhm.get("/lifecoach/11"));
		System.out.println("/lifecoach/9087644 : " + rhm.get("/lifecoach/9087644"));
		System.out.println("/lifecoach/expenses : " + rhm.get("/lifecoach/expenses"));
		System.out.println("/lifecoach/expenses/11 : " + rhm.get("/lifecoach/expenses/11"));
	}
}
