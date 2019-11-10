package com.app.bitmagic.practice;

//You are given two numbers A and B. Write a program to 
//count number of bits needed to be flipped to convert A to B.
public class BitsNeededToFlip {
	private static int numBitsNeedToFlip(int a, int b) {
		int xor = a ^ b;
		int res = 0;
		while (xor > 0) {
			xor = (xor & (xor - 1));
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(numBitsNeedToFlip(10, 20));
		System.out.println(numBitsNeedToFlip(20, 25));
	}

}
