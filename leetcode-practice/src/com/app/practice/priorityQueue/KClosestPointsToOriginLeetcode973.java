package com.app.practice.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	int[] point;
	int dist;

	public Point(int[] point, int dist) {
		this.point = point;
		this.dist = dist;
	}

	@Override
	public int compareTo(Point o) {
		return this.dist - o.dist;
	}
}

public class KClosestPointsToOriginLeetcode973 {
	private static int getDist(int[] point) {
		return ((point[0] * point[0]) + (point[1] * point[1]));
	}

	private static int[][] kClosest(int[][] points, int K) {
		int n = points.length;
		int[][] output = new int[K][2];
		PriorityQueue<Point> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int dist = getDist(points[i]);
			Point pt = new Point(points[i], dist);
			pQ.add(pt);
		}

		for (int i = 0; i < K; i++) {
			output[i] = pQ.poll().point;
		}

		return output;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { 2, -2 } };
		
		int[][] output = kClosest(points, 1);
		
		System.out.println(Arrays.deepToString(output));

	}

}
