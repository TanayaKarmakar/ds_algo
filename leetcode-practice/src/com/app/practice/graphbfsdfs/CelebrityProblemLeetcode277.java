package com.app.practice.graphbfsdfs;

class Relation {
	int[][] relations;

	public Relation(int[][] relations) {
		this.relations = relations;
	}

	public boolean knows(int i, int j) {
		return relations[i][j] == 1;
	}
}

public class CelebrityProblemLeetcode277 extends Relation {

	public CelebrityProblemLeetcode277(int[][] relations) {
		super(relations);
	}

	public int findCelebrity(int n) {
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if (knows(start, end))
				start++;
			else
				end--;
		}

		for (int i = 0; i < n; i++) {
			if ((i != start) && (knows(start, i) || !knows(i, start)))
				return -1;
		}

		return start;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		CelebrityProblemLeetcode277 obj = new CelebrityProblemLeetcode277(graph);
		int ans = obj.findCelebrity(3);
		System.out.println(ans);
	}

}
