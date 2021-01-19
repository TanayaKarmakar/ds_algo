package com.app.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	private static Map<Integer, List<Integer>> map;

	private static void initMap() {
		map = new HashMap<>();

		map.put(0, Arrays.asList(0, 8));
		map.put(1, Arrays.asList(1, 2, 4));
		map.put(2, Arrays.asList(1, 2, 3, 5));
		map.put(3, Arrays.asList(2, 3, 6));
		map.put(4, Arrays.asList(1, 4, 5, 7));
		map.put(5, Arrays.asList(2, 4, 5, 6, 8));
		map.put(6, Arrays.asList(3, 5, 6, 9));
		map.put(7, Arrays.asList(4, 7, 8));
		map.put(8, Arrays.asList(5, 7, 8, 9, 0));
		map.put(9, Arrays.asList(6, 8, 9));
	}

	private static int letterCombinations(int n) {
		initMap();
		int[][] dp = new int[n + 1][10];
		
		int totalCombination = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if(i == 1) {
					dp[i][j] = 1;
				} else {
					List<Integer> prevCells = map.get(j);
					int sum = 0;
					for(Integer prevCell: prevCells) {
						sum += dp[i - 1][prevCell];
					}
					dp[i][j] = sum;
				}
				if(i == n) {
					totalCombination += dp[i][j];
				}
			}
		}
		
		System.out.println(Arrays.deepToString(dp));
		
		return totalCombination;
	}

	public static void main(String[] args) {
		int n = 3;
		int ans = letterCombinations(n);
		
		System.out.println(ans);

	}

}
