package com.app.graph1.problems;

import java.util.Scanner;

public class ThreeCycles {
	private static int solve(int n, int m, int[] U, int[] V) {
		int[][] edges = new int[n][n];
		for(int i = 0; i < m; i++) {
			int n1 = U[i];
			int n2 = V[i];
			edges[n1 - 1][n2 - 1] = 1;
			edges[n2 - 1][n1 - 1] = 1;
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(edges[i][j] == 1) {
					for(int k = 0; k < n; k++) {
						if(k == i)
							continue;
						if(edges[j][k] == 1) {
							if(edges[k][i] == 1)
								count++;
						}		
					}
				}
			}
		}
		
		return count / 6;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[] u = new int[m];
		int[] v = new int[n];
		
		for(int i = 0; i < m; i++) {
			u[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			v[i] = scanner.nextInt();
		}
		
		int count = solve(n, m, u, v);
		
		System.out.println(count);

		scanner.close();
	}

}
