package com.strings.basic;

public class RoundOffNumber {	
	private static String roundOffNumber(String str) {
		int n = str.length();
		if(str.charAt(n - 1) == '0')
			return str;
		Integer number = Integer.parseInt(str.trim());
		int res = number % 10;
		String ans = str.substring(0, (n - 2));
		if(res > 5) {
			int num = Integer.parseInt(Character.toString(str.charAt(n - 2))) + 1;
			return ans + num + '0';
		} else {
			return ans + str.charAt(n - 2) + '0';
		}
	}

	public static void main(String[] args) {
		String str = "4722";
		System.out.println(roundOffNumber(str));
		
		str = "38";
		System.out.println(roundOffNumber(str));
	}

}
