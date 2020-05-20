package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	public int dist;
	public int[] point;

	@Override
	public int compareTo(Point that) {
		if (this.dist == that.dist)
			return 0;
		else if (this.dist < that.dist)
			return -1;
		else
			return 1;
	}
}

public class KClosestPointsLeetcode973 {
	private static int euclideanDistance(int[] point) {
		int sqr1 = point[0] * point[0];
		int sqr2 = point[1] * point[1];
		int dist = (int) Math.sqrt((sqr1 + sqr2));
		return dist;
	}

	private static int[][] kClosestPoints(int[][] grid, int k) {
		int[][] res = new int[k][2];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int[] el : grid) {
			int dist = euclideanDistance(el);
			Point pt = new Point();
			pt.dist = dist;
			pt.point = el;
			pq.add(pt);
		}
			
		for(int i = 0; i < k; i++) {
			res[i] = pq.poll().point;
		}
		return res;
	}

	public static void main(String[] args) {
//		int[][] points = { { 1, 3 }, { -2, 2 } };

		int[][] points = { { -5, 4 }, { -6, -5 }, { 4, 6 } };

		int[][] res = kClosestPoints(points, 2);

		System.out.println(Arrays.deepToString(res));

		points = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		res = kClosestPoints(points, 2);

		System.out.println(Arrays.deepToString(res));

	}

}
