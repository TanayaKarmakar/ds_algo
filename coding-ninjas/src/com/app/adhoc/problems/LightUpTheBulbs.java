package com.app.adhoc.problems;

import java.util.Scanner;

public class LightUpTheBulbs {
	private static long minCost(String str, long x, long y, long n) {
		long nGroups = 0;
		if (str.charAt(0) == '0')
			nGroups++;

		for (int i = 1; i < n; i++) {
			if (str.charAt(i) == '0' && str.charAt(i - 1) == '1')
				nGroups++;
		}
		
		long cost = 0;

		if(nGroups >= 1) {
			cost = (nGroups - 1) * Long.min(x, y) + y;
		}
		
		return cost;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		long nLen = Long.parseLong(inputStr.split("\\s+")[0]);
		long x = Long.parseLong(inputStr.split("\\s+")[1]);
		long y = Long.parseLong(inputStr.split("\\s+")[2]);
		String str = scanner.nextLine();
		
		long minCost = minCost(str, x, y, nLen);
		
		System.out.println(minCost);
		
		scanner.close();

	}

}
