package com.app.questions.greedy;

public class MaximumSwapLeetcode670 {
	private static int maximumSwap(int num) {
		char[] arr = Integer.toString(num).toCharArray();

		int[] last = new int[10];
		for (int i = 0; i < arr.length; i++) {
			last[arr[i] - '0'] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int d = 9; d > (arr[i] - '0'); d--) {
				if (last[d] > i) {
					char temp = arr[i];
					arr[i] = arr[last[d]];
					arr[last[d]] = temp;
					return Integer.parseInt(new String(arr));
				}
			}
		}
		
		return num;
	}

	public static void main(String[] args) {
		int num = 9973;
		
		int ans = maximumSwap(num);
		System.out.println(ans);
		
		num = 2763;
		ans = maximumSwap(num);
		System.out.println(ans);

	}

}
