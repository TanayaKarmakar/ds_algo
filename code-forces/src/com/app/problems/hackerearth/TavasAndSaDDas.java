package com.app.problems.hackerearth;

public class TavasAndSaDDas {
	private static int findIndx(String s) {
		int n = s.length();
		int ans = (1 << n) - 2;
		int i = n - 1;
		int pos = 0;
		while(i >= 0) {
			if(s.charAt(i) == '7') {
				ans += (1 << pos);
			}
			pos++;
			i--;
		}
		
		return ans + 1;
	}

	public static void main(String[] args) {
		System.out.println(findIndx("4"));
		
		System.out.println(findIndx("7"));
		
		System.out.println(findIndx("77"));
	}
}
