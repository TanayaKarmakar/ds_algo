package com.app.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
	private static int convertToInteger(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
		int n = s.length();
		int sum = map.get(s.charAt(n - 1));

		for (int i = n - 2; i >= 0; i--) {
			int curr = map.get(s.charAt(i));
			int next = map.get(s.charAt(i + 1));

			if (curr < next)
				sum -= curr;
			else
				sum += curr;
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		int ans = convertToInteger(str);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
