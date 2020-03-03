package com.app.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllIndices {
	private static void allIndices(int[] input, int x, List<Integer> res, int startIndx) {
		if (startIndx == input.length)
			return;
		if (input[startIndx] == x)
			res.add(startIndx);
		allIndices(input, x, res, startIndx + 1);
	}

	public static int[] allIndices(int[] input, int x) {
		List<Integer> res = new ArrayList<>();
		allIndices(input, x, res, 0);
		int[] resArr = new int[res.size()];
		int indx = 0;
		for (Integer el : res) {
			resArr[indx++] = el;
		}
		return resArr;
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 10, 8, 8 };
		System.out.println(Arrays.toString(allIndices(arr, 8)));
	}

}
