package com.app.bitmagic.classroom;

//swapping two numbers without using third variable
public class SwappingNumbers {
	private static void swap(Integer a, Integer b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After swap - {a = " + a + ", b = " + b + "}");
	}

	public static void main(String[] args) {
		Integer a = 12;
		Integer b = 5;
		System.out.println("Before swap - {a = " + a + ", b = " + b + "}");
		swap(a, b);
	}

}
