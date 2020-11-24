package com.app.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;

class ArrayComparator implements Comparator<IntervalItem> {

	@Override
	public int compare(IntervalItem o1, IntervalItem o2) {
		return o1.interval[0] - o2.interval[0];
	}

}

class IntervalItem {
	int[] interval;
	int indx;

	public IntervalItem(int[] interval, int indx) {
		this.interval = interval;
		this.indx = indx;
	}
}

public class FindRightIntervalLeetcode436 {
	private static int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		IntervalItem[] items = new IntervalItem[n];

		for (int i = 0; i < n; i++) {
			IntervalItem item = new IntervalItem(intervals[i], i);
			items[i] = item;
		}

		Arrays.sort(items, new ArrayComparator());

		int[] res = new int[n];
		Arrays.fill(res, -1);

		for (int i = 0; i < n; i++) {
			IntervalItem iItem = items[i];
			for (int j = i + 1; j < n; j++) {
				IntervalItem jItem = items[j];
				if (iItem.interval[1] <= jItem.interval[0]) {
					res[iItem.indx] = jItem.indx;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		
		int[] res = findRightInterval(intervals);
		
		System.out.println(Arrays.toString(res));
	}

}
