package com.app.bitmanipulation.problems;

public class TurnOffFirstSetBit {
	private static int turnOffSetBit(int num) {
		if(num == 0)
			return 0;
		int k = 1;
		int val = 1;
		while((num & val) == 0) {
			val = 1 << k;
			k++;
		}
		
		num = num ^ val;
		return num;
	}

	public static void main(String[] args) {
		System.out.println(turnOffSetBit(4));
		System.out.println(turnOffSetBit(12));

	}

}
