package com.app.recursion.classroom;

public class RodCuttingProblem {
	private static int maxCuts(int n, int a, int b, int c) {
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;
		int res = Integer.max(maxCuts(n - a, a, b, c), 
				Integer.max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));

		if (res == -1)
			return res;
		return res + 1;
	}

	public static void main(String[] args) {
		System.out.println(maxCuts(5, 1, 2, 2));
		//System.out.println(maxCuts(23, 11, 12, 9));

	}

}
