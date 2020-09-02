package com.app.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

class Point1 implements Comparable<Point1> {
	int[] point;
	double dist;

	@Override
	public int compareTo(Point1 o) {
		if (this.dist < o.dist)
			return -1;
		else if (this.dist > o.dist)
			return 1;
		else
			return 0;
	}
}

public class KClosestPointToOriginLeetcode973 {
	private static double euclideanDist(int[] point) {
		int x = point[0];
		int y = point[1];
		return Math.sqrt(x * x + y * y);
	}

	private static int[][] kClosest(int[][] grid, int k) {
		PriorityQueue<Point1> pQ = new PriorityQueue<>();

		int n = grid.length;
		for (int i = 0; i < n; i++) {
			int[] point = grid[i];
			double dist = euclideanDist(point);
			Point1 pt = new Point1();
			pt.point = point;
			pt.dist = dist;
			pQ.add(pt);
		}

		int[][] res = new int[k][2];
		int i = 0;
		while (!pQ.isEmpty() && i < k) {
			res[i++] = pQ.poll().point;
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -5 }, { -2, 4 } };
		
		int[][] res = kClosest(points, 2);
		
		System.out.println(Arrays.deepToString(res));

	}

}
