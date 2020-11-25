package com.app.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatureLeetcode739 {
	private static int[] dailyTemperatures(int[] T) {
		if(T.length == 0)
			return new int[] {};
		int n = T.length;
		Stack<Integer> stack = new Stack<>();

		int[] res = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty() || T[i] < T[stack.peek()]) {
				if (!stack.isEmpty() && T[i] < T[stack.peek()]) {
					res[i] = stack.peek() - i;
				}
			} else {
				while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					res[i] = stack.peek() - i;
				}
			}
			stack.push(i);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		
		System.out.println(Arrays.toString(dailyTemperatures(T)));

	}

}
