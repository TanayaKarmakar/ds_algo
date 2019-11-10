package com.app.bitmagic.practice;

public class IsKthBitSet {
	private static boolean isKthBitSet(int num, int k) {
//		if (k == 0)
//			return (num & 1) != 0;
//		else
//			return (num & (1 << k)) != 0;
		
		return k == 0 ? (num & 1) !=0 : (num & (1 << k)) != 0;
	}

	public static void main(String[] args) {
		System.out.println(isKthBitSet(4, 0));
		System.out.println(isKthBitSet(4, 2));
		System.out.println(isKthBitSet(500, 3));
	}

}
