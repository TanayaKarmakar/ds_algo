package com.app.recursion.problems;

public class Test1 {
	private static void print(int n) {
		if(n < 0)
			return;
		
		if(n == 0) {
			System.out.println(n + " ");
			return;
		}
		
		print(n--);
		System.out.println(n + " ");
	}
	public static void main(String[] args) {
		int n = 3;
		print(n);
	}

}
