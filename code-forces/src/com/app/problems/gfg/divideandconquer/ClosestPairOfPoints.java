package com.app.problems.gfg.divideandconquer;

import java.util.Arrays;;

public class ClosestPairOfPoints {
	private static double getDist(int[] pt1, int[] pt2) {
		double xPart = (pt1[0] - pt2[0]) * (pt1[0] - pt2[0]);
		double yPart = (pt1[1] - pt2[1]) * (pt1[1] - pt2[1]);
		return Math.sqrt(xPart + yPart);
	}
	
	private static double findDistance(int[][] points, int low, int high) {
		double min = Integer.MAX_VALUE;
		for(int i = low; i <= high; i++) {
			for(int j = low; j <= high; j++) {
				if(i != j) {
					double dist = getDist(points[i], points[j]);
					min = Double.min(min, dist);
				}
			}
		}
		return min;
	}
	
	private static double stripClosest(int[][] strips, int n, double d) {
		Arrays.sort(strips, (p1, p2) -> p1[1] - p2[1]);
		double min = d;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				double currentDist = getDist(strips[i], strips[j]);
				if(currentDist < min) {
					min = currentDist;
				}
			}
		}
		return min;
	}
	
	private static double findMin(int[][] points, int low, int high) {
		if((high - low + 1) <= 3)
			return findDistance(points, low, high);
		int mid = low + (high - low) / 2;
		double dl = findMin(points, 0, mid);
		double dr = findMin(points, mid + 1, high);
		double d = Double.min(dl, dr);
		
		int[] midPoint = points[mid];
		int n = (high - low + 1);
		int[][] strips = new int[n][2];
		
		int j = 0;
		for(int i = low; i <= high; i++) {
			if(Math.abs(midPoint[0] - points[i][0]) < d) {
				strips[j++] = points[i];
			}
		}
		
		return Double.min(d, stripClosest(strips, j, d));

	}

	private static double findMinDistance(int[][] points) {
		int n = points.length;
		Arrays.sort(points, (p1, p2) -> (p1[0] - p2[0]));
		return findMin(points, 0, n - 1);
	}

	public static void main(String[] args) {
		int[][] points = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
		double minDist = findMinDistance(points);
		
		System.out.println("Find Minimum Distance - " + minDist);
	}

}
