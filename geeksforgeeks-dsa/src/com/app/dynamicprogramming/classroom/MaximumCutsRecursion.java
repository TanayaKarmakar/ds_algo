package com.app.dynamicprogramming.classroom;

public class MaximumCutsRecursion {
	private static int maxCut(int n, int a, int b, int c) {
		if(n < 0)
			return -1;
		if(n == 0)
			return 0;
		int res = Integer.max(maxCut(n - a, a, b, c),
				Integer.max(maxCut(n - b, a, b, c),
				maxCut(n - c, a, b, c)));
		
		if(res == -1)
			return res;
		else
			return (res + 1);
	}

	public static void main(String[] args) {
		int n = 5;
		int a = 1;
		int b = 2;
		int c = 3;
		
		
		int res = maxCut(n, a, b, c);
		
		System.out.println("Res - " + res);

	}

}
