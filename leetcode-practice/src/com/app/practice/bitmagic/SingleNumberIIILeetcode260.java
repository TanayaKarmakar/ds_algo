package com.app.practice.bitmagic;

import java.util.Arrays;
import java.util.Scanner;

public class SingleNumberIIILeetcode260 {
	private static int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		int n = nums.length;
		int xor = 0;
		
		for(int i = 0; i < n; i++) {
			xor = xor ^ nums[i];
		}
		
		int mask = (xor & (-xor));
		
		int num1 = 0;
		for(int j = 0; j < n; j++) {
			if((nums[j] & mask) != 0) {
				num1 = num1 ^ nums[j];
			}
		}
		
		int num2 = xor ^ num1;
		
		res[0] = Integer.min(num1, num2);
		res[1] = Integer.max(num1, num2);
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int[] res = singleNumber(nums);
		
		System.out.println(Arrays.toString(res));

		scanner.close();
	}

}
