package com.app.augustchallenge;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangle {
	TreeMap<Integer, int[]> treeMap;
	Random random;
	int areaSum = 0;

	public RandomPointInNonOverlappingRectangle(int[][] rects) {
		treeMap = new TreeMap<>();
		random = new Random();

		for (int i = 0; i < rects.length; i++) {
			int[] rectangle = rects[i];
			int length = rectangle[2] - rectangle[0] + 1;
			int breadth = rectangle[3] - rectangle[1] + 1;

			areaSum += (length * breadth);
			treeMap.put(areaSum, rectangle);
		}
	}

	public int[] pick() {
		int key = treeMap.ceilingKey(random.nextInt(areaSum) + 1);
		int[] rectangle = treeMap.get(key);
		int length = rectangle[2] - rectangle[0] + 1;
		int breadth = rectangle[3] - rectangle[1] + 1;

		int x = rectangle[0] + random.nextInt(length);
		int y = rectangle[1] + random.nextInt(breadth);

		return new int[] { x, y };
	}

	public static void main(String[] args) {
		int[][] rect = { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } };
		RandomPointInNonOverlappingRectangle obj 
		= new RandomPointInNonOverlappingRectangle(rect);
		
		System.out.println(Arrays.toString(obj.pick()));
		System.out.println(Arrays.toString(obj.pick()));
	}

}
