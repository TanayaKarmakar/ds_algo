package com.app.adhoc.problems;

//problem statement link - https://codeforces.com/problemset/problem/1037/C
public class Equalizer {
	private static int getCost(String s, String t) {
		int n = s.length();
		
		int i = 0;
		int cost = 0;
		while(i < n) {
			if(s.charAt(i) != t.charAt(i)) {
				if(i + 1 < n && s.charAt(i) != s.charAt(i + 1) 
						&& s.charAt(i + 1) != t.charAt(i + 1)) {
					i+=2;
				} else {
					i++;
				}
				cost++;
			} else {
				i++;
			}
		}
		return cost;
	}

	public static void main(String[] args) {
		String s = "1001";
		String t = "1100";
		
		int cost = getCost(s, t);
		
		System.out.println("Cost - " + cost);

	}

}
