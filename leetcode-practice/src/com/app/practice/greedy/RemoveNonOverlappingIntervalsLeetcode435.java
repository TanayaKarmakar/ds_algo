package com.app.practice.greedy;

import java.util.Arrays;

public class RemoveNonOverlappingIntervalsLeetcode435 {
	private static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1)
			return 0;

		Arrays.sort(intervals, (e1, e2) -> {
			if (e1[0] == e2[0])
				return e1[1] - e2[1];
			return e1[0] - e2[0];
		});

		int startTime = intervals[0][0];
		int finishTime = intervals[0][1];

		int count = 0;
		for (int i = 1; i < intervals.length; i++) {
			int currentStartTime = intervals[i][0];
			int currentFinishTime = intervals[i][1];
			if (currentStartTime >= finishTime && currentStartTime > startTime && currentFinishTime > finishTime) {
				startTime = currentStartTime;
				finishTime = currentFinishTime;
			} else {
				if (startTime <= currentStartTime && finishTime >= currentFinishTime) {
					startTime = currentStartTime;
					finishTime = currentFinishTime;
				}
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

		int ans = eraseOverlapIntervals(intervals);

		System.out.println(ans);
	}

}
