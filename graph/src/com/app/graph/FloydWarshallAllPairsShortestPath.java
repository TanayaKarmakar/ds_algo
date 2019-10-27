package com.app.graph;

import java.util.Arrays;

public class FloydWarshallAllPairsShortestPath {
	private static void createGraph(double[][] mat, int nVertices) {
		for (int i = 0; i < nVertices; i++) {
			Arrays.fill(mat[i], Double.POSITIVE_INFINITY);
			mat[i][i] = 0;
		}
	}

	private static void propagateNegativeCycles(double[][] dp, int nVertices) {
		for (int k = 0; k < nVertices; k++) {
			for (int i = 0; i < nVertices; i++) {
				for (int j = 0; j < nVertices; j++) {
					if (dp[i][k] + dp[k][j] < dp[i][j]) {
						dp[i][j] = Double.NEGATIVE_INFINITY;
					}
				}
			}
		}
	}

	private static double[][] findAllPairsShortestPath(double[][] adjMat, int nVertices) {
		double[][] dp = new double[nVertices][nVertices];

		for (int i = 0; i < nVertices; i++) {
			for (int j = 0; j < nVertices; j++) {
				dp[i][j] = adjMat[i][j];
			}
		}

		for (int k = 0; k < nVertices; k++) {
			for (int i = 0; i < nVertices; i++) {
				for (int j = 0; j < nVertices; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		propagateNegativeCycles(dp, nVertices);

		return dp;
	}

	public static void main(String[] args) {
		int nVertices = 4;
		double[][] adjMat = new double[nVertices][nVertices];
		createGraph(adjMat, nVertices);

		adjMat[0][1] = 4;
		adjMat[0][2] = 1;
		adjMat[1][2] = 6;
		adjMat[2][0] = 4;
		adjMat[2][1] = 1;
		adjMat[2][3] = 2;

		double[][] shortestDistances = findAllPairsShortestPath(adjMat, nVertices);
		System.out.println(Arrays.deepToString(shortestDistances));
	}

}
