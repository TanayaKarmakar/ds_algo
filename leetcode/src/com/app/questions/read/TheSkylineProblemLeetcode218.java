package com.app.questions.read;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheSkylineProblemLeetcode218 {
	private static List<List<Integer>> getSkyLine(int[][] buildings) {
		int n = buildings.length;

		if(n == 0)
			return new ArrayList<>();
		if (n == 1) {
			int x1 = buildings[0][0];
			int x2 = buildings[0][1];
			int h = buildings[0][2];

			List<List<Integer>> points = new ArrayList<>();
			List<Integer> point1 = new ArrayList<>();
			point1.add(x1);
			point1.add(h);

			points.add(point1);

			List<Integer> point2 = new ArrayList<>();
			point2.add(x2);
			point2.add(0);

			points.add(point2);

			return points;
		}

		List<List<Integer>> leftSkyLine = getSkyLine(Arrays.copyOfRange(buildings, 0, n / 2));
		List<List<Integer>> rightSkyLine = getSkyLine(Arrays.copyOfRange(buildings, n / 2, n));
		return mergeSkyLine(leftSkyLine, rightSkyLine);
	}

	private static List<List<Integer>> mergeSkyLine(List<List<Integer>> left, List<List<Integer>> right) {
		int i = 0;
		int n1 = left.size();
		int j = 0;
		int n2 = right.size();

		int currY = 0;
		int x = 0;
		int leftY = 0;
		int rightY = 0;
		List<List<Integer>> output = new ArrayList<>();
		while (i < n1 && j < n2) {
			List<Integer> pointL = left.get(i);
			List<Integer> pointR = right.get(i);

			if (pointL.get(0) < pointR.get(0)) {
				x = pointL.get(0);
				leftY = pointL.get(1);
				i++;
			} else {
				x = pointR.get(0);
				rightY = pointR.get(1);
				j++;
			}
			int maxY = Integer.max(leftY, rightY);
			if (maxY != currY) {
				updateY(output, x, maxY);
				maxY = currY;
			}
		}

		appendSkyLine(left, output, i, n1, currY);
		appendSkyLine(right, output, j, n2, currY);

		return output;
	}

	private static void appendSkyLine(List<List<Integer>> skyLine, List<List<Integer>> output, int indx, int len,
			int currY) {
		while (indx < len) {
			List<Integer> point = skyLine.get(indx);
			indx++;

			int x = point.get(0);
			int y = point.get(1);

			if (currY != y) {
				updateY(output, x, y);
				currY = y;
			}
		}
	}

	private static void updateY(List<List<Integer>> output, int x, int y) {
		if (output.isEmpty() || output.get(output.size() - 1).get(0) != x) {
			List<Integer> newPoint = new ArrayList<>();
			newPoint.add(x);
			newPoint.add(y);
			output.add(newPoint);
		} else {
			output.get(output.size() - 1).add(1, y);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> skyLines = new ArrayList<>();
		List<Integer> point1 = new ArrayList<>();
		point1.add(2);
		point1.add(9);
		point1.add(10);
		skyLines.add(point1);

		point1 = new ArrayList<>();
		point1.add(3);
		point1.add(7);
		point1.add(15);
		skyLines.add(point1);

		point1 = new ArrayList<>();
		point1.add(5);
		point1.add(12);
		point1.add(12);
		skyLines.add(point1);

		point1 = new ArrayList<>();
		point1.add(15);
		point1.add(20);
		point1.add(10);
		skyLines.add(point1);

		point1 = new ArrayList<>();
		point1.add(19);
		point1.add(24);
		point1.add(8);
		skyLines.add(point1);

		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };

		List<List<Integer>> res = getSkyLine(buildings);
		
		System.out.println(res);

	}

}
