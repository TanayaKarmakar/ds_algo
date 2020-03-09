package com.app.questions;

import java.util.Arrays;

public class GenerateStringLeetcode1374 {
	private static String generateString(int n) {
		char[] strArr = new char[n];
		Arrays.fill(strArr, 'a');
		if(n % 2 == 0) {
			strArr[n - 1] = 'b';
		}
		return String.valueOf(strArr);
	}

	public static void main(String[] args) {
		int n = 3;
		
		System.out.println(generateString(n));
		
		System.out.println(generateString(6));

	}

}
