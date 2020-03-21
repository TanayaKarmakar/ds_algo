package com.app.bitmanipulation.problems;

public class FindFirstSetBit {
	private static int findFirstBitSet(int num) {
		if(num == 0)
			return 0;
		int k = 1;
		int val = 1;
	
		while((num & val) == 0) {
			val = 1 << k;
			k++;
		}
		return k;
	}

	public static void main(String[] args) {
		System.out.println(findFirstBitSet(7));
		System.out.println(findFirstBitSet(12));
		System.out.println(findFirstBitSet(4));
		System.out.println(findFirstBitSet(0));
		System.out.println(findFirstBitSet(1));
	}

}
