package com.app.questions.read;

public class DivideChocolateLeetcde1231 {
	private static int calcCount(int[] sweetness, int mid) {
		int sum = 0;
		int count = 0;
		for(int el: sweetness) {
			if(sum + el <= mid) {
				sum += el;
			} else {
				sum = 0;
				count++;
			}
		}
		if(sum > mid)
			count++;
		return count;
	}

	private static int maximizeSweetness(int[] sweetness, int K) {
		int start = 1;
		int end = Integer.MAX_VALUE;
		while(start < end) {
			int mid = start + (end - start)/2;
			if(calcCount(sweetness, mid) <= K) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int ans = maximizeSweetness(nums, 5);

		System.out.println(ans);

		nums = new int[] { 1, 2, 2, 1, 2, 2, 1, 2, 2 };

		ans = maximizeSweetness(nums, 2);

		System.out.println(ans);

		nums = new int[] { 90670, 55382, 95298, 95795, 73204, 41464, 18675, 30104, 47442, 55307 };
		
		ans = maximizeSweetness(nums, 6);
		
		System.out.println(ans);

	}

}
