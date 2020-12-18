package com.app.sorting;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int left;
	int right;

	public Interval(int l, int r) {
		this.left = l;
		this.right = r;
	}

	public String toString() {
		return "Start : " + this.left + " | End : " + this.right;
	}
}

public class MergeIntervals {
	private static List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) {
		List<Interval> results = new ArrayList<>();

		int i = 0;
		int size = intervals.size();

		while (i < size && intervals.get(i).right < newInterval.left) {
			results.add(intervals.get(i));
			++i;
		}

		Interval updatedInterval = null;

		while (i < size && intervals.get(i).left <= newInterval.right) {
			int min = Integer.min(intervals.get(i).left, newInterval.left);
			int max = Integer.max(intervals.get(i).right, newInterval.right);
			updatedInterval = new Interval(min, max);
			++i;
		}
		results.add(updatedInterval);
		results.addAll(intervals.subList(i, size));
		return results;
	}

	public static void main(String[] args) {
		List<Interval> intervals = List.of(new Interval(-4, -1), new Interval(0, 2), new Interval(3, 6),
				new Interval(7, 9), new Interval(11, 12), new Interval(14, 17));

		Interval newInterval = new Interval(1, 8);
		List<Interval> result = mergeIntervals(intervals, newInterval);

		for (Interval interval : result) {
			System.out.println(interval);
		}
	}
	
}
