package com.app.nt3.problems;

public class OptimizedPowerCalculation {
	private static int calcPower1(int x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		if(n % 2 == 0) {
			int val = calcPower1(x, n / 2);
			return val * val;
		} else {
			return x * calcPower1(x, n - 1);
		}
	}
	
	private static int calcPower2(int x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		int val = calcPower2(x, n / 2);
		if(n % 2 == 0)
			return val * val;
		else
			return x * val * val;
	}

	public static void main(String[] args) {
		int x = 2;
		int n = 3;
		
		System.out.println(calcPower1(x, n));
		System.out.println(calcPower2 (x, n));
	}

}
