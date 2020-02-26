package com.app.backtracking.classroom;

//need to debug and understand
public class NQueensProblem {
	private static boolean isSafe(int[][] sol, int row, int col) {
		int i,j;
		for(i = 0;i<col;i++) {
			if(sol[row][i] == 1)
				return false;
		}
		
		for(i = row,j = col;i>=0 && j>=0;i--,j--) {
			if(sol[i][j] == 1)
				return false;
		}
		
		for(i = row, j = col; i < sol.length && j>=0;i++,j--) {
			if(sol[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	private static boolean solveRec(int[][] sol, int col) {
		if (col >= sol.length)
			return true;
		int n = sol.length;
		for (int i = 0; i < n; i++) {
			if(isSafe(sol, i, col)) {
				sol[i][col] = 1;
				if(solveRec(sol, col + 1))
					return true;
				
				sol[i][col] = 0;
			}
		}
		return false;
	}

	private static boolean solve(int[][] sol, int col) {
		if (!solveRec(sol, col)) {
			return false;
		} else {
			// print solution
			printSolution(sol);
			return true;
		}
	}

	private static void printSolution(int[][] sol) {
		int n = sol.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] sol = new int[n][n];
		boolean isPossible = solve(sol, 0);
		
		System.out.println("IsPossible - " + isPossible);

	}

}
