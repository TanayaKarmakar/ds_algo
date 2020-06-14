package com.app.questions.bit;

public class NumberOf1Bits {
	private static int hammingWeight(int n) {
		int count = 0;
		int temp = n;
		while(temp != 0) {
			count++;
			temp = temp & (temp - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 12;
		
		System.out.println(hammingWeight(n));

	}

}
