package com.app.practice.dp;

public class UglyNumberIILeetcode264 {
	private static int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		for(int i = 1; i < n; i++) {
			int nexti2 = dp[i2] * 2;
			int nexti3 = dp[i3] * 3;
			int nexti5 = dp[i5] * 5;
			int nextUgly = Integer.min(nexti2, 
					Integer.min(nexti3, nexti5));
			
			dp[i] = nextUgly;
			if(nextUgly == nexti2)
				i2++;
			if(nextUgly == nexti3)
				i3++;
			if(nextUgly == nexti5)
				i5++;
 		}
		
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int n = 10;
		
		int ans = nthUglyNumber(n);
		
		System.out.println(ans);

	}

}
