package com.app.problems.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMath {
	private static String newSum(String str) {
		if(str.length() == 1 && Character.isDigit(str.charAt(0)))
			return str;
		int n = str.length();
		int len = n / 2 + 1;
		int[] nums = new int[len];
		int k = 0;
		for(int i = 0; i < n; i++) {
			if(Character.isDigit(str.charAt(i))) {
				nums[k++] = str.charAt(i) - '0';
			}
		}
		
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len - 1; i++) {
			sb.append(nums[i] + "+");
		}
		sb.append(nums[len - 1]);
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		String output = newSum(str);
		
		System.out.println(output);
		
		scanner.close();
	}

}
