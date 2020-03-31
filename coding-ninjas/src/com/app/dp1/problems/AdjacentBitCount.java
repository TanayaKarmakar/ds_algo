package com.app.dp1.problems;

public class AdjacentBitCount {
	private static int countRec(int n, int k, int firstBit) {
		if(n == 1) {
			if(k == 0)
				return 1;
			else
				return 0;
		}
		if(k < 0)
			return 0;
		if(firstBit == 1)
			return countRec(n - 1, k - 1, 1) + countRec(n - 1, k, 0);
		else
			return countRec(n - 1, k, 1) + countRec(n - 1, k, 0);
	}
	
	private static int totalCount(int n, int k) {
		return countRec(n, k, 1) + countRec(n, k, 0);
	}

	public static void main(String[] args) {
		int totalNum = totalCount(5, 2);
		
		System.out.println(totalNum);
		
		totalNum = totalCount(20, 8);
		
		System.out.println(totalNum);

	}

}
