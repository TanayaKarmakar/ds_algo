package com.app.interviewbit.array;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
	private static int maxDiff(ArrayList<Integer> A) {
		if(A.isEmpty())
			return 0;
		
		int n = A.size();
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			max1 = Integer.max(max1, A.get(i) + i);
			min1 = Integer.min(min1, A.get(i) + i);
			max2 = Integer.max(max2, A.get(i) - i);
			min2 = Integer.min(min2, A.get(i) - i);
		}
		
		int maxDiff = Integer.max(max1 - min1, max2 - min2);
		
		return maxDiff;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(-1);
		
		System.out.println(maxDiff(list));

	}

}
