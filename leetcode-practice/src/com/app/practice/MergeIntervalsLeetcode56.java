package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsLeetcode56 {
	private static int[][] merge(int[][] intervals) {
		if(intervals.length == 0)
			return new int[][] {};
		if(intervals.length == 1)
			return intervals;
		Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
		List<int[]> res = new ArrayList<>();

		int n = intervals.length;
		int startTime = intervals[0][0];
		int endTime = intervals[0][1];

		for (int i = 1; i < n; i++) {
			int currentStartTime = intervals[i][0];
			int currentEndTime = intervals[i][1];

			if (endTime >= currentStartTime) {
				endTime = Integer.max(endTime, currentEndTime);
			} else {
				int[] times = new int[2];
				times[0] = startTime;
				times[1] = endTime;
				res.add(times);
				startTime = currentStartTime;
				endTime = currentEndTime;
			}
		}

		int m = res.size();
		int[][] output = new int[m + 1][2];

		for (int i = 0; i < m; i++) {
			output[i] = res.get(i);
		}

		output[m] = new int[] { startTime, endTime };
		return output;
	}

	public static void main(String[] args) {
		int[][] timings = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		System.out.println(Arrays.deepToString(merge(timings)));

		timings = new int[][] { { 1, 4 }, { 4, 5 } };

		System.out.println(Arrays.deepToString(merge(timings)));
	}

}
