package com.app.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidSquareLeetcode593 {
	static class Point1 implements Comparable<Point1> {
		int x;
		int y;
		
		public Point1(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point1 o) {
			if(this.x < o.x)
				return -1;
			else if(this.x > o.x)
				return 1;
			else
				return (this.y - o.y);
		}
	}
	
	private static int dist(Point1 p1, Point1 p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	
	private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<Point1> points = new ArrayList<>();
		points.add(new Point1(p1[0], p1[1]));
		points.add(new Point1(p2[0], p2[1]));
		points.add(new Point1(p3[0], p3[1]));
		points.add(new Point1(p4[0], p4[1]));
		
		Collections.sort(points);
		
		Point1 pt1 = points.get(0);
		Point1 pt2 = points.get(1);
		Point1 pt3 = points.get(2);
		Point1 pt4 = points.get(3);
		
		System.out.println("dist(pt1, pt2) - " + dist(pt1, pt2));
		System.out.println("dist(pt2, pt3) - " + dist(pt2, pt3));
		if(dist(pt1, pt2)!= 0 && dist(pt1, pt2) == dist(pt2, pt4) 
				&& dist(pt2, pt4) == dist(pt3, pt4) && dist(pt3, pt4) == dist(pt3, pt1)
				&& dist(pt1, pt4) == dist(pt2, pt3))
			return true;
		return false;
		
	}

	public static void main(String[] args) {
		int[] p1 = {1, 0};
		int[] p2 = {-1, 0};
		int[] p3 = {0, 1};
		int[] p4 = {0, -1};
		
		boolean isValid = validSquare(p1, p2, p3, p4);
		
		System.out.println(isValid);
		

	}

}
