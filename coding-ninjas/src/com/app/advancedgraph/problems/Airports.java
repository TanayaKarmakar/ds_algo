package com.app.advancedgraph.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Road implements Comparable<Road> {
	int x;
	int y;
	int cost;

	public Road(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Road o) {
		return this.cost - o.cost;
	}
}

public class Airports {

	private static int getParent(int i, int[] parent) {
		if (parent[i] == i)
			return i;
		i = parent[i];
		return getParent(i, parent);
	}

	private static int getTotalRoadCost(List<Road> edges, int[] parent, int airPortCost) {
		Collections.sort(edges);

		int cost = 0;
		for (Road edge : edges) {
			int xParent = getParent(edge.x, parent);
			int yParent = getParent(edge.y, parent);

			if (xParent != yParent && edge.cost < airPortCost) {
				if (xParent < yParent) {
					parent[yParent] = xParent;
				} else {
					parent[xParent] = yParent;
				}
				cost += edge.cost;
			}
		}

		return cost;
	}

	private static void getMinimumCost(List<Road> edges, int[] parent, int airPortCost, int n, int caseno) {
		int roadCost = getTotalRoadCost(edges, parent, airPortCost);

		int count = 0;
		for (int i = 0; i <= n; i++) {
			if (parent[i] == i)
				count++;
		}

		int totalCost = (count * airPortCost) + roadCost;
		System.out.println("Case #" + caseno + ":" + totalCost + " " + count);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		int j = 0;
		while (j++ < nTestCases) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int a = scanner.nextInt();
			int[] parent = new int[n + 1];

			for (int i = 1; i < n; i++) {
				parent[i] = i;
			}

			List<Road> edges = new ArrayList<>();
			while (m-- > 0) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				int c = scanner.nextInt();
				Road road = new Road(v1, v2, c);
				edges.add(road);
			}

			getMinimumCost(edges, parent, a, n, j);
		}
		scanner.close();
	}
}
