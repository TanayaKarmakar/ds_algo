package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagBinaryTreeLeetcode1104 {
	private static List<Integer> pathInZigZagTree(int label) {
		int height = (int) (Math.log10(label) / Math.log10(2)) + 1;
		int totalSize = (int) Math.pow(2, height);

		int[] nums = new int[totalSize];
		int val = 1;
		int start = 0;
		for (int i = 0; i < height; i++) {
			int total = (int) Math.pow(2, i);
			int end = start + total;

			if (i % 2 == 0) {
				for (int j = start; j < end; j++) {
					nums[j] = val++;
				}
			} else {
				for (int j = end - 1; j >= start; j--) {
					nums[j] = val++;
				}
			}
			start = end;
		}

		List<Integer> res = new ArrayList<>();
		int i = totalSize - 1;
		while (nums[i] != label) {
			i--;
		}

		while (i > 0) {
			res.add(0, nums[i]);
			i = (i - 1) / 2;
		}

		res.add(0, nums[0]);
		return res;
	}

	public static void main(String[] args) {
		List<Integer> res = pathInZigZagTree(14);
		System.out.println(res);

	}

}
