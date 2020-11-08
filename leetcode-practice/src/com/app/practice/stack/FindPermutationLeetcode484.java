package com.app.practice.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FindPermutationLeetcode484 {
	private static int[] findPermutation(String s) {
		int n = s.length();
		int[] res = new int[n + 1];
		int j = 0;
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <= n; i++) {
			stack.push(i + 1);
			if(i == n || s.charAt(i) == 'I') {
				while(!stack.isEmpty()) {
					res[j++] = stack.pop();
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		int[] res = findPermutation(txt);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();

	}

}
