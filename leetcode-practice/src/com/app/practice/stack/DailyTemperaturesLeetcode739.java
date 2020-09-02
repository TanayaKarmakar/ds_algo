package com.app.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturesLeetcode739 {
	private static int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();

		int n = T.length;
		stack.push(n - 1);

		int[] ans = new int[n];

		for (int i = n - 2; i >= 0; i--) {
			if (!stack.isEmpty() && T[i] < T[stack.peek()]) {
				ans[i] = (stack.peek() - i);
			} else {
				while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					ans[i] = (stack.peek() - i);
				}		
			}
			stack.push(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] t = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = dailyTemperatures(t);
		
		System.out.println(Arrays.toString(ans));

	}

}
