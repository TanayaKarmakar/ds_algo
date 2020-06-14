package com.app.problems.hackerearth;

import java.util.Arrays;

public class UniqueNumbers2 {
	private static int[] uniqueNumbers(int[] nums) {
		int totalXor = 0;
		for(int num: nums) {
			totalXor = totalXor ^ num;
		}
		
		//get the first set bit
		int i = 0;
		int temp = totalXor;
		while((temp & (1 << i)) == 0) {
			i++;
		}
		
		//now xor the numbers for which the bit at ith position is set
		int targetXor = 0;
		for(int num: nums) {
			int currentLastBit = (num & (1 << i));
			if(currentLastBit != 0) {
				targetXor = targetXor ^ num;
			}
		}
		
		int num1 = targetXor;
		int num2 = totalXor ^ targetXor;
		
		return new int[] {Integer.min(num1, num2), Integer.max(num1, num2)};
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] out = uniqueNumbers(nums);
		
		System.out.println(Arrays.toString(out));
		
		nums = new int[] {3, 1, 2, 1};
		
		out = uniqueNumbers(nums);
		
		System.out.println(Arrays.toString(out));
		
	}

}
