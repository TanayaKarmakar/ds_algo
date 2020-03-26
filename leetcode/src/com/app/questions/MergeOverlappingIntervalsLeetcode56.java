package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval> {
	int startTime;
	int endTime;

	@Override
	public int compareTo(Interval that) {
		if (this.startTime == that.startTime)
			return 0;
		else if (this.startTime < that.startTime)
			return -1;
		else
			return 1;
	}

}

public class MergeOverlappingIntervalsLeetcode56 {
	private static Interval createInstance(int startTime, int endTime) {
		Interval interval = new Interval();
		interval.startTime = startTime;
		interval.endTime = endTime;
		return interval;
	}

	private static int[][] mergeIntervals(int[][] intervals) {
		if (intervals.length == 0)
			return new int[][] {};
		if (intervals.length == 1)
			return intervals;
		List<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] curr = intervals[i];
			Interval interval = createInstance(curr[0], curr[1]);
			intervalList.add(interval);
		}

		Collections.sort(intervalList);

		int currentStartTime = intervalList.get(0).startTime;
		int currentEndTime = intervalList.get(0).endTime;

		List<Interval> output = new ArrayList<>();

		for (int i = 1; i < intervalList.size(); i++) {
			int nextStartTime = intervalList.get(i).startTime;
			int nextEndTime = intervalList.get(i).endTime;
			if (nextStartTime <= currentEndTime) {
				currentEndTime = Integer.max(currentEndTime, nextEndTime);
			} else {
				Interval interval = createInstance(currentStartTime, currentEndTime);
				output.add(interval);
				currentStartTime = nextStartTime;
				currentEndTime = nextEndTime;
			}

		}
		Interval interval = createInstance(currentStartTime, currentEndTime);
		output.add(interval);

		int[][] res = new int[output.size()][2];
		int i = 0;
		for (Interval el : output) {
			int[] val = { el.startTime, el.endTime };
			res[i++] = val;
		}

		return res;

	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };

		intervals = mergeIntervals(intervals);

		System.out.println(Arrays.deepToString(intervals));

		intervals = new int[][] { { 7, 9 }, { 6, 10 }, { 4, 5 }, { 1, 3 }, { 2, 4 } };

		intervals = mergeIntervals(intervals);

		System.out.println(Arrays.deepToString(intervals));

		intervals = new int[][] { { 5, 10 }, { 2, 3 }, { 6, 8 }, { 1, 7 } };

		intervals = mergeIntervals(intervals);

		System.out.println(Arrays.deepToString(intervals));

	}

}
