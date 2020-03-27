package com.app.dp1.problems;

public class LootHouses {
	private static int lootHouse(int[] arr, int n) {
		if(n == 1)
			return arr[0];
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = Integer.max(arr[0], arr[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Integer.max(dp[i - 1], arr[i] + dp[i - 2]);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		
		int maxCost = lootHouse(arr, arr.length);
		
		System.out.println(maxCost);

	}

}
