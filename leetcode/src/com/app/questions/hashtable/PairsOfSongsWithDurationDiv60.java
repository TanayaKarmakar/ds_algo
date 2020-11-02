package com.app.questions.hashtable;

public class PairsOfSongsWithDurationDiv60 {
	private static int numPairsDivisibleBy60(int[] time) {
		int[] maps = new int[60];
		int res = 0;
		int n = time.length;

		for (int i = 0; i < n; i++) {
			int curr = time[i];
			curr = curr % 60;
			res += (curr == 0) ? maps[curr] : maps[60 - curr];
			maps[curr]++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 30, 20, 150, 100, 40 };
		
		int res = numPairsDivisibleBy60(nums);
		
		System.out.println(res);

	}

}
