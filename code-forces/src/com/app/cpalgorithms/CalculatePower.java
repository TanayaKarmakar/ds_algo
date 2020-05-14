package com.app.cpalgorithms;

public class CalculatePower {
	private static int calcI(int x, int n) {
		int res = 1;
		while(n > 0) {
			if((n & 1) > 0)
				res = res * x;
			x = x * x;
			n >>= 1;
		}
		return res;
	}
	
	private static int calc(int x, int n) {
		if(n == 0)
			return 1;
		int res = calc(x, n / 2);
		if(n % 2 != 0)
			return res * res * x;
		else
			return res * res;
	}

	public static void main(String[] args) {
		int x = 3;
		int n = 13;
		
		int pow = calcI(x, n);
		
		System.out.println(pow);

	}

}
