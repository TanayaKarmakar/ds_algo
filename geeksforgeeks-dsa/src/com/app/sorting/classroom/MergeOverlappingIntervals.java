package com.app.sorting.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval> {
	private int start;
	private int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public int compareTo(Interval that) {
		if (this.start == that.start)
			return 0;
		else if (this.start < that.start)
			return -1;
		else
			return 1;
	}
}

public class MergeOverlappingIntervals {
	private static void mergeOverlappingInterval(List<Interval> numbers) {
		Collections.sort(numbers);

		int minStart = numbers.get(0).getStart();
		int maxEnd = numbers.get(0).getEnd();

		for (int i = 1; i < numbers.size(); i++) {
			Interval current = numbers.get(i);

			if (current.getStart() > maxEnd) {
				System.out.print("{ " + minStart + "," + maxEnd + " },");
				minStart = current.getStart();
				maxEnd = current.getEnd();
			} else {
				maxEnd = Integer.max(maxEnd, current.getEnd());
			}
		}

		System.out.print("{ " + minStart + "," + maxEnd + " }");
		System.out.println();

	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(6, 8));

		mergeOverlappingInterval(intervals);

		intervals.clear();

		intervals.add(new Interval(7, 9));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		mergeOverlappingInterval(intervals);

	}

}
