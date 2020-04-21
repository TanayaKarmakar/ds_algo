package com.app.questions.practice;

//back to back SWE video
// F(i, n) = G(i - 1) * G(n - i)
public class UniqueBSTLeetcode96 {
	private static int uniqueBST(int n) {
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			System.out.println(uniqueBST(i));
		}

	}

}
