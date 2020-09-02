package com.app.practice.math;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangleLeetcode497 {
	TreeMap<Integer, int[]> tMap;
	int areaSum;
	Random rand;

	public RandomPointInNonOverlappingRectangleLeetcode497(int[][] rects) {
		tMap = new TreeMap<>();
		areaSum = 0;

		for (int[] rect : rects) {
			int length = rect[2] - rect[0] + 1;
			int breadth = rect[3] - rect[1] + 1;
			areaSum += (length * breadth);
			tMap.put(areaSum, rect);
		}

		rand = new Random();
	}

	public int[] pick() {
		int key = tMap.ceilingKey(rand.nextInt(areaSum));
		int[] rect = tMap.get(key);

		int length = rect[2] - rect[0] + 1;
		int breadth = rect[3] - rect[1] + 1;

		int x = rect[0] + rand.nextInt(length);
		int y = rect[1] + rand.nextInt(breadth);

		return new int[] { x, y };
	}

	public static void main(String[] args) {
		int[][] rects = { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } };
		RandomPointInNonOverlappingRectangleLeetcode497 obj = 
				new RandomPointInNonOverlappingRectangleLeetcode497(rects);
		
		System.out.println(Arrays.toString(obj.pick()));
		System.out.println(Arrays.toString(obj.pick()));
		System.out.println(Arrays.toString(obj.pick()));

	}

}
