package com.app.problems.gfg.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class RatInAMazeProblem1 {
	

	private static void generateAllPath(int[][] m, int i, int j, int n, List<String> res, String path,
			Set<Point> visited) {
		if (i < 0 || i >= n || j < 0 || j >= n || m[i][j] == 0 || visited.contains(new Point(i, j)))
			return;
		if (i == n - 1 && j == n - 1) {
			res.add(path);
			return;
		}
		visited.add(new Point(i, j));
		generateAllPath(m, i - 1, j, n, res, path + 'U', visited);
		generateAllPath(m, i + 1, j, n, res, path + 'D', visited);
		generateAllPath(m, i, j - 1, n, res, path + 'L', visited);
		generateAllPath(m, i, j + 1, n, res, path + 'R', visited);
		visited.remove(new Point(i, j));
	}

	private static List<String> findAllPath(int[][] m, int n) {
		List<String> res = new ArrayList<>();
		Set<Point> visited = new HashSet<>();
		generateAllPath(m, 0, 0, n, res, "", visited);
		Collections.sort(res);
		return res;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		List<String> res = findAllPath(m, 4);

		System.out.println(res);

		m = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 1, 1, 1 } };

		res = findAllPath(m, 4);

		System.out.println(res);

		m = new int[][] { { 1, 0 }, { 1, 0 } };
	}

}
