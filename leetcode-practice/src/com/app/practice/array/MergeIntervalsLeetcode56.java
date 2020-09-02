package com.app.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsLeetcode56 {
	private static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		int n = intervals.length;
		Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

		int start = intervals[0][0];
		int end = intervals[1][0];

		List<int[]> outList = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			int currentStartTime = intervals[i][0];
			int currentEndTime = intervals[i][1];

			if (end >= currentStartTime) {
				end = Integer.max(end, currentEndTime);
			} else {
				outList.add(new int[] { start, end });
				start = currentStartTime;
				end = currentEndTime;
			}
		}

		outList.add(new int[] { start, end });

		int m = outList.size();
		int[][] out = new int[m][2];
		for (int i = 0; i < m; i++) {
			out[i] = outList.get(i);
		}

		return out;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] out = merge(intervals);

		System.out.println(Arrays.deepToString(out));
	}

}
