package com.app.questions.read;

public class NumPerfectSquaresLeetcode279 {
	private static final int INT_MAX = 1000000006;

	private static int numSquareMemo(Integer[][] memo, int num, int i) {
		if(num < 0 || i == 0)
			return INT_MAX;
		if(num == 0)
			return 0;
			if(memo[num][i] == null) {
				int option1 = 1 + numSquareMemo(memo, num - (i * i), i);
				int option2 = numSquareMemo(memo, num, (i - 1));
				memo[num][i] = Integer.min(option1, option2);
			}
		return memo[num][i];
	}
	
	private static int numSquareRec(int num, int i) {
		if(num < 0 || i == 0)
			return INT_MAX;
		if(num == 0)
			return 0;
		int option1 = 1 + numSquareRec(num - (i * i), i);
		int option2 = numSquareRec(num, (i - 1));
		return Integer.min(option1, option2);
	}
	
	private static int numSquares(int num) {
		int maxBoundary = (int)Math.sqrt(num);
		//return numSquareRec(num, maxBoundary);
		Integer[][] memo = new Integer[num + 1][maxBoundary + 1];
		return numSquareMemo(memo, num, maxBoundary);
	}

	public static void main(String[] args) {
		int num = 12;
		
		System.out.println(numSquares(num));
		
		num = 13;
		
		System.out.println(numSquares(num));

	}

}
