package com.app.practice.array;

public class AddDigitsLeetcode258 {
	private static int addDigits(int num) {
		while(Integer.toString(num).length() > 1) {
			int tmp = num;
			int sum = 0;
			while(tmp != 0) {
				int r = tmp % 10;
				sum += r;
				tmp = tmp / 10;
			}
			num = sum;
		}
		
		return num;
	}

	public static void main(String[] args) {

	}

}
