package com.app.prereq.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetMarble {
	private static boolean isArrangementPossible(int[] nums, int target, List<Integer> res) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			res.add(nums[i]);
			int newTarget = target - nums[i];
			int sum = 0;
			int j = i + 1;
			while (j < n && sum < newTarget) {
				sum += nums[j];
				res.add(nums[j]);
				j++;
			}

			if (sum == newTarget)
				return true;
			if (sum > newTarget) {
				res.clear();
				sum = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int nDim = Integer.parseInt(input.split("\\s+")[0]);
		int target = Integer.parseInt(input.split("\\s+")[1]);

		int[] nums = new int[nDim];
		String strInput = scanner.nextLine();

		int indx = 0;
		for (String el : strInput.split("\\s+")) {
			nums[indx++] = Integer.parseInt(el);
		}

		List<Integer> res = new ArrayList<>();
		boolean isPossible = isArrangementPossible(nums, target, res);
		System.out.println(isPossible);
		if (isPossible) {
			for (Integer el : res) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
		scanner.close();

	}

}
