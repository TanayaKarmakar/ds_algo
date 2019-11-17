package com.app.bitmagic.classroom;

//Brian Karninghan's algorithm
public class NumberOfSetBits {
	private static int count(int n) {
		int count = 0;
		while(n > 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(55));
		System.out.println(count(101));
	}

}
