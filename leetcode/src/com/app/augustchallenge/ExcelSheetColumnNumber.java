package com.app.augustchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExcelSheetColumnNumber {
	private static Map<Character, Integer> map = new HashMap<>();
	private static final int MOD = 1000000007;
	
	private static void initMap() {
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22);
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);
	}
	
	private static int getCoeff(int pow) {
		int val = 1;
		for(int i = 0; i < pow; i++) {
			val = ((val % MOD) * 26) % MOD;
		}
		return val;
	}
	
	private static int titleToNumber(String s) {
		if(s.length() == 0)
			return 0;
		initMap();
		int sum = 0;
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			int val = map.get(s.charAt(i));
			sum += val * (int)(Math.pow(26, n - 1 - i));
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.next();
		
		int sum = titleToNumber(text);
		
		System.out.println(sum);
		
		scanner.close();
	}

}
