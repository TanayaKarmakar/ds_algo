package com.app.practice.sort;

import java.util.Arrays;

class IntervalNode implements Comparable<IntervalNode> {
	int[] interval;
	int indx;

	public IntervalNode(int[] interval, int indx) {
		this.interval = interval;
		this.indx = indx;
	}

	@Override
	public int compareTo(IntervalNode o) {
		if (this.interval[0] == o.interval[0])
			return this.interval[1] - o.interval[1];
		return this.interval[0] - o.interval[0];
	}
}

public class FindRightIntervalLeetcode436 {
	private static int getCeiling(IntervalNode[] items, int start, int end) {
		if (start > end)
			return -1;

		IntervalNode currInterval = items[start - 1];

		while (start <= end) {
			int mid = start + (end - start) / 2;
			IntervalNode item = items[mid];
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
		IntervalNode[] iNodes = new IntervalNode[n];
		for (int i = 0; i < n; i++) {
			IntervalNode iNode = new IntervalNode(intervals[i], i);
			iNodes[i] = iNode;
		}

		Arrays.sort(iNodes);

		int[] res = new int[n];
		res[iNodes[n - 1].indx] = -1;

		for (int i = n - 2; i >= 0; i--) {
			res[iNodes[i].indx] = getCeiling(iNodes, i + 1, n - 1);
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 } };

		int[] res = findRightInterval(intervals);

		System.out.println(Arrays.toString(res));

	}

}
