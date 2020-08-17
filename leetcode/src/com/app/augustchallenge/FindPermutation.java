package com.app.augustchallenge;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FindPermutation {
	private static int[] findPermutation(String s) {
		int n = s.length();
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[n + 1];
		int j = 0;
		for(int i = 0; i <= n; i++) {
			stack.push(i + 1);
			if(i == n || s.charAt(i) == 'I') {
				while(!stack.isEmpty())
					res[j++] = stack.pop();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		int[] output = findPermutation(txt);
		
		System.out.println(Arrays.toString(output));
		
		scanner.close();
	}

}
