package com.app.recursion.classroom;

public class SumOfDigits {
	private static int sumOfDigits(int num) {
//		if (num == 0)
//			return 0;
		if(num < 10)
			return num;
		else
			return num % 10 + sumOfDigits(num / 10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfDigits(253));
		System.out.println(sumOfDigits(9987));

	}

}
