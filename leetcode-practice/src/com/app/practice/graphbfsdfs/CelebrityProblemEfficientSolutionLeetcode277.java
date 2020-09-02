package com.app.practice.graphbfsdfs;

class RelationShip {
	private int[][] grid;

	public RelationShip(int[][] grid) {
		this.grid = grid;
	}

	public boolean knows(int i, int j) {
		return grid[i][j] == 1;
	}
}

public class CelebrityProblemEfficientSolutionLeetcode277 {
	private static int findCelebrity(int n, RelationShip relation) {
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if (relation.knows(start, end))
				start++;
			else
				end--;
		}

		for (int i = 0; i < n; i++) {
			if (i != start && (relation.knows(start, i) || !(relation.knows(i, start))))
				return -1;
		}
		return start;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		RelationShip relation = new RelationShip(grid);
		
		int celebrity = findCelebrity(grid.length, relation);
		
		System.out.println(celebrity);
	}

}
