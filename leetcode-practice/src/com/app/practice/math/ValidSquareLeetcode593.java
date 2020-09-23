package com.app.practice.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (this.x == o.x)
			return this.y - o.y;
		return this.x - o.x;
	}
}

public class ValidSquareLeetcode593 {
	private static int dist(Point p1, Point p2) {
		return ((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y));
	}

	private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(p1[0], p1[1]));
		points.add(new Point(p2[0], p2[1]));
		points.add(new Point(p3[0], p3[1]));
		points.add(new Point(p4[0], p4[1]));

		Collections.sort(points);

		Point pt1 = points.get(0);
		Point pt2 = points.get(1);
		Point pt3 = points.get(2);
		Point pt4 = points.get(3);

		if (dist(pt1, pt2) != 0 && dist(pt1, pt3) == dist(pt3, pt4) && dist(pt3, pt4) == dist(pt4, pt2)
				&& dist(pt4, pt2) == dist(pt2, pt1) && dist(pt2, pt1) == dist(pt1, pt3)
				&& dist(pt1, pt4) == dist(pt2, pt3)) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		int[] p1 = { 0, 0 };
		int[] p2 = { 1, 1 };
		int[] p3 = { 1, 0 };
		int[] p4 = { 0, 1 };
		
		boolean ans = validSquare(p1, p2, p3, p4);
		
		System.out.println(ans);
	}

}
