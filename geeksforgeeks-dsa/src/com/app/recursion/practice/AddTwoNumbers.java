package com.app.recursion.practice;

public class AddTwoNumbers {
	private static int addTwoNumbers(int num1, int num2, int carry, int sum, int coeff) {
		if(num1 == 0 && num2 == 0) {
			if(carry == 0)
				return sum;
			else
				return (carry * coeff) + sum;
		} else {
			int r1 = 0;
			int r2 = 0;
			int val = 0;
			if(num1 != 0) {
				r1 = num1 % 10;
				val += r1;
			}
			if(num2 != 0) {
				r2 = num2 % 10;
				val += r2;
			}
			if(carry > 0) {
				val += carry;
			}
			if(val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			sum += (val * coeff);
			return addTwoNumbers(num1/10, num2/10, carry, sum, coeff * 10);
		}
	}

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(addTwoNumbers(num1, num2, 0, 0, 1));
		
		num1 = 1234;
		num2 = 456;
		
		System.out.println(addTwoNumbers(num1, num2, 0, 0, 1));
		
		num1 = 99;
		num2 = 97;
		
		System.out.println(addTwoNumbers(num1, num2, 0, 0, 1));

	}

}
