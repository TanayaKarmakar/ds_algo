package com.app.augustchallenge;

import java.util.Arrays;

public class NonOverlappingIntervals {
	private static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1)
			return 0;
		
		Arrays.sort(intervals, (e1, e2) -> {
			if (e1[0] == e2[0])
				return e1[1] - e2[1];
			return e1[0] - e2[0];
		});

		int startTime = intervals[0][0];
		int endTime = intervals[0][1];
		int count = 0;

		for (int i = 1; i < intervals.length; i++) {
			int currentStartTime = intervals[i][0];
			int currentEndTime = intervals[i][1];

			if (endTime <= currentStartTime && startTime < currentStartTime && endTime < currentEndTime) {
				startTime = currentStartTime;
				endTime = currentEndTime;
			} else {
				if(startTime <= currentStartTime && endTime >= currentEndTime) {
					startTime = currentStartTime;
					endTime = currentEndTime;
				}
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int count = eraseOverlapIntervals(intervals);

		System.out.println(count);

		intervals = new int[][] { { 1, 2 }, { 2, 3 } };
		count = eraseOverlapIntervals(intervals);

		System.out.println(count);

		intervals = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		count = eraseOverlapIntervals(intervals);

		System.out.println(count);

		intervals = new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
		count = eraseOverlapIntervals(intervals);

		System.out.println(count);

	}

}
