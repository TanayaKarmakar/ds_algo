package com.app.practice.map;

public class PairOfSongsDivisibleBy60Leetcode1010 {
	private static int numPairsDivisibleBy60(int[] time) {
		int[] map = new int[60];

		int n = time.length;

		int res = 0;

		for (int i = 0; i < n; i++) {
			int curr = time[i];
			curr = curr % 60;

			res += (curr == 0) ? map[curr] : map[60 - curr];
			map[curr]++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 30, 20, 150, 100, 40 };
		
		int res = numPairsDivisibleBy60(nums);
		
		System.out.println(res);
	}

}
