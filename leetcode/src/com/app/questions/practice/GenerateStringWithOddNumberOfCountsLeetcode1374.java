package com.app.questions.practice;

import java.util.Arrays;

public class GenerateStringWithOddNumberOfCountsLeetcode1374 {
	private static String generateString(int n) {
		char[] arr = new char[n];
		Arrays.fill(arr, 'a');
		if(n % 2 == 0) {
			arr[n - 1] = 'b';
		}
		return String.valueOf(arr);
		/*StringBuilder sb = new StringBuilder();
		if(n % 2 == 0) {
			int oddCount = n - 1;
			while(oddCount > 0) {
				sb.append("a");
				oddCount--;
			}
			sb.append("b");
		} else {
			while(n > 0) {
				sb.append("a");
				n--;
			}
		}
		return sb.toString();*/
	}

	public static void main(String[] args) {
		System.out.println(generateString(4));
		
		System.out.println(generateString(2));
		
		System.out.println(generateString(7));

	}

}
