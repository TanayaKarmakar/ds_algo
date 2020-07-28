package com.app.problems.gfg.dfsbfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class TransitiveClosure {
	private static boolean hasPath(LinkedList<Integer>[] edges, int start, int end, Set<Integer> visited) {
		if (start == end)
			return true;
		visited.add(start);
		LinkedList<Integer> neighbors = edges[start];
		for (Integer nei : neighbors) {
			if (!visited.contains(nei)) {
				if (hasPath(edges, nei, end, visited) == true)
					return true;
			}
		}
		return false;
	}

	private static int[][] transitiveClosure(LinkedList<Integer>[] edges, int n) {
		int[][] mat = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(mat[i], -1);
			mat[i][i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (mat[i][j] == -1) {
					Set<Integer> visited = new HashSet<>();
					boolean hasPath1 = hasPath(edges, i, j, visited);

					if (hasPath1) {
						mat[i][j] = 1;
					} else {
						mat[i][j] = 0;
					}

					visited.clear();
					boolean hasPath2 = hasPath(edges, j, i, visited);
					if (hasPath2) {
						mat[j][i] = 1;
					} else {
						mat[j][i] = 0;
					}
				}
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();

		LinkedList<Integer>[] edges = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new LinkedList<>();
		}

		for (int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			edges[v1].add(v2);
		}

		int[][] result = transitiveClosure(edges, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
