package com.app.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class FindPermutationLeetcode484 {
	private static int[] findPermutation(String s) {
		int n = s.length();
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[n + 1];

		int j = 0;
		for (int i = 0; i <= n; i++) {
			stack.push(i + 1);
			if (i == n || s.charAt(i) == 'I') {
				while (!stack.isEmpty()) {
					res[j++] = stack.pop();
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String s = "I";
		int[] res = findPermutation(s);

		System.out.println(Arrays.toString(res));

	}

}
