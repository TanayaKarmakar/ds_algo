package com.app.questions.practice;

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

public class MergeIntervalsLeetcode56 {
	private static Interval createInstance(int startTime, int endTime) {
		Interval interval = new Interval();
		interval.startTime = startTime;
		interval.endTime = endTime;
		return interval;
	}

	private static int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return new int[][] {};
		if (intervals.length == 1)
			return intervals;

		int n = intervals.length;
		List<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] curr = intervals[i];
			Interval interval = createInstance(curr[0], curr[1]);
			intervalList.add(interval);
		}

		Collections.sort(intervalList);
		List<Interval> res = new ArrayList<>();
		int currentStartTime = intervalList.get(0).startTime;
		int currentEndTime = intervalList.get(0).endTime;

		for (int i = 1; i < intervalList.size(); i++) {
			int nextStartTime = intervalList.get(i).startTime;
			int nextEndTime = intervalList.get(i).endTime;

			if (currentEndTime >= nextStartTime) {
				currentEndTime = Integer.max(currentEndTime, nextEndTime);
			} else {
				Interval interval = createInstance(currentStartTime, currentEndTime);
				res.add(interval);
				currentStartTime = nextStartTime;
				currentEndTime = nextEndTime;
			}
		}
		Interval interval = createInstance(currentStartTime, currentEndTime);
		res.add(interval);

		// System.out.println(res);
		int[][] resArr = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			interval = res.get(i);
			int[] item = { interval.startTime, interval.endTime };
			resArr[i] = item;
		}
		return resArr;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] res = merge(intervals);

		System.out.println(Arrays.deepToString(res));

		intervals = new int[][] { { 1, 4 }, { 4, 5 } };
		res = merge(intervals);
		
		System.out.println(Arrays.deepToString(res));

	}

}
