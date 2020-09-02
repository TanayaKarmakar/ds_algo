package com.app.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class Item implements Comparable<Item> {
	int dist;
	int[] item;

	public Item(int dist, int[] item) {
		this.dist = dist;
		this.item = item;
	}

	@Override
	public int compareTo(Item o) {
		return this.dist - o.dist;
	}
}

public class KClosestPointsToOriginLeetcode973 {
	private static int dist(int[] point) {
		return (point[0] * point[0] + point[1] * point[1]);
	}

	private static int[][] kClosest(int[][] points, int k) {
		if (points.length == 0)
			return new int[][] {};
		PriorityQueue<Item> pQ = new PriorityQueue<>();

		int n = points.length;

		for (int i = 0; i < n; i++) {
			int dist = dist(points[i]);

			Item item = new Item(dist, points[i]);
			pQ.add(item);
		}

		int[][] res = new int[k][2];

		int i = 0;
		while (!pQ.isEmpty() && k > 0) {
			res[i++] = pQ.poll().item;
			k--;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { -2, 2 } };

		int[][] res = kClosest(points, 1);

		System.out.println(Arrays.deepToString(res));

		points = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		
		res = kClosest(points, 2);

		System.out.println(Arrays.deepToString(res));

	}

}
