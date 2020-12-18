package com.app.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval1 {
	public EndPoint left = new EndPoint();
	public EndPoint right = new EndPoint();

	static class EndPoint {
		int val;
		boolean isClosed;

		public String toString() {
			return val + "";
		}
	}
}

public class UnionOfIntervals {

	private static List<Interval1> unionOfIntervals(List<Interval1> intervals) {
		Collections.sort(intervals, (i1, i2) -> {
			if (i1.left.val != i2.left.val) {
				return i1.left.val - i2.left.val;
			}

			if (i1.left.isClosed)
				return -1;
			return (!i1.left.isClosed && i2.left.isClosed) ? 1 : 0;
		});

		List<Interval1> result = new ArrayList<>();
		result.add(intervals.get(0));

		for (Interval1 i : intervals) {
			if (!result.isEmpty() && (i.left.val < result.get(result.size() - 1).right.val
					|| (i.left.val == result.get(result.size() - 1).right.val)
					&& (i.left.isClosed || result.get(result.size() - 1).right.isClosed))) {
				if ((i.right.val > result.get(result.size() - 1).right.val
						|| (i.right.val == result.get(result.size() - 1).right.val && i.right.isClosed))) {
					result.get(result.size() - 1).right = i.right;
				}
			} else {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Interval1> intervals = new ArrayList<>();
		Interval1 int1 = new Interval1();
		Interval1.EndPoint left = new Interval1.EndPoint();
		left.isClosed = false;
		left.val = 0;

		Interval1.EndPoint right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 3;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 1;

		right = new Interval1.EndPoint();
		right.isClosed = true;
		right.val = 1;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 2;

		right = new Interval1.EndPoint();
		right.isClosed = true;
		right.val = 4;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 3;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 4;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 5;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 7;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 7;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 8;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 8;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 11;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = false;
		left.val = 9;

		right = new Interval1.EndPoint();
		right.isClosed = true;
		right.val = 11;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = true;
		left.val = 12;

		right = new Interval1.EndPoint();
		right.isClosed = true;
		right.val = 14;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = false;
		left.val = 12;

		right = new Interval1.EndPoint();
		right.isClosed = true;
		right.val = 16;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = false;
		left.val = 13;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 15;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		int1 = new Interval1();
		left = new Interval1.EndPoint();
		left.isClosed = false;
		left.val = 16;

		right = new Interval1.EndPoint();
		right.isClosed = false;
		right.val = 17;

		int1.left = left;
		int1.right = right;
		intervals.add(int1);

		List<Interval1> result = unionOfIntervals(intervals);
		for (Interval1 i : result) {
			System.out.println("Left " + i.left + " - Right " + i.right);
		}

	}

}
