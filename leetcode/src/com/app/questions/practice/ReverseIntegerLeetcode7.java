package com.app.questions.practice;

public class ReverseIntegerLeetcode7 {
	private static int reverseInteger(int data) {
		int temp = data;
		long res = 0;
		while(temp != 0) {
			int r = temp % 10;
			res = res * 10 + r;
			temp = temp / 10;
		}
		
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			return 0;
		if(data < 0)
			return -(int)res;
		else
			return (int)res;
	}

	public static void main(String[] args) {
		int data = 123;
		
		System.out.println(reverseInteger(data));

	}

}
