package com.app.questions.practice;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberLeetcode202 {
	private static int generateSum(int num) {
		int sum = 0;
		int tmp = num;
		while(tmp != 0) {
			int r = tmp % 10;
			sum += (r*r);
			tmp = tmp / 10;
		}
		return sum;
	}
	
	private static boolean isHappy(int num) {
		Set<Integer> set = new HashSet<>();
		while(true) {
			int sum = generateSum(num);
			if(sum == 1)
				return true;
			if(set.contains(sum))
				return false;
			set.add(sum);
			num = sum;
		}
	}

	public static void main(String[] args) {
		int num = 19;
		
		System.out.println(isHappy(num));

	}

}
