package com.app.problems;

public class DecodingAlphabets {
	//recursive solution
	private static int helper(String data, int k) {
		if(k == 0)
			return 1;
		int s = data.length() - k;
		if(data.charAt(s) == '0') 
			return 0;
		int result = helper(data, k - 1);
		if(k >= 2 && (s + 2) < data.length() && Integer.parseInt(data.substring(s, s+2)) <= 26)
			result += helper(data, k - 2);
		
		return result;
	}
	
	//recurisve solution
	private static int numWays(String data) {
		return helper(data, data.length());
	}
	

	public static void main(String[] args) {
		System.out.println(" Ways - " + numWays("12345"));
		System.out.println(" Ways - " + numWays("011"));
	}

}
