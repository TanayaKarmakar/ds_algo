package com.app.questions;

public class UniquePaths {
	private static int count = 0;
	
	private static void uniquePathRec(int i, int j, int m, int n) {
		if(i == m - 1 && j == n - 1) {
			count++;
		}
		if(i >= m || j >= n)
			return;
		uniquePathRec(i + 1, j, m, n);
		uniquePathRec(i, j + 1, m, n);
		
	}
	
	private static int uniquePath(int m, int n) {
		count = 0;
		uniquePathRec(0, 0, m, n);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(uniquePath(3, 2));
		System.out.println(uniquePath(7, 3));
		System.out.println(uniquePath(19, 13));

	}

}
