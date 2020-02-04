package com.app.questions;

public class HappyNumber {
	private static boolean isHappy(int num) {
		int sum = 0;
		int tmp = num;
		while(sum != 1) {
			String str = String.valueOf(tmp);
			sum = 0;
			for(int i = 0;i<str.length();i++) {
				int digit = str.charAt(i) - '0';
				sum += (digit * digit);
			}
			tmp = sum;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
	}

}
