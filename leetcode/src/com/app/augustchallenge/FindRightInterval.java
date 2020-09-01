package com.app.augustchallenge;

import java.util.Arrays;

class IntervalItem implements Comparable<IntervalItem> {
	int[] interval;
	int indx;

	public IntervalItem(int[] interval, int indx) {
		this.interval = interval;
		this.indx = indx;
	}

	@Override
	public int compareTo(IntervalItem o) {
		if (this.interval[0] == o.interval[0])
			return this.interval[1] - o.interval[1];
		return this.interval[0] - o.interval[0];
	}

}

public class FindRightInterval {
	private static int getCeiling(IntervalItem[] items, int start, int end) {
		if (start > end)
			return -1;

		IntervalItem currInterval = items[start - 1];

		while (start <= end) {
			int mid = start + (end - start) / 2;
			IntervalItem item = items[mid];
			if (currInterval.interval[1] <= item.interval[0] && (mid - 1) >= 0
					&& currInterval.interval[1] > items[mid - 1].interval[0])
				return item.indx;
			else if (currInterval.interval[1] <= item.interval[0]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	private static int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		IntervalItem[] items = new IntervalItem[n];
		for (int i = 0; i < n; i++) {
			IntervalItem item = new IntervalItem(intervals[i], i);
			items[i] = item;
		}

		Arrays.sort(items);

		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			res[items[i].indx] = getCeiling(items, i + 1, n - 1);
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 } };

		System.out.println(Arrays.toString(findRightInterval(intervals)));

		intervals = new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } };

		System.out.println(Arrays.toString(findRightInterval(intervals)));

		intervals = new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } };

		System.out.println(Arrays.toString(findRightInterval(intervals)));
	}

}
