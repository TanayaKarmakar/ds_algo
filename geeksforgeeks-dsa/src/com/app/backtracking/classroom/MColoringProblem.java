package com.app.backtracking.classroom;

public class MColoringProblem {
	private static boolean isSafe(int[][] graph, int c, int v, int[] color) {
		for (int edge = 0; edge < graph.length; edge++) {
			if (graph[v][edge] == 1 && color[edge] == c)
				return false;
		}
		return true;
	}

	private static boolean solveColoringRec(int[][] graph, int m, int v, int[] color) {
		if (v == graph.length)
			return true;
		else {
			for (int c = 1; c <= m; c++) {
				if (isSafe(graph, c, v, color)) {
					color[v] = c;

					if (solveColoringRec(graph, m, v + 1, color))
						return true;

					color[v] = 0;
				}
			}
		}
		return false;
	}

	private static boolean solveColoring(int[][] graph, int m) {
		int v = graph.length;
		int[] color = new int[v];
		if (solveColoringRec(graph, m, 0, color)) {
			// print solution
			printSolution(color);
			return true;
		} else {
			System.out.println("No solution possible");
			return false;
		}
	}

	private static void printSolution(int[] color) {
		for (Integer el : color) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] graph = { 
				{ 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0 }, 
				{ 1, 1, 0, 1 }, 
				{ 1, 0, 1, 0 } 
			};
		
		int m = 3;
		solveColoring(graph, m);
	}

}
