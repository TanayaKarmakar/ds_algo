package com.app.recursion.practice;

public class PowerUsingRecursion {
	private static int power(int num, int power) {
		if(power == 1)
			return num;
		return num * power(num, --power);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2,9));
	}

}
