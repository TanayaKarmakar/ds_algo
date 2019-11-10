package com.app.bitmagic.practice;

public class SparseNumber {
	private static boolean isSparse(int num) {
		return (num & (num >> 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println("Sparse number - " + isSparse(12));
		System.out.println("Sparse number - " + isSparse(10));

	}

}
