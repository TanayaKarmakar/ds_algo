package com.app.computationalgeometry.problems;

import java.util.Scanner;

//class Point {
//	int x;
//	int y;
//}
//
//class Polygon {
//	Point[] points;
//	
//	public Polygon(int n) {
//		this.points = new Point[n];
//	}
//}

public class AreaOfAPolygon {
	private static int area(int[] xVals, int[] yVals, int n) {
		int fArea = 0;
		for(int i = 1; i < n - 1; i++) {
//			double x1 = polygon.points[i].x - polygon.points[0].x;
//			double y1 = polygon.points[i].y - polygon.points[0].x;
//			double x2 = polygon.points[i + 1].x - polygon.points[0].x;
//			double y2 = polygon.points[i + 1].y - polygon.points[0].y;
			int x1 = xVals[i] - xVals[0];
			int y1 = yVals[i] - yVals[0];
			int x2 = xVals[i + 1] - xVals[0];
			int y2 = yVals[i + 1] - yVals[0];
			fArea += (x1 * y2 - y1 * x2);
		}
		
		return Math.abs(fArea / 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		//Polygon polygon = new Polygon(n);
		int[] xVals = new int[n];
		int[] yVals = new int[n];
		
		for(int i = 0; i < n; i++) {
//			polygon.points[i].x = scanner.nextInt();
//			polygon.points[i].y = scanner.nextInt();
			xVals[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			yVals[i] = scanner.nextInt();
		}
		
		int area = area(xVals, yVals, n);
		
		System.out.println(area);
		scanner.close();
	}
}
