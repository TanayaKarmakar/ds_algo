package com.app.interviewbit.array;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubArray {
	private static int maxSubArray(final List<Integer> A) {
		int size = A.size();
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			currentSum += A.get(i);

			maxSum = Integer.max(currentSum, maxSum);

			if (currentSum < 0)
				currentSum = 0;

		}
		return maxSum;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(-2);
		list.add(1);
		list.add(-3);
		list.add(4);
		list.add(-1);
		list.add(2);
		list.add(1);
		list.add(-5);
		list.add(4);
		
		int maxSum = maxSubArray(list);
		
		System.out.println(maxSum);
	}

}
