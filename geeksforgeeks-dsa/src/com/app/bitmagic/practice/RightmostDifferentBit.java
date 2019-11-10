package com.app.bitmagic.practice;

public class RightmostDifferentBit {
	private static int log2(int num) {
		int res = 0;
		while((num >>= 1) > 0)
			res++;
		return res;
	}
	
	private static int rightMostDifferentBit(int m, int n) {
		int res = m ^ n;
		if(res == 0)
			return -1;
		res = res ^ (res - 1);
		return log2(res) + 1;
	}

	public static void main(String[] args) {
		System.out.println(rightMostDifferentBit(11, 9));
		System.out.println(rightMostDifferentBit(52, 4));
		System.out.println(rightMostDifferentBit(8, 0));

	}

}
