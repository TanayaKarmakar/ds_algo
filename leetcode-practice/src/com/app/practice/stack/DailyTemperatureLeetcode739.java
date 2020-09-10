package com.app.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatureLeetcode739 {
	private static int[] dailyTemperatures(int[] T) {
		int n = T.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(n - 1);

		int[] ans = new int[n];

		for (int i = n - 2; i >= 0; i--) {
			if (T[i] < T[stack.peek()]) {
				ans[i] = stack.peek() - i;
			} else {
				while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
					stack.pop();
				}

				if (!stack.isEmpty())
					ans[i] = stack.peek() - i;
			}
			stack.push(i);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = dailyTemperatures(T);
		
		System.out.println(Arrays.toString(ans));
	}

}
