package com.app.recursion.classroom;

public class PrintSubsets {
	private static void subset(String str, String curr, int indx) {
		if(indx == str.length()) {
			System.out.println(curr);
			return;
		}
		subset(str, curr, indx + 1);
		subset(str, curr = curr + str.charAt(indx), indx + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		subset(str, "", 0);
	}

}
