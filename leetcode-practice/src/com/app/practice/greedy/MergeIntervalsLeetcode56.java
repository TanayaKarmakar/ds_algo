package com.app.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsLeetcode56 {
	private static int[][] mergeIntervals(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

		List<int[]> out = new ArrayList<>();

		int startTime = intervals[0][0];
		int endTime = intervals[0][1];

		int n = intervals.length;

		for (int i = 1; i < n; i++) {
			int currentStartTime = intervals[i][0];
			int currentEndTime = intervals[i][1];

			if (endTime >= currentStartTime) {
				endTime = Integer.max(endTime, currentEndTime);
			} else {
				out.add(new int[] { startTime, endTime });
				startTime = currentStartTime;
				endTime = currentEndTime;
			}
		}

		int[][] outArr = new int[out.size() + 1][2];

		for (int i = 0; i < out.size(); i++) {
			outArr[i] = out.get(i);
		}

		outArr[out.size()] = new int[] { startTime, endTime };
		return outArr;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] res = mergeIntervals(intervals);

		System.out.println(Arrays.deepToString(res));

		intervals = new int[][] { { 1, 4 }, { 0, 4 } };

		res = mergeIntervals(intervals);

		System.out.println(Arrays.deepToString(res));

	}

}
